package com.example.android.weather_app.gsonData;

import com.google.gson.annotations.SerializedName;

import static android.R.attr.id;

/**
 * Created by kevinsun on 11/2/17.
 */

public class CityInfo {



    private String name;

    @SerializedName("coord")
    private CoordInfo coordInfo;

    private String country;

    public static class CoordInfo{

        private double lat;

        private double lon;

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

    public String getName() {
        return name;
    }

    public CoordInfo getCoordInfo() {
        return coordInfo;
    }

    public String getCountry() {
        return country;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCoordInfo(CoordInfo coordInfo) {
        this.coordInfo = coordInfo;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
