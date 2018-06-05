package com.example.karelsalcedo.subnormalcheckin.Controladores;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.karelsalcedo.subnormalcheckin.Modelo.DatosInvitado;
import com.example.karelsalcedo.subnormalcheckin.R;

public class ReviewActivity extends AppCompatActivity {
    TextView Nombre, Acceso;
    ImageView Foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        setViews();
        getData();
    }

    private void setViews(){
        Nombre = (TextView)findViewById(R.id.Nom_date);
        Acceso = (TextView)findViewById(R.id.acceso);
        Foto = (ImageView)findViewById(R.id.foto);
    }

    private void getData(){
        DatosInvitado datosInvitado = new DatosInvitado();
        Nombre.setText(datosInvitado.getNombre());
        Acceso.setText(datosInvitado.getTipo_Acceso());

    }

    public void OK(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("¿Los datos son correctos con los de la persona presente?");
        builder.show();
    }

    public void back(View view) {
        Intent intent = new Intent(ReviewActivity.this, PreviewActivity.class);
        startActivity(intent);
    }
}
