package com.example.frikial20;

public class Score {

    private String nombre;
    private int puntuacion;
    private int correctas;
    private int falladas;
    private int total;

    public Score(String name, int score, int correct, int wrong, int all){
        this.nombre=name;
        this.puntuacion = score;
        this.correctas=correct;
        this.falladas=wrong;
        this.total=all;
    }

    public Score getScore(){
        return this;
    }

    public void overwriteName(String name){
        this.nombre=name;
    }

}
