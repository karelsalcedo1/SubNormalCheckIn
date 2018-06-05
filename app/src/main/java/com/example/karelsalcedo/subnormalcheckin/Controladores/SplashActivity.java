package com.example.karelsalcedo.subnormalcheckin.Controladores;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.karelsalcedo.subnormalcheckin.R;

public class SplashActivity extends AppCompatActivity {
    public int DURACION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Timer();
    }

    

    private void Timer() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, PreviewActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}