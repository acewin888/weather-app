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


    public static class MainInfo {

        private double temp;

        private double temp_min;

        private double temp_max;

        private double pressure;

        private double sea_level;

        private double grnd_level;

        private int humidity;

        private double temp_kf;

        public double getTemp() {
            return temp;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }

        public double getPressure() {
            return pressure;
        }

        public double getSea_level() {
            return sea_level;
        }

        public double getGrnd_level() {
            return grnd_level;
        }

        public int getHumidity() {
            return humidity;
        }

        public double getTemp_kf() {
            return temp_kf;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public void setSea_level(double sea_level) {
            this.sea_level = sea_level;
        }

        public void setGrnd_level(double grnd_level) {
            this.grnd_level = grnd_level;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public void setTemp_kf(double temp_kf) {
            this.temp_kf = temp_kf;
        }
    }

    public static class WeatherInfo {

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

        public void setId(int id) {
            this.id = id;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class CloudsInfo {

        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }
    }

    public static class WindInfo {

        private double speed;

        private double deg;

        public double getSpeed() {
            return speed;
        }

        public double getDeg() {
            return deg;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public void setDeg(double deg) {
            this.deg = deg;
        }
    }

    public class SnowInfo {

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

    public void setDt(long dt) {
        this.dt = dt;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public void setWeathherInfoList(List<WeatherInfo> weathherInfoList) {
        this.weathherInfoList = weathherInfoList;
    }

    public void setCloudsInfo(CloudsInfo cloudsInfo) {
        this.cloudsInfo = cloudsInfo;
    }

    public void setWindInfo(WindInfo windInfo) {
        this.windInfo = windInfo;
    }

    public void setSnowInfo(SnowInfo snowInfo) {
        this.snowInfo = snowInfo;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
