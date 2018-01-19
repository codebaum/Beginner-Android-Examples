package com.codebaum.beginnerandroidexamples.darksky;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 */

public interface DarkSkyService {

    // apiKey = 1ed77fc4262da51d8e96ed8e94f8c2b0
    // latitude = 37.8267
    // longitude = -122.4233
    @GET("forecast/{apiKey}/{latitude},{longitude}?exclude=minutely,hourly,daily,alerts,flags")
    Call<DarkSky> getCurrentConditions(@Path("apiKey") String apiKey, @Path("latitude") double latitude, @Path("longitude") double longitude);
}
