package com.mycompany.proyecto2poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    public static String pathImages = "src/main/resources/images/";
    public static String pathTxt = "src/main/resources/filesTxt/";
    public static String pathImagesBanderas = "src/main/resources/banderas/";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("VentanaApp.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Copa Mundial 2014");
        
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    

}