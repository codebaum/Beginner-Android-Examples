package com.codebaum.beginnerandroidexamples.examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codebaum.beginnerandroidexamples.R;
import com.codebaum.beginnerandroidexamples.darksky.DarkSky;
import com.codebaum.beginnerandroidexamples.darksky.DarkSkyService;
import com.codebaum.beginnerandroidexamples.utils.JavaUtils;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class AdvancedActivity extends AppCompatActivity {

    private String nullableVar = "java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        // add code to read the following:
        // 1. user location, i.e. Google Play services and Permissions example TODO: use lib from Firebase-UI?
        // 2. Dark Sky forecast from user location, i.e. connecting to an API example
        // 3. upload some data to FireStore/RDB, i.e. using Firebase

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.darksky.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DarkSkyService service = retrofit.create(DarkSkyService.class);

        Call<DarkSky> call = service.getCurrentConditions("1ed77fc4262da51d8e96ed8e94f8c2b0", 37.8267, -122.4233);
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
}
