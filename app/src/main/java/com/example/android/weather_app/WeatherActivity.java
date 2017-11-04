package com.example.android.weather_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.weather_app.gsonData.CityInfo;
import com.example.android.weather_app.gsonData.WeatherList;
import com.example.android.weather_app.util.HttpUtil;
import com.example.android.weather_app.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {


    @BindView(R.id.nav_button)
    Button homeButton;

    @BindView(R.id.title_city)
    TextView city_textView;

    @BindView(R.id.title_update_time)
    TextView update_time_textView;

    @BindView(R.id.condition_text)
    TextView condition_textview;

    @BindView(R.id.degree_text)
    TextView degree_textView;

    @BindView(R.id.weather_info_text)
    TextView weather_info_textView;


    @BindView(R.id.pressure_text)
    TextView pressure_textView;

    @BindView(R.id.humidity_text)
    TextView humidity_textView;


    @BindView(R.id.forecast_layout)
    LinearLayout forecaseLayout;

    public static final String ZIPCODE_BASEURL_FORECAST = "http://api.openweathermap.org/data/2.5/forecast?zip=";

    public static final String ZIPCODE_BASEURL_CURRENT = "http://api.openweathermap.org/data/2.5/weather?zip=";

    public static final String API_KEY = "&APPID=70c9bfb67885b40a5f3f22eca2ccba90";

    private List<WeatherList> weatherLists;

    private CityInfo cityInfo;

    private WeatherList currentWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        int zipCode = getIntent().getIntExtra(MainActivity.ZIP, 0);

        requestCurrentWeather(zipCode);

        requestWeatherForecast(zipCode);
    }

    private void requestWeatherForecast(int zipCode) {

        String zipCodeUrl = ZIPCODE_BASEURL_FORECAST + zipCode + API_KEY;

        HttpUtil.sendHttpRequest(zipCodeUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String responseText = response.body().string();


                if (Utility.handleCodReponse(responseText)) {
                    weatherLists = Utility.handleListReponse(responseText);
                    cityInfo = Utility.handleLocationReponse(responseText);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showForecastInfo(weatherLists);
                            showLocationInfo(cityInfo);
                        }
                    });


                }

            }
        });

    }

    private void requestCurrentWeather(int zipCode){

        String zipCodeUrl = ZIPCODE_BASEURL_CURRENT + zipCode + API_KEY;

        HttpUtil.sendHttpRequest(zipCodeUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();

                if(Utility.handleCodReponse(responseText)){
                    currentWeather = Utility.handleCurrentReponse(responseText);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String description = currentWeather.getWeathherInfoList().get(0).getDescription();
                            String icon = currentWeather.getWeathherInfoList().get(0).getIcon();
                            double temp = currentWeather.getMainInfo().getTemp();
                            double pressure =currentWeather.getMainInfo().getPressure();
                            int humidity =currentWeather.getMainInfo().getHumidity();


                            degree_textView.setText(temp + " ");
                            weather_info_textView.setText(description);

                            pressure_textView.setText(pressure + " ");
                            humidity_textView.setText(humidity + " ");
                        }
                    });
                }

            }
        });
    }

    private void showForecastInfo(List<WeatherList> list) {

        int middleOne = list.size() / 2;

        List<WeatherList> threeList = new ArrayList<>();
        threeList.add(list.get(0));
        threeList.add(list.get(middleOne));
        threeList.add(list.get(list.size() - 1));

        for (int x = 0; x < threeList.size(); x++) {
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecaseLayout, false);
            TextView dateView = (TextView) view.findViewById(R.id.date_text);
            TextView infoView = (TextView) view.findViewById(R.id.info_text);
            TextView maxView = (TextView) view.findViewById(R.id.max_text);
            TextView minView = (TextView) view.findViewById(R.id.min_text);

            String date = threeList.get(x).getDt_txt();
            String info = threeList.get(x).getWeathherInfoList().get(0).getDescription();
            double maxTemp = threeList.get(x).getMainInfo().getTemp_max();
            double minTemp = threeList.get(x).getMainInfo().getTemp_min();

            dateView.setText(date);
            infoView.setText(info);
            maxView.setText(String.valueOf(maxTemp));
            minView.setText(String.valueOf(minTemp));

            forecaseLayout.addView(view);
        }


    }

    private void showLocationInfo(CityInfo cityInfo) {

        String name = cityInfo.getName();
        double lat = cityInfo.getCoordInfo().getLat();
        double lon = cityInfo.getCoordInfo().getLon();

        String country = cityInfo.getCountry();

        String location = name + ", " + country + " ,lat: " + lat + ", lon: " + lon;

        city_textView.setText(location);

    }


}
