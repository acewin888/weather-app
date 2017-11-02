package com.example.android.weather_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private final String API_KEY = "70c9bfb67885b40a5f3f22eca2ccba90";

    private String iconCode = "";

    private String icon = "http://openweathermap.org/img/w/" + iconCode + ".png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
