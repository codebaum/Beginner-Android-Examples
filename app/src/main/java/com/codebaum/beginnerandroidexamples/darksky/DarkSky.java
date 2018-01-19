package com.codebaum.beginnerandroidexamples.darksky;

/**
 *
 */

public class DarkSky {
    private String timezone;

    private Currently currently;

    private String longitude;

    private String latitude;

    private String offset;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "ClassPojo [timezone = " + timezone + ", currently = " + currently + ", longitude = " + longitude + ", latitude = " + latitude + ", offset = " + offset + "]";
    }
}