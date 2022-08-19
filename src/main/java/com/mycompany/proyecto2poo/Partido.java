/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Davinsonm
 */
public class Partido {
   private String Fecha,Descripcion,Fase,Estadio,Ciudad,equipoLocal,equipoVisitante,nombreImg;
   private int equipoLocalGoals,equipoVisitanteGoals;
   public Partido(String fecha,String desc,String fase,String estadio,String ciudad,String Local,String Visitante, String nomImg,int localGoles, int visitanteGoles){
       this.Fecha=fecha;
       this.Descripcion=desc;
       this.Ciudad=ciudad;
       this.equipoLocal=Local;
       this.equipoVisitante=Visitante;
       this.Estadio=estadio;
       this.Fase=fase;
       this.nombreImg=nomImg;
       this.equipoLocalGoals=localGoles;
       this.equipoVisitanteGoals=visitanteGoles;
   }
   public String getFecha(){
       return this.Fecha;
   }
   public void setFecha(String Fecha){
       this.Fecha=Fecha;
   }
   public String getDescripcion(){
       return this.Descripcion;
   }
   public void setDescripcion(String desc){
       this.Descripcion=desc;
   }
   public String getCiudad(){
       return this.Ciudad;
   }
   public void setCiudad(String Ciudad){
       this.Ciudad=Ciudad;
   }
   public String getequipoLocal(){
       return this.equipoLocal;
   }
   public void setequipoLocal(String local){
       this.equipoLocal=local;
   }
   public String getequipoVisitante(){
       return this.equipoVisitante;
   }
   public void setequipoVisitante(String visitante){
       this.equipoVisitante=visitante;
   }
   public String getEstadio(){
       return this.Estadio;
   }
   public void setEstadio(String estadio){
       this.Estadio=estadio;
   }
   public String getFase(){
       return this.Fase;
   }
   public void setFase(String fase){
       this.Fase=fase;
   }
   public String getnombreImg(){
       return this.nombreImg;
   }
   public void setnombreImg(String nombreImg){
       this.nombreImg=nombreImg;
   }
   public int getequipoLocalGoals(){
       return this.equipoLocalGoals;
   }
   public void setequipoLocalGoals(int localGoles){
       this.equipoLocalGoals=localGoles;
   }
   public int getequipoVisitanteGoals(){
       return this.equipoVisitanteGoals;
   }
   public void setequipoVisitanteGoals(int visitanteGoles){
       this.equipoVisitanteGoals=visitanteGoles;
   }
}
