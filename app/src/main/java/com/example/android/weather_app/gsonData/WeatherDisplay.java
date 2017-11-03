package com.example.android.weather_app.gsonData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kevinsun on 11/2/17.
 */

public class WeatherDisplay {

    @SerializedName("list")
    private List<WeatherList> weatherList;

    @SerializedName("city")
    private CityInfo cityInfo;

    private int cod;


    public int getCod() {
        return cod;
    }

    public void setCod(int cod){
        this.cod = cod;
    }


    public List<WeatherList> getWeatherList() {
        return weatherList;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setWeatherList(List<WeatherList> weatherList) {
        this.weatherList = weatherList;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }
}
