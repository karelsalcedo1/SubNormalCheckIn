package com.example.karelsalcedo.subnormalcheckin.Controladores;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.karelsalcedo.subnormalcheckin.R;

public class SettingsActivity extends AppCompatActivity {
    Switch SwNormal, SwServer;
    Toolbar barramenu;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SwNormal = (Switch)findViewById(R.id.switch1);
        SwServer = (Switch)findViewById(R.id.switch2);
        barramenu = (Toolbar)findViewById(R.id.toolbar);


    }

    public void CKsinServer(View view) {
        if (SwServer.isChecked()){
            SwServer.setChecked(false);
            AlertDialog.Builder db = new AlertDialog.Builder(this);
            db.setTitle("Alerta");
            db.setMessage("Ya puedes escanear los codigos qr.");
            db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    SwServer.setChecked(false);
                }
            });
            AlertDialog dialog = db.show();
        }else {
            AlertDialog.Builder db = new AlertDialog.Builder(this);
            db.setTitle("Alerta");
            db.setMessage("Ya puedes escanear los codigos qr.");
            db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    SwServer.setChecked(false);
                }
            });
            AlertDialog dialog = db.show();
        }
    }

    public void CKconServer(View view) {
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected){
            AlertDialog.Builder db = new AlertDialog.Builder(this);
            db.setTitle("Alerta");
            db.setMessage("Se tiene una buena conexión. Por el momento esta función esta desabilitada, hable con soporte tecnico para mayor información.");
            db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    SwServer.setChecked(false);
                }
            });
            AlertDialog dialog = db.show();
            SwServer.setChecked(false);
        }
        else {
            AlertDialog.Builder db = new AlertDialog.Builder(this);
            db.setTitle("Alerta");
            db.setMessage("No se tiene conexión. Trate de establecer conexión para poder utilizar todas las funcionalidades. Por el momento esta función esta desabilitada, hable con soporte tecnico para mayor información.");
            db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    SwServer.setChecked(false);
                }
            });
            AlertDialog dialog = db.show();
            SwServer.setChecked(false);
        }
    }


    public void CKWIFI(View view) {
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected){
        AlertDialog.Builder db = new AlertDialog.Builder(this);
        db.setTitle("Alerta");
        db.setMessage("Se tiene una buena conexión.");
        db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = db.show();

    }
    else {
            AlertDialog.Builder db = new AlertDialog.Builder(this);
            db.setTitle("Alerta");
            db.setMessage("No se tiene conexión. Trate de establecer conexión para poder utilizar todas las funcionalidades.");
            db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = db.show();

        }
    }
}
