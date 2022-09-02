/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2poo;

import errores.ErrorChecked;
import interfaces.VentanaInicializable;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ventanasConfigurables.*;
/**
 * FXML Controller class
 *
 * @author fabricio
 */
public class VentanaAppController implements Initializable{

    @FXML
    ImageView logoImgv;

    @FXML
    ImageView bannerImgv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Agregar logo y banner a la ventana
        try ( FileInputStream file1 = new FileInputStream(App.pathImages + "logo.png");  FileInputStream file2 = new FileInputStream(App.pathImages + "banner.jpg")) {
            Image img1 = new Image(file1);
            Image img2 = new Image(file2);
            logoImgv.setImage(img1);

            bannerImgv.setImage(img2);
        } catch (Exception e) {
            System.out.println("No se puedo abrir la imagen");
        }


    }

    
    @FXML
    public void consultarPartidos(ActionEvent e) {
        try {
            VetanaConsultaPartidos ventana = new VetanaConsultaPartidos();
            ventana.cargarVentana("VentanaConsultaPartidos.fxml");
        } catch (ErrorChecked err) {
            System.out.println(err.getMessage());
        }
        

    }

    @FXML
    public void consultarCopasMundiales(ActionEvent e) {
        try {
            VentanaConsultaCopasMundiales ventana = new VentanaConsultaCopasMundiales();
            ventana.cargarVentana("VentanaConsultaCopasMundiales.fxml");
        } catch (ErrorChecked err) {
            System.out.println(err.getMessage());
        }

    }

}
