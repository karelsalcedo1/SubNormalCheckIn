package com.example.karelsalcedo.subnormalcheckin.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

import com.example.karelsalcedo.subnormalcheckin.R;

public class PreviewActivity extends AppCompatActivity {
    private CameraSource cameraSource;
    private SurfaceView cameraView;
    private final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private String token = "";
    private String tokenanterior = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
    }

    public void help(View view) {
        Intent intent = new Intent(PreviewActivity.this, HelpActivity.class);
        startActivity(intent);
    }
}
