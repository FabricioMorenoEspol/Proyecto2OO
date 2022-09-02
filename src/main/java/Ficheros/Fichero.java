/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ficheros;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import modelo.*;
import com.mycompany.proyecto2poo.App;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * @author fabricio
 */
public class Fichero implements Serializable{

    public static ArrayList<Partido> leerDatosPartidos(String nombreArchivo) {
        ArrayList<Partido> partidos = new ArrayList<>();

        try ( FileReader reader = new FileReader(new File(App.pathTxt + nombreArchivo), StandardCharsets.UTF_8);  BufferedReader bf = new BufferedReader(reader)) {
            bf.readLine();

            String linea = bf.readLine();

            while (linea != null) {
                String[] info = linea.split("\\|");

                String fecha = info[1].trim().split("-")[0].trim();
                String descripcion = info[1].trim();
                String fase = info[2].trim();
                String estadio = info[3].trim();
                String ciudad = info[4].trim();
                String equipoLocal = info[5].trim();
                int equipoLocalGoals = Integer.valueOf(info[6].trim());
                String equipoVisitante = info[8].trim();
                int equipoVisitanteGoals = Integer.valueOf(info[7].trim());
                String nombreImgEquipoLocal = info[5].trim() + ".jpg";
                String nombreImgEquipoVisitante = info[8].trim() + ".jpg";
                String inicialesEquipoLocal = info[18].trim();
                String inicialesEquipoVisitante = info[19].trim();

                Partido partido = new Partido(fecha, descripcion, fase, estadio, ciudad, equipoLocal, equipoVisitante, nombreImgEquipoLocal, nombreImgEquipoVisitante, equipoLocalGoals, equipoVisitanteGoals, inicialesEquipoLocal, inicialesEquipoVisitante);

                //No agregar registros repetidos
                if (!partidos.contains(partido)) {
                    partidos.add(partido);
                }

                linea = bf.readLine();
            }

        } catch (Exception e) {
            System.out.println("Error al cargar informacion de los partidos");
        }

        return partidos;
    }

    public static ArrayList<Jugador> leerDatosJugadores(String nombreArchivo) {
        ArrayList<Jugador> jugadores = new ArrayList<>();

        try ( FileReader reader = new FileReader(new File(nombreArchivo), StandardCharsets.UTF_8);  BufferedReader bf = new BufferedReader(reader)) {
            bf.readLine();

            String linea = bf.readLine();
            while (linea != null) {
                String[] info = linea.trim().split(",");

                String nombreJugador = info[6];
                String nombreEquipo = info[2];
                int numeroCamiseta = Integer.valueOf(info[5]);
                String directorTecnico = info[3];
                String NombreImg = info[6] + ".jpg";
                
                Jugador jugador = new Jugador(nombreJugador, nombreEquipo, numeroCamiseta, directorTecnico, NombreImg);
                jugadores.add(jugador);

                linea = bf.readLine();
            }
            System.out.println(linea);
        } catch (Exception err) {
            System.out.println("Error al leer el archivo");
        }

        return jugadores;
    }

    public static void serializarListaJugadores(ArrayList<Jugador> jugadores) {
        
        try ( FileOutputStream fs = new FileOutputStream("SerializacionJugadores.txt");  ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(jugadores);

        } catch (Exception e) {
            System.out.println("Error al serializar los datos de jugadores");
        }

        
    }

}
