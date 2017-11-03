package com.example.android.weather_app.util;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.android.weather_app.gsonData.CityInfo;
import com.example.android.weather_app.gsonData.WeatherDisplay;
import com.example.android.weather_app.gsonData.WeatherList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinsun on 11/3/17.
 */

public class Utility {


    public static boolean handleCodReponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONObject jsonObject = new JSONObject(response);

                WeatherDisplay weatherDisplay = new WeatherDisplay();

                weatherDisplay.setCod(jsonObject.getInt("cod"));

                if(weatherDisplay.getCod() == 200){
                    return  true;
                }else {
                    return  false;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @Nullable
    public static List<WeatherList> handleListReponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONObject jsonObject = new JSONObject(response);

                JSONArray jsonArray = jsonObject.getJSONArray("list");
                List<WeatherList> weather = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    WeatherList weatherList = new WeatherList();

                    weatherList.setDt(jsonObject1.getLong("dt"));
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("main");

                    WeatherList.MainInfo mainInfo = new WeatherList.MainInfo();
                    mainInfo.setTemp(jsonObject2.getDouble("temp"));
                    mainInfo.setTemp_min(jsonObject2.getDouble("temp_min"));
                    mainInfo.setTemp_max(jsonObject2.getDouble("temp_max"));
                    mainInfo.setPressure(jsonObject2.getDouble("pressure"));
                    mainInfo.setSea_level(jsonObject2.getDouble("sea_level"));
                    mainInfo.setGrnd_level(jsonObject2.getDouble("grnd_level"));
                    mainInfo.setHumidity(jsonObject2.getInt("humidity"));
                    mainInfo.setTemp_kf(jsonObject2.getDouble("temp_kf"));

                    weatherList.setMainInfo(mainInfo);

                    JSONArray jsonArray1 = jsonObject1.getJSONArray("weather");

                    List<WeatherList.WeatherInfo> list = new ArrayList<>();

                    for (int j = 0; j < jsonArray1.length(); j++) {
                        JSONObject jsonObject3 = jsonArray1.getJSONObject(j);

                        WeatherList.WeatherInfo weatherInfo = new WeatherList.WeatherInfo();
                        weatherInfo.setId(jsonObject3.getInt("id"));
                        weatherInfo.setMain(jsonObject3.getString("main"));
                        weatherInfo.setDescription(jsonObject3.getString("description"));
                        weatherInfo.setIcon(jsonObject3.getString("icon"));

                        list.add(weatherInfo);
                    }

                    weatherList.setWeathherInfoList(list);

                    JSONObject jsonObject4 = jsonObject1.getJSONObject("clouds");
                    WeatherList.CloudsInfo cloudsInfo = new WeatherList.CloudsInfo();
                    cloudsInfo.setAll(jsonObject4.getInt("all"));

                    weatherList.setCloudsInfo(cloudsInfo);

                    JSONObject jsonObject5 = jsonObject1.getJSONObject("wind");
                    WeatherList.WindInfo windInfo = new WeatherList.WindInfo();
                    windInfo.setSpeed(jsonObject5.getDouble("speed"));
                    windInfo.setDeg(jsonObject5.getInt("deg"));

                    weatherList.setWindInfo(windInfo);

                    weatherList.setDt_txt(jsonObject1.getString("dt_txt"));

                    weather.add(weatherList);

                }

                return weather;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Nullable
    public static CityInfo handleLocationReponse(String reponse) {
        if (!TextUtils.isEmpty(reponse)) {
            try {
                JSONObject jsonObject = new JSONObject(reponse);
                JSONObject jsonObject1 = jsonObject.getJSONObject("city");

                CityInfo cityInfo = new CityInfo();
                cityInfo.setName(jsonObject1.getString("name"));

                JSONObject jsonObject2 = jsonObject1.getJSONObject("coord");
                CityInfo.CoordInfo coordInfo = new CityInfo.CoordInfo();
                coordInfo.setLat(jsonObject2.getDouble("lat"));
                coordInfo.setLon(jsonObject2.getDouble("lon"));
                cityInfo.setCoordInfo(coordInfo);

                cityInfo.setCountry(jsonObject1.getString("country"));

                return cityInfo;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    public static WeatherList handleCurrentReponse(String reponse){
        if(!TextUtils.isEmpty(reponse)){
            try {
                try {
                    JSONObject jsonObject = new JSONObject(reponse);
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
