package com.example.myraces.core;

public class Races {

    private String nombre;
    private String fecha;
    private String hora;
    private String distancia;
    private String superficie;

    public Races(String nombre, String fecha, String hora, Integer distancia,String superficie){
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.distancia = distancia.toString();
        this.superficie = superficie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "Nombre: "+ getNombre()+"\n"+
                "Fecha "+ getFecha()+"\n"+
                "Hora "+getHora()+"\n"+
                "Distancia "+ getDistancia()+"\n"+
                "Superficie "+getSuperficie();

    }
}
