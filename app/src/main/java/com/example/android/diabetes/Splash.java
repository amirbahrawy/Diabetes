package com.example.android.diabetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),LogIn.class));
                finish();
            }
        };
        new Timer().schedule(timerTask,3000);
    }


    }
