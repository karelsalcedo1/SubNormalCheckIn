package com.example.karelsalcedo.subnormalcheckin.Controladores;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;

import com.example.karelsalcedo.subnormalcheckin.Modelo.DatosInvitado;
import com.example.karelsalcedo.subnormalcheckin.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class PreviewActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mScannerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        mScannerView = new ZXingScannerView(this);
    }

    public void help(View view) {
        Intent intent = new Intent(PreviewActivity.this, HelpActivity.class);
        startActivity(intent);
    }



    @Override
    public void handleResult(Result result) {

        DatosInvitado datosInvitado = new DatosInvitado();
        String Resultado;
        Resultado = result.getText();
        datosInvitado.setResultado(Resultado);
        String type = "CheckIn";
        BWGetData bwGetData = new BWGetData(context, datosInvitado);
        bwGetData.execute(type);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    public void scan(View view) {
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
}
