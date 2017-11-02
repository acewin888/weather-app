package com.example.android.weather_app.gsonData;

/**
 * Created by kevinsun on 11/2/17.
 */

public class CityInfo {

    private int id;

    private String name;

    private CoordInfo coordInfo;

    private String country;

    public class CoordInfo{

        private float lat;

        private float lon;

        public float getLat() {
            return lat;
        }

        public float getLon() {
            return lon;
        }
    }


    public int getId() {
        return id;
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
}
