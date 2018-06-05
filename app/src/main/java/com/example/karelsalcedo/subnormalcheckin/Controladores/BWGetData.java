package com.example.karelsalcedo.subnormalcheckin.Controladores;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.karelsalcedo.subnormalcheckin.Librerias.UtilsStream;
import com.example.karelsalcedo.subnormalcheckin.Modelo.DatosInvitado;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import javax.net.ssl.HttpsURLConnection;

public class BWGetData extends AsyncTask<Object, Object, String> {
    DatosInvitado datosInvitado = new DatosInvitado();
    ProgressDialog dialog, dialog1;
    Context context;
    AlertDialog alertDialog;

    public BWGetData(Context context, DatosInvitado datosInvitado) {

        this.context = context;
        this.datosInvitado = datosInvitado;
    }


    @Override
    protected String doInBackground(Object... params) {
        Object type = params[0];
        String url_checkin = "http://www.bstrct.com/correo/";
        if (type.equals("CheckIn")) ;
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID_Usuario", datosInvitado.getResultado());
            OutputStream os = null;
            InputStream is = null;
            HttpURLConnection conn = null;
            //constants
            URL url = new URL(url_checkin);
            String message = jsonObject.toString();
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(message.getBytes().length);
            //make some HTTP header nicety
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            //open
            conn.connect();
            //setup send
            os = new BufferedOutputStream(conn.getOutputStream());
            os.write(message.getBytes());
            //clean up
            os.flush();
            //do somehting with response
            is = conn.getInputStream();
            if (is != null) {
                String jsonResult = UtilsStream.inputStreamToString(is);
                return jsonResult;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
            dialog = ProgressDialog.show(context, "¡Espere por favor!", "Estamos verificando tu información.", false, false);
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Error");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            try {
                String status;

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                status = jsonObject.getString("status");

                if (status.equals("100")) {
                    String Nombre, Tipo, Foto;
                    Nombre = jsonObject.getString("Nombre");
                    datosInvitado.setNombre(Nombre);
                    Tipo = jsonObject.getString("Tipo");
                    datosInvitado.setTipo_Acceso(Tipo);
                    Foto = jsonObject.getString("Foto");
                    datosInvitado.setFoto(Foto);
                    Intent intent = new Intent(context, ReviewActivity.class);
                    context.startActivity(intent);
                }
                else {
                    AlertDialog.Builder db = new AlertDialog.Builder(context);
                    db.setTitle("Error al cargar los datos.");
                    db.setMessage("Intente escanear el codigo denuevo, si no contacte con soporte tecnico.");
                    db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context, PreviewActivity.class);
                            context.startActivity(intent);
                        }
                    });
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }}
    @Override
    protected void onProgressUpdate(Object... values) {
        super.onProgressUpdate(values);
    }


}
