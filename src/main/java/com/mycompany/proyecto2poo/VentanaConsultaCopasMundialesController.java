/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2poo;

import errores.ErrorChecked;
import interfaces.VentanaInicializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import modelo.Copas;
import Ficheros.*;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author fabricio
 */
public class VentanaConsultaCopasMundialesController implements Initializable {

    /**
     * Initializes the controller class.
     *
     */
    @FXML
    HBox infoHbox;

    @FXML
    TextField anioTF;

    public static ArrayList<Copas> copasMundiales = Fichero.leerDatosCopasMundiales(App.pathTxt + "WorldCups.csv");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    @FXML
    public void consultarCopasMundiales() {
        infoHbox.getChildren().clear();
        try {

            int anioCopaMundial = Integer.valueOf(anioTF.getText());
            Copas copaMundialSeleccionada = cargarCopaMundialPorAño(anioCopaMundial);

            //MONTAJE DE TODOS LOS COMPONENTES EN EL INFOHBOX
            //PARTE IZQUIERDA
            VBox premios = new VBox();
            Label titulo1 = new Label("Premios");
            titulo1.setStyle("-fx-font-size:25;");
            VBox infoPremios = new VBox();

            String[] tiposGanadores = new String[]{"Ganador", "Segundo", "Tercero", "Cuarto"};
            int ganadorN = 0;

            for (String pais : copaMundialSeleccionada.getpuestosPaises()) {
                HBox padre = new HBox();
                Label tipoGanador = new Label(tiposGanadores[ganadorN]);
                tipoGanador.setMinWidth(110);
                Label paisLabel = new Label(pais);
                paisLabel.setMinWidth(110);
                HBox copasMundialesImg = new HBox();

                padre.getChildren().addAll(tipoGanador, paisLabel);

                int totalCopasMundiales = cargarTotalDeCopasMundialesPorPais(pais);
                for (int i = 0; i < totalCopasMundiales; i++) {
                    try ( FileInputStream fs = new FileInputStream(App.pathImages + "copa.png")) {
                        Image img = new Image(fs);
                        ImageView imgvw = new ImageView();
                        imgvw.setImage(img);
                        imgvw.setFitHeight(20);
                        imgvw.setFitWidth(20);
                        copasMundialesImg.getChildren().add(imgvw);
              

                    } catch (Exception e) {
                        System.out.println("No se puede leer la imagen de la copa");
                    }

                }

                padre.getChildren().add(copasMundialesImg);
                infoPremios.getChildren().add(padre);

                ganadorN++;
            }

            premios.getChildren().addAll(titulo1, new Label(""), infoPremios);

            infoHbox.setPadding(new Insets(20));
            infoHbox.setSpacing(300);
            infoHbox.getChildren().add(premios);

            //PARTE DERECHA
            VBox datos = new VBox();
            Label titulo2 = new Label("Datos generales");
            titulo2.setStyle("-fx-font-size:25;");
            
            Label l1 = new Label("Goles anotados: " + Integer.toString(copaMundialSeleccionada.getgolesAnotados()));
            Label l2 = new Label("Equipos: " + Integer.toString(copaMundialSeleccionada.getpartidosJugados()));
            Label l3 = new Label("Partidos jugados: " + Integer.toString(copaMundialSeleccionada.getpartidosJugados()));
            Label l4 = new Label("Asistencia: " + copaMundialSeleccionada.getAsistencia());

            l1.setMinHeight(25);
            l2.setMinHeight(25);
            l3.setMinHeight(25);
            l4.setMinHeight(25);
            
            
            datos.getChildren().addAll(titulo2, new Label(" "), l1, l2, l3, l4);
            infoHbox.getChildren().add(datos);

        } catch (Exception e) {
            infoHbox.getChildren().add(new Label("Esa copa mundial no esta registrada"));
        }
    }

    public Copas cargarCopaMundialPorAño(int anio) {
        Copas copaMundial = null;
        for (Copas c : copasMundiales) {
            if (c.getAnio() == anio) {
                return c;
            }
        }

        return copaMundial;
    }

    public int cargarTotalDeCopasMundialesPorPais(String nombrePais) {
        int totalCopasMundiales = 0;
        for (Copas c : copasMundiales) {
            if (c.getpuestosPaises()[0].equals(nombrePais)) {
                totalCopasMundiales++;
            }
        }

        return totalCopasMundiales;
    }

}
