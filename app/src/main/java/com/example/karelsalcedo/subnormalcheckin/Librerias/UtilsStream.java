package com.example.karelsalcedo.subnormalcheckin.Librerias;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Karel Salcedo on 09/11/2016.
 */

public class UtilsStream {

    private static final int MODELO_MINIMO = 1920;
    private static final int MODELO_MAXIMO = 2018;

    static public String inputStreamToString(InputStream content) {
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        //StringBuffer buffer = new StringBuffer();
        BufferedReader rd = new BufferedReader( new InputStreamReader(content) );
        try
        {
            while( (line = rd.readLine()) != null )
            {
                stringBuilder.append(line + "\r\n");
                //buffer.append(line);
            }
        }
        catch( IOException e)
        {
            e.printStackTrace();
        }
        //return  buffer.toString();
        return stringBuilder.toString();
    }

    public static Bitmap LoadPhoto(int width, int height, String path){
        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/width, photoH/height);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        return BitmapFactory.decodeFile(path, bmOptions);
    }

    public static File getOutputMediaFile(Context context) {
        //Verificamos que exista el almacenamiento externo
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state))
            return null;

        //Directorio donde se guardara el archivo
        File directorio = new File(context.getExternalFilesDir(null), "imagenes");
        if(!directorio.exists()){
            if(!directorio.mkdirs())
                return null;
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        return new File(directorio, "IMG_" + timeStamp + ".jpg");
    }

    public static String getMonthName(int month){
        String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        return months[month];
    }

    public static boolean validateData(String data){
        if(data == null || data.length() == 0)
            return false;

        //No contiene ningun caracter que no sea espacio
        if(data.matches("\\s*"))
            return false;

        //Contiene caracteres especiales
        if(!data.matches("[\\w+[.|\\-]?\\s*]*"))
            return false;

        return true;
    }

    public static float tryParseFloat(String s){
        if(s == null)
            return -1;
        float r;
        try {
            r = Float.parseFloat(s);
        }catch (NumberFormatException e){
            r = -1;
        }
        return r;
    }

    public static String parseFloatToString(float f){
        String s = String.valueOf(f);
        if(s.contains(".")){
            int posDot = s.indexOf(".");
            if(s.substring(posDot + 1).length() == 1)
                s = s.concat("0");
            else if (s.substring(posDot + 1).length() > 2)
                s = s.substring(0, posDot + 3);
        }
        else{
            s = s.concat(".00");
        }
        return s;
    }

    public static boolean isScreenLandscape(Activity activity){
        int o = activity.getResources().getConfiguration().orientation;
        return (o == Configuration.ORIENTATION_LANDSCAPE);
    }

    public static boolean validateModel(String model){
        int modelo = 0;
        try {
            modelo = Integer.parseInt(model);
        }catch (NumberFormatException e){}

        return (modelo >= MODELO_MINIMO && modelo <= MODELO_MAXIMO);
    }
}

