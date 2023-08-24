package com.example.myapplication4;

public class Nodos {
    private String nombre;
    private String direccion;


    private String comuna;
    private Double longitud;
    private Double latitud;



    public Nodos(String nombre, String direccion, String comuna, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.comuna = comuna;
        this.longitud = longitud;
        this.latitud = latitud;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComuna() {
        return comuna;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }





}
