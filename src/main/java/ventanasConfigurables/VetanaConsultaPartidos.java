/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanasConfigurables;

import com.mycompany.proyecto2poo.App;
import errores.ErrorChecked;
import interfaces.VentanaInicializable;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author fabricio
 */
public class VetanaConsultaPartidos implements VentanaInicializable {
    public static Stage stage;
    @Override
    public void cargarVentana(String fxmlUrl) throws ErrorChecked {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlUrl));
            Parent root = loader.load();
            Scene scene = new Scene(root, 900, 600);
            stage = new Stage();

            stage.setScene(scene);
            stage.setTitle("Consulta de partidos");
            stage.show();

        } catch (IOException err) {
            throw new ErrorChecked("No se pudo cargar la ventana de consultar partidos");

        }
    }

}
