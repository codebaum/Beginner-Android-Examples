package com.codebaum.beginnerandroidexamples.examples;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.darksky.Currently;
import com.codebaum.beginnerandroidexamples.darksky.DarkSky;
import com.codebaum.beginnerandroidexamples.darksky.DarkSkyService;
import com.codebaum.beginnerandroidexamples.utils.JavaUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.codebaum.beginnerandroidexamples.darksky.FirebaseConstants.NODE_REQUESTS;

/**
 *
 */
public class WeatherDetailsActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final String TAG = WeatherDetailsActivity.class.getSimpleName();

    private static final String BASE_URL = "https://api.darksky.net/";

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;

    private DarkSkyService service;
    private FusedLocationProviderClient fusedLocationClient;

    private DatabaseReference database;

    @BindView(R.id.layout_btns)
    LinearLayout buttonsLayout;

    @BindView(R.id.tv_detail1)
    TextView temperatureView;

    @BindView(R.id.tv_detail2)
    TextView windSpeedView;

    @BindView(R.id.tv_detail3)
    TextView windBearingView;

    @BindView(R.id.iv_detail4)
    ImageView iconView;

    @BindView(R.id.tv_detail5)
    TextView precipProbabilityView;

    @BindView(R.id.tv_detail6)
    TextView summaryView;

    private DarkSky lastDarkSky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_details);

        setTitle("Weather Request Details");

        ButterKnife.bind(this);

        // add code to read the following:
        // 3. upload some data to FireStore/RDB, i.e. using Firebase

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(DarkSkyService.class);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        database = FirebaseDatabase.getInstance().getReference();

        // see if we already have a Dark Sky object
        DarkSky existingDarkSky = (DarkSky) getIntent().getSerializableExtra("test"); // passed in from list
        if (existingDarkSky == null && savedInstanceState != null) {
            existingDarkSky = (DarkSky) savedInstanceState.getSerializable("save"); // saved from our previous state
        }

        if (existingDarkSky == null) {
            getCurrentWeatherConditions();
        } else {
            updateUI(existingDarkSky);
            buttonsLayout.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (lastDarkSky != null) {
            outState.putSerializable("save", lastDarkSky);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        DarkSky savedDarkSky = (DarkSky) savedInstanceState.getSerializable("save");
        if (savedDarkSky != null) {
            updateUI(savedDarkSky);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(REQUEST_CODE_LOCATION_PERMISSION)
    public void getCurrentWeatherConditions() {

        if (EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
            fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    onLocationFound(location);
                }
            });
        } else {
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_location),
                    REQUEST_CODE_LOCATION_PERMISSION,
                    Manifest.permission.ACCESS_COARSE_LOCATION);
        }
    }

    private void onLocationFound(Location location) {
        // Got last known location. In some rare situations this can be null.
        if (location != null) {
            // Logic to handle location object
            requestWeatherConditionsWithLocation(location);
        }
    }

    private void requestWeatherConditionsWithLocation(Location location) {
        String apiKey = getString(R.string.dark_sky_api_key);
        Call<DarkSky> call = service.getCurrentConditions(apiKey, location.getLatitude(), location.getLongitude());
        call.enqueue(new Callback<DarkSky>() {
            @Override
            public void onResponse(@NonNull Call<DarkSky> call, @NonNull Response<DarkSky> response) {

                DarkSky darkSky = response.body();
                if (darkSky == null) {
                    onFailure(call, new Throwable("DarkSky object is null"));
                    return;
                }

                String requestedLocation = getString(R.string.requested_location,
                        Double.parseDouble(darkSky.getLatitude()), Double.parseDouble(darkSky.getLongitude()));
                JavaUtils.quickToast(WeatherDetailsActivity.this, requestedLocation);

                Log.d(TAG, darkSky.toString());

                updateUI(darkSky);

                DatabaseReference newReference = database.child(NODE_REQUESTS).push();
                newReference.setValue(darkSky);
            }

            @Override
            public void onFailure(@NonNull Call<DarkSky> call, @NonNull Throwable t) {
                JavaUtils.quickToast(WeatherDetailsActivity.this, "Unable to get current temp.");
            }
        });
    }

    private void updateUI(DarkSky darkSky) {

        lastDarkSky = darkSky;

        Currently currentConditions = darkSky.getCurrently();

        String temperature = currentConditions.getTemperature();
        String temperatureValue = getString(R.string.label_temperature, temperature);
        temperatureView.setText(temperatureValue);

        String windSpeed = currentConditions.getWindSpeed();
        String windSpeedValue = getString(R.string.label_wind_speed, windSpeed);
        windSpeedView.setText(windSpeedValue);

        String windBearing = currentConditions.getWindBearing();
        int windBearingInteger = Integer.valueOf(windBearing);
        String mainDirection = "W";
        if (windBearingInteger < 45 || windBearingInteger > 315) {
            mainDirection = "N";
        } else if (windBearingInteger < 135) {
            mainDirection = "E";
        } else if (windBearingInteger < 225) {
            mainDirection = "S";
        }
        String windBearingValue = getString(R.string.label_wind_bearing, mainDirection);
        windBearingView.setText(windBearingValue);

        String icon = currentConditions.getIcon();
        int iconResId = -1;
        if ("clear-day".equals(icon)) {
            iconResId = R.drawable.icons8_sun_96;
        } else if ("clear-night".equals(icon)) {
            iconResId = R.drawable.icons8_moon_and_stars_96;
        } else if ("rain".equals(icon)) {
            iconResId = R.drawable.icons8_rain_96;
        } else if ("snow".equals(icon)) {
            iconResId = R.drawable.icons8_snow_96;
        } else if ("sleet".equals(icon)) {
            iconResId = R.drawable.icons8_sleet_96;
        } else if ("wind".equals(icon)) {
            iconResId = R.drawable.icons8_windy_weather_96;
        } else if ("fog".equals(icon)) {
            iconResId = R.drawable.icons8_fog_96;
        } else if ("cloudy".equals(icon)) {
            iconResId = R.drawable.icons8_clouds_96;
        } else if ("partly-cloudy-day".equals(icon)) {
            iconResId = R.drawable.icons8_partly_cloudy_day_96;
        } else if ("partly-cloudy-night".equals(icon)) {
            iconResId = R.drawable.icons8_night_96;
        }
        iconView.setImageResource(iconResId);

        String precipProbability = currentConditions.getPrecipProbability();
        String precipProbabilityValue = getString(R.string.label_precip_probability, precipProbability);
        precipProbabilityView.setText(precipProbabilityValue);

        String summary = currentConditions.getSummary();
        String summaryValue = getString(R.string.label_summary, summary);
        summaryView.setText(summaryValue);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        // do nothing
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "Unable to get user location.", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_current_location)
    void onCurrentLocationClicked() {
        getCurrentWeatherConditions();
    }

    @OnClick(R.id.btn_random_location)
    void onRandomLocationClicked() {
        Location location = new Location("dummyProvider");
        Random random = new Random();
        double randLatitude = (random.nextDouble() - 0.5) * 180.0;
        location.setLatitude(randLatitude);
        double randLongitude = (random.nextDouble() - 0.5) * 360.0;
        location.setLongitude(randLongitude);
        requestWeatherConditionsWithLocation(location);
    }
}
