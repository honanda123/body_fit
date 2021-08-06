package com.example.body_fit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CardView home,profile,stopwatch,information,calculator;
    EditText email,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.profile);
        home = findViewById(R.id.home);
        stopwatch = findViewById(R.id.stopwatch);
        information = findViewById(R.id.information);
        calculator = findViewById(R.id.calculator);




        profile.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,ProfileActivity.class));

        });
        stopwatch.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,StopwatchActivity.class));

        });
        information.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,InformationActivity.class));

        });
        calculator.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,KalkulatorActivity.class));

        });





    }
}