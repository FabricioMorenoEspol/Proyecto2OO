/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Davinsonm
 */
public class Copas {
    private int A�o,golesAnotados,partidosJugados;
    private String Asistencia;
    private String[] puestosPaises=new String[4];
    
    public Copas(int A�o,int golesAnotados,int partidosJugados,String Asistencia,String[]puestosPaises){
        this.A�o=A�o;
        this.golesAnotados=golesAnotados;
        this.partidosJugados=partidosJugados;
        this.Asistencia=Asistencia;
        this.puestosPaises=puestosPaises;
    }
    public int getA�o(){
        return this.A�o;
    }
    public void setA�o(int a�o){
        this.A�o=a�o;
    }
    public int getgolesAnotados(){
        return this.golesAnotados;
    }
    public void setgolesAnotados(int totgoles){
        this.golesAnotados=totgoles;
    }
    public int getpartidosJugados(){
        return this.partidosJugados;
    }
    public void setpartidosJugados(int partidosJugados){
        this.partidosJugados=partidosJugados;
    }
    public String getAsistencia(){
        return this.Asistencia;
    }
    public void setAsistencia(String asistencia){
        this.Asistencia=asistencia;
    }
    public String[] getpuestosPaises(){
        return this.puestosPaises;
    }
    public void setpuestosPaises(String[] puestosPaises){
        this.puestosPaises=puestosPaises;
    }
}
