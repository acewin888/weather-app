package com.example.android.weather_app.gsonData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kevinsun on 11/2/17.
 */

public class WeatherList {

    @SerializedName("dt")
    private long dt;

    @SerializedName("main")
    private MainInfo mainInfo;

    @SerializedName("weather")
    private List<WeatherInfo> weathherInfoList;

    @SerializedName("clouds")
    private CloudsInfo cloudsInfo;

    @SerializedName("wind")
    private WindInfo windInfo;

    @SerializedName("snow")
    private SnowInfo snowInfo;

    @SerializedName("dt_txt")
    private String dt_txt;


    public class MainInfo{

        private float temp;

        private float temp_min;

        private float temp_max;

        private float pressure;

        private float sea_level;

        private float grnd_level;

        private int humidity;

        private float temp_kf;

        public float getTemp() {
            return temp;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public float getTemp_max() {
            return temp_max;
        }

        public float getPressure() {
            return pressure;
        }

        public float getSea_level() {
            return sea_level;
        }

        public float getGrnd_level() {
            return grnd_level;
        }

        public int getHumidity() {
            return humidity;
        }

        public float getTemp_kf() {
            return temp_kf;
        }
    }

    public class WeatherInfo{

        private int id;

        private String main;

        private String description;

        private String icon;

        public int getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }

    public class CloudsInfo{

        private int all;

        public int getAll() {
            return all;
        }
    }

    public class WindInfo{

        private float speed;

        private float deg;

        public float getSpeed() {
            return speed;
        }

        public float getDeg() {
            return deg;
        }
    }

    public class SnowInfo{

        // need to write private field

    }


    public long getDt() {
        return dt;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public List<WeatherInfo> getWeathherInfoList() {
        return weathherInfoList;
    }

    public CloudsInfo getCloudsInfo() {
        return cloudsInfo;
    }

    public WindInfo getWindInfo() {
        return windInfo;
    }

    public SnowInfo getSnowInfo() {
        return snowInfo;
    }

    public String getDt_txt() {
        return dt_txt;
    }
}
