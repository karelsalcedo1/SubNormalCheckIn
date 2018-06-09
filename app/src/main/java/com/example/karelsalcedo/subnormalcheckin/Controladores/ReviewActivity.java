package com.example.karelsalcedo.subnormalcheckin.Controladores;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
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
        Acceso = (TextView)findViewById(R.id.acceso2);
        Foto = (ImageView)findViewById(R.id.foto);
    }

    private void getData(){
        DatosInvitado datosInvitado = new DatosInvitado();
        String[] parts = datosInvitado.getResultado().split("-");
        datosInvitado.setNombre(parts[0]);
        datosInvitado.setTipo_Acceso(parts[1]);
        Nombre.setText(datosInvitado.getNombre());
        Acceso.setText(datosInvitado.getTipo_Acceso());

    }

    public void OK(View view) {
        AlertDialog.Builder db = new AlertDialog.Builder(ReviewActivity.this);
        db.setTitle("Alerta");
        db.setMessage("¿Los datos son correctos con los de la persona presente?");
        db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ReviewActivity.this, PreviewActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog dialog = db.show();
    }

    public void back(View view) {
        Intent intent = new Intent(ReviewActivity.this, PreviewActivity.class);
        startActivity(intent);
    }
}
