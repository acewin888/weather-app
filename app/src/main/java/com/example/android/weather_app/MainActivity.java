package com.example.android.weather_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.zipcode_edittext)
    EditText zipCode_EditText;

    @BindView(R.id.enter_button)
    Button enter_Button;


    private final String API_KEY = "70c9bfb67885b40a5f3f22eca2ccba90";

    private String iconCode = "";

    private String icon = "http://openweathermap.org/img/w/" + iconCode + ".png";

    public static final String ZIP = "ZIPCODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);




        enter_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int zipCode = Integer.parseInt(zipCode_EditText.getText().toString());
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);

                intent.putExtra(ZIP, zipCode);

                startActivity(intent);
            }
        });
    }
}
