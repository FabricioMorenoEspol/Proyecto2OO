package com.mycompany.proyecto2poo;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Davinsonm
 */
public class Jugador {
    private String Nombre,nombreJugador,nombreEquipo,directorTecnico,NombreImg;
    private int numeroCamiseta;
    public Jugador(String nombre,String nombreJugador,String nombreEquipo,int numeroCamiseta, String DirectorTecnico,String NombreImg  ){
        this.Nombre=nombre;
        this.nombreJugador=nombreJugador;
        this.nombreEquipo=nombreEquipo;
        this.numeroCamiseta=numeroCamiseta;
        this.directorTecnico=DirectorTecnico;
        this.NombreImg=NombreImg;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre=nombre;
    }
    public String getnombrejugador(){
        return this.nombreJugador;
    }
    public void setnombreJugador(String nomJugador){
        this.nombreJugador=nomJugador;
    }
    public String getnombreEquipo(){
        return this.nombreEquipo;
    }
    public void setnombreEquipo(String nomEquipo){
        this.nombreEquipo=nomEquipo;
    }
    public int getnumeroCamiseta(){
        return this.numeroCamiseta;
    }
    public void setnumeroCamiseta(int numCam){
        this.numeroCamiseta=numCam;
    }
    public String getdirectorTecnico(){
        return this.directorTecnico;
    }
    public void setdirectorTecnico(String dt){
        this.directorTecnico=dt;
    }
    public String getNombreImg(){
        return this.NombreImg;
    }
    public void setNombreImg(String nomImg){
        this.NombreImg=nomImg;
    }
}