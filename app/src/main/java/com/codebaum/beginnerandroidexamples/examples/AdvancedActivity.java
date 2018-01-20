package com.codebaum.beginnerandroidexamples.examples;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.darksky.DarkSky;
import com.codebaum.beginnerandroidexamples.darksky.DarkSkyService;
import com.codebaum.beginnerandroidexamples.utils.JavaUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class AdvancedActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private DarkSkyService service;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // add code to read the following:
        // 1. user location, i.e. Google Play services and Permissions example TODO: use lib from Firebase-UI?
        // 2. Dark Sky forecast from user location, i.e. connecting to an API example
        // 3. upload some data to FireStore/RDB, i.e. using Firebase

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.darksky.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(DarkSkyService.class);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                onLocationFound(location);
            }
        });
    }

    private void onLocationFound(Location location) {
        // Got last known location. In some rare situations this can be null.
        if (location != null) {
            // Logic to handle location object
            requestWeatherConditions(location);
        }
    }

    private void requestWeatherConditions(Location location) {
        Call<DarkSky> call = service.getCurrentConditions("1ed77fc4262da51d8e96ed8e94f8c2b0", location.getLatitude(), location.getLongitude());
        call.enqueue(new Callback<DarkSky>() {
            @Override
            public void onResponse(Call<DarkSky> call, Response<DarkSky> response) {
                DarkSky darkSky = response.body();
                JavaUtils.quickToast(AdvancedActivity.this, "Current temp: " + darkSky.getCurrently().getTemperature());
            }

            @Override
            public void onFailure(Call<DarkSky> call, Throwable t) {
                JavaUtils.quickToast(AdvancedActivity.this, "Unable to get current temp.");
            }
        });
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "Unable to get user location.", Toast.LENGTH_SHORT).show();
    }
}
