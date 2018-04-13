package com.example.redbackpack.partyon;

public class Evento {

    private String nombreevento;
    private String fecha;
    private String lugar;
    private int imagenevento;

    public Evento(String nombreevento, String fecha, String lugar, int imagenevento){

        this.nombreevento = nombreevento;
        this.fecha = fecha;
        this.lugar=lugar;
        this.imagenevento=imagenevento;

    }

    public String getNombreevento(){
        return nombreevento;
    }

    public String getFecha(){
        return fecha;
    }

    public String getLugar(){
        return lugar;
    }
    public int getImagenevento(){
        return imagenevento;
    }

}
