package com.example.karelsalcedo.subnormalcheckin.Modelo;

public class DatosInvitado {
    private static String Resultado;
    private static String Nombre;
    private static String Tipo_Acceso;
    private static String Foto;
    private boolean Acceso;

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo_Acceso() {
        return Tipo_Acceso;
    }

    public void setTipo_Acceso(String tipo_Acceso) {
        Tipo_Acceso = tipo_Acceso;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public boolean isAcceso() {
        return Acceso;
    }

    public void setAcceso(boolean acceso) {
        Acceso = acceso;
    }
}
