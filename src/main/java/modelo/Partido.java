package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Davinsonm
 */
public class Partido implements Comparable<Partido> {

    private String Fecha, Descripcion, Fase, Estadio, Ciudad, equipoLocal, equipoVisitante, nombreImgEquipoVisitante, nombreImgEquipoLocal,inicialesEquipoLocal,inicialesEquipoVisitante;
    private int equipoLocalGoals, equipoVisitanteGoals;

    public Partido(String fecha, String desc, String fase, String estadio, String ciudad, String Local, String Visitante, String nombreImgEquipoLocal, String nombreImgEquipoVisitante, int localGoles, int visitanteGoles,String inicialesEquipoLocal,String inicialesEquipoVisitante) {
        this.Fecha = fecha;
        this.Descripcion = desc;
        this.Ciudad = ciudad;
        this.equipoLocal = Local;
        this.equipoVisitante = Visitante;
        this.Estadio = estadio;
        this.Fase = fase;
        this.nombreImgEquipoLocal = nombreImgEquipoLocal;
        this.nombreImgEquipoVisitante = nombreImgEquipoVisitante;
        this.equipoLocalGoals = localGoles;
        this.equipoVisitanteGoals = visitanteGoles;
        this.inicialesEquipoLocal = inicialesEquipoLocal;
        this.inicialesEquipoVisitante = inicialesEquipoVisitante;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public void setDescripcion(String desc) {
        this.Descripcion = desc;
    }

    public String getCiudad() {
        return this.Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getequipoLocal() {
        return this.equipoLocal;
    }

    public void setequipoLocal(String local) {
        this.equipoLocal = local;
    }

    public String getequipoVisitante() {
        return this.equipoVisitante;
    }

    public void setequipoVisitante(String visitante) {
        this.equipoVisitante = visitante;
    }

    public String getEstadio() {
        return this.Estadio;
    }

    public void setEstadio(String estadio) {
        this.Estadio = estadio;
    }

    public String getFase() {
        return this.Fase;
    }

    public void setFase(String fase) {
        this.Fase = fase;
    }

    public String getNombreImgEquipoVisitante() {
        return nombreImgEquipoVisitante;
    }

    public void setNombreImgEquipoVisitante(String nombreImgEquipoVisitante) {
        this.nombreImgEquipoVisitante = nombreImgEquipoVisitante;
    }

    public String getNombreImgEquipoLocal() {
        return nombreImgEquipoLocal;
    }

    public void setNombreImgEquipoLocal(String nombreImgEquipoLocal) {
        this.nombreImgEquipoLocal = nombreImgEquipoLocal;
    }

    public int getequipoLocalGoals() {
        return this.equipoLocalGoals;
    }

    public void setequipoLocalGoals(int localGoles) {
        this.equipoLocalGoals = localGoles;
    }

    public int getequipoVisitanteGoals() {
        return this.equipoVisitanteGoals;
    }

    public void setequipoVisitanteGoals(int visitanteGoles) {
        this.equipoVisitanteGoals = visitanteGoles;
    }

    public String getInicialesEquipoLocal() {
        return inicialesEquipoLocal; 
    }

    public void setInicialesEquipoLocal(String inicialesEquipoLocal) {
        this.inicialesEquipoLocal = inicialesEquipoLocal;
    }

    public String getInicialesEquipoVisitante() {
        return inicialesEquipoVisitante;
    }

    public void setInicialesEquipoVisitante(String inicialesEquipoVisitante) {
        this.inicialesEquipoVisitante = inicialesEquipoVisitante;
    }
    

    @Override
    public int compareTo(Partido partido) {
        return this.equipoLocal.compareTo(partido.getequipoLocal());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        } else {
            Partido part = (Partido) o;
            return part.getequipoLocal().equals(this.getequipoLocal()) && part.getequipoVisitante().equals(this.getequipoVisitante());
        }

    }
    
    @Override
    public String toString(){
        return this.equipoLocal;
    }
}
