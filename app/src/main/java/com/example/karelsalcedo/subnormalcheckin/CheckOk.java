package com.example.karelsalcedo.subnormalcheckin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.karelsalcedo.subnormalcheckin.Controladores.PreviewActivity;
import com.example.karelsalcedo.subnormalcheckin.Modelo.DatosInvitado;

public class CheckOk extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ok);
        txt = (TextView)findViewById(R.id.textView6);
        DatosInvitado datosInvitado = new DatosInvitado();
        txt.setText(datosInvitado.getResultado());
    }

    public void bcj(View view){
        Intent intent = new Intent(this, PreviewActivity.class);
        startActivity(intent);
    }
}
