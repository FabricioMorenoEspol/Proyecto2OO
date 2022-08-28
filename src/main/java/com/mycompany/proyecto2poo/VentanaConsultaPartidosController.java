/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2poo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import modelo.Jugador;
import modelo.Partido;
import Ficheros.*;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ventanasConfigurables.*;
/**
 * FXML Controller class
 *
 * @author fabricio
 */
public class VentanaConsultaPartidosController implements Initializable {

    @FXML
    ComboBox faseCb;
    @FXML
    ComboBox gruposCb;
    @FXML
    ComboBox equipo1Cb;
    @FXML
    ComboBox equipo2CB;
    @FXML
    Label labelGrupos;
    @FXML
    VBox infoPartidoVbox;
    @FXML
    Button consultarBtn;

    ArrayList<Partido> partidos = Fichero.leerDatosPartidos("WorldCupMatchesBrasil2014.csv");
    ArrayList<Jugador> jugadores = Fichero.leerDatosJugadores(App.pathTxt+"WorldCupPlayersBrasil2014.csv");
    public static ArrayList<Partido> partidosSeleccionadosPorFase;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Esconder el combobox y label de la fase grupo
        gruposCb.setVisible(false);
        labelGrupos.setText("");
        //setear valores a los comboboxes
        faseCb.getItems().setAll("Groups", "Round of 16", "Quarter-finals", "Semi-finals", "Final");

        //Agregar eventos a los componentes
        faseCb.setOnAction(e -> cargarPartidosPorFase((String) faseCb.getValue()));
        gruposCb.setOnAction(e -> cargarPartidosPorFase("Group " + (String) gruposCb.getValue()));
        consultarBtn.setOnAction(e -> consultarPartidos());
        equipo1Cb.setOnAction(e->infoPartidoVbox.getChildren().clear());
        equipo2CB.setOnAction(e->infoPartidoVbox.getChildren().clear());
    }

    public ArrayList<Partido> cargarPartidosPorFase(String nombreFase) {
        //Limpiando los equipos

        equipo1Cb.getItems().setAll();
        equipo2CB.getItems().setAll();
        infoPartidoVbox.getChildren().clear();

        ArrayList<Partido> partidosPorFase = new ArrayList<>();

        //Hacer visible o invisible los grupos dependiendo de la fase
        if (nombreFase.equals("Groups")) {

            labelGrupos.setText("Grupos:");
            gruposCb.setVisible(true);
            gruposCb.getItems().setAll("A", "B", "C", "D", "E", "F", "G", "H");

        } else {
            if (!nombreFase.contains("Group")) {
                labelGrupos.setText("");
                gruposCb.setVisible(false);
                gruposCb.getItems().setAll();
            } else {
                System.out.println("a");
            }
        }

        //Rellenar el array por la fase seleccionada y ordenarlos
        for (Partido partido : partidos) {
            if (partido.getFase().equals(nombreFase)) {
                partidosPorFase.add(partido);
            }

        }

        Collections.sort(partidosPorFase);

        //Cargando a los comboboxes sus respectivos equipos ordenados por la fase seleccionada
        for (Partido partido : partidosPorFase) {
            equipo1Cb.getItems().add(partido);
            equipo2CB.getItems().add(partido.getequipoVisitante());
        }
        partidosSeleccionadosPorFase = partidosPorFase;

        return partidosPorFase;
    }

    public void consultarPartidos() {

        //Limpiar el vbox
        infoPartidoVbox.getChildren().clear();

        //Obtner el partido actual seleccionado
        try {
            Partido partido = (Partido) equipo1Cb.getValue();
            if (partido.getequipoVisitante().equals((String) equipo2CB.getValue())) {
                VBox padreHbox = new VBox();
                //Header
                
                Label titulo = new Label("Resultados del partido");
                titulo.setFont(new Font(10));
                titulo.setStyle("-fx-font-weight: bold;");
                
                HBox hbox1 = new HBox();
                Label fecha = new Label(partido.getFecha());
                hbox1.getChildren().addAll(fecha);
                
                // Un linea de separacion
                HBox hbox2 = new HBox();
                hbox2.setPrefHeight(2);
                hbox2.setStyle("-fx-background-color: #000000;");
                
                
                SplitPane sp = new SplitPane();
                //Informacion del partido
                VBox vbox1 = new VBox();//Principal
                vbox1.setPadding(new Insets(10, 0, 10, 0));
                Label descripcion = new Label(partido.getDescripcion());
                Label grupo = new Label(partido.getFase());
                Label estadio = new Label(partido.getEstadio());
                Label ciudad = new Label(partido.getCiudad());
                
                vbox1.getChildren().addAll(descripcion,grupo,estadio,ciudad);
                
                
                //Marcador del partido
                HBox hbox4 = new HBox();
                VBox vbox2 = new VBox();//Principal
                Label texto = new Label("FIN DEL PARTIDO");
                
                //EQUIPO LOCAL
                HBox equipoLocal = new HBox();
                
                ImageView imgv1=null;
                
                try (FileInputStream fs= new FileInputStream(App.pathImagesBanderas+"logo.png")){
                    imgv1 = new ImageView(new Image(fs));
                    imgv1.setFitHeight(20);
                    imgv1.setFitWidth(20);
                } catch (Exception e) {
                    System.out.println("Error al cargar la imagen");
                }
                
                Label equipoLocalLabel = new Label(partido.getequipoLocal());
                
                Label resultadoPartido = new Label(Integer.toString(partido.getequipoLocalGoals())+"-"+Integer.toString(partido.getequipoVisitanteGoals()));
                
                //EQUIPO VISITANTE
                 ImageView imgv2=null;
                
                try (FileInputStream fs= new FileInputStream(App.pathImagesBanderas+"logo.png")){
                    imgv2 = new ImageView(new Image(fs));
                    imgv2.setFitHeight(20);
                    imgv2.setFitWidth(20);
                } catch (Exception e) {
                    System.out.println("Error al cargar la imagen");
                }
                HBox equipoVisitante = new HBox();
                Label equipoVisitanteLabel = new Label(partido.getequipoVisitante());
                
                hbox4.setAlignment(Pos.CENTER);
                hbox4.setSpacing(100);
                equipoLocal.getChildren().addAll(equipoLocalLabel,imgv1);
                equipoVisitante.getChildren().addAll(equipoVisitanteLabel,imgv2);
                hbox4.getChildren().addAll(equipoLocal,resultadoPartido,equipoVisitante);
                vbox2.getChildren().addAll(texto,hbox4);
                vbox2.setAlignment(Pos.CENTER);
                
                //Montaje en el splitpane
                sp.setDividerPositions(0.3f,0.4f);
                sp.getItems().addAll(vbox1,vbox2);
                
                //Botones
                Button exportarResultadosBtn = new Button("EXPORTAR RESULTADOS DE GRUPO");
                exportarResultadosBtn.setCursor(Cursor.HAND);
                Button verDetallesEquiposBtn = new Button("VER DETALLES DE EQUIPOS");
                verDetallesEquiposBtn.setCursor(Cursor.HAND);
                
                exportarResultadosBtn.setStyle("-fx-background-color: #7bafeb;-fx-text-inner-color: #f6fdff;");
                
                verDetallesEquiposBtn.setStyle("-fx-background-color: #7bafeb;-fx-text-inner-color: #f6fdff;");
                
                //Eventos botones
                exportarResultadosBtn.setOnAction(e->exportarJugadoresPorFase());
                verDetallesEquiposBtn.setOnAction(e ->{
                        VetanaConsultaPartidos.stage.close();
                        verDetallesEquipos();
                });
                        
                //Montaje completo de resultados del partido;
                padreHbox.setPadding(new Insets(0, 5, 0, 5));
                padreHbox.getChildren().addAll(titulo,hbox1,hbox2,sp,new Label(""),exportarResultadosBtn,new Label(""),verDetallesEquiposBtn);
                padreHbox.setAlignment(Pos.CENTER);
                
                infoPartidoVbox.getChildren().addAll(padreHbox);
                
                

            } else {
                //Agregar mensaje de registro no encontrado
                Label l = new Label("No existe un registro");
                System.out.println("error");
                infoPartidoVbox.setAlignment(Pos.CENTER);
                infoPartidoVbox.getChildren().add(l);

            }
        } catch (Exception e) {

            //Agregar mensaje de registro no encontrado
            Label l = new Label("No existe un registro");
            System.out.println("error");
            infoPartidoVbox.setAlignment(Pos.CENTER);
            infoPartidoVbox.getChildren().add(l);
        }

    }
    
    public void exportarJugadoresPorFase(){
        //Creacion de stage
        Stage stage = new Stage();
        
        VBox padre = new VBox();
        //Mensaje
        Label mensaje = new Label("Esta seguro que desea exportar el grupo de jugadores seleccionados?");
        
        //Botones
        HBox botones = new HBox();
        Button aceptarBtn = new Button("Aceptar");
        Button cancelarBtn = new Button("Cancelar");
        botones.setAlignment(Pos.BOTTOM_RIGHT);
        botones.setPadding(new Insets(0, 10, 0, 0));
        
        //Agregar eventos a los botones
        aceptarBtn.setOnAction(e->{
            
            ArrayList<Jugador>jugadoresPorFaseSeleccionada = cargarJugadoresPorFase();
            
            Fichero.serializarListaJugadores(jugadoresPorFaseSeleccionada);
            stage.close();
        });
        
        cancelarBtn.setOnAction(e->{
            stage.close();
        });
        
        //Montaje botones
        botones.getChildren().addAll(aceptarBtn,cancelarBtn);
        
        //Montaje de todos los componentes
        padre.setAlignment(Pos.CENTER);
        padre.getChildren().addAll(mensaje,new Label(""),botones);
        
        //Montaje de la escena
        Scene scene = new Scene(padre,600,200);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    public ArrayList<Jugador> cargarJugadoresPorFase(){
       
        ArrayList<String> inicialesDeFaseSeleccionada = new ArrayList<>();
        ArrayList<Jugador> jugadoresPorFaseSeleccionada = new ArrayList<>();
            
            //Obteniendo todas la iniciales de los paises seleccionados por fase
            for(Partido par: partidosSeleccionadosPorFase){
                if(!inicialesDeFaseSeleccionada.contains(par.getInicialesEquipoLocal())){
                    inicialesDeFaseSeleccionada.add(par.getInicialesEquipoLocal());
                }
                if(!inicialesDeFaseSeleccionada.contains(par.getInicialesEquipoVisitante())){
                    inicialesDeFaseSeleccionada.add(par.getInicialesEquipoVisitante());
                }
                
            }
            
            for(Jugador jug: jugadores){
                
                if(inicialesDeFaseSeleccionada.contains(jug.getnombreEquipo())){
                    jugadoresPorFaseSeleccionada.add(jug);
                }
            }
            
            
           
            
            return jugadoresPorFaseSeleccionada;
    }
    
    
    public void verDetallesEquipos(){
        //Creacion de stage
        Stage stage = new Stage();
        
        //Obtener inicales las iniciales de paises del partido elegido
        Partido partidoSeleccionado = (Partido) equipo1Cb.getValue();
        String inicialesEquipoLocal =  partidoSeleccionado.getInicialesEquipoLocal();
        String inicialesEquipoVisitante = partidoSeleccionado.getInicialesEquipoVisitante();
        System.out.println(inicialesEquipoLocal+" "+inicialesEquipoVisitante);
        
        //Obtener jugadores del equipo local
        ArrayList<Jugador> jugadoresEquipoLocal = new ArrayList<>();
        for(Jugador jug: jugadores){
            if(inicialesEquipoLocal.equals(jug.getnombreEquipo()) && !jugadoresEquipoLocal.contains(jug)){
                jugadoresEquipoLocal.add(jug);
            }
            
        }
        //Obtener jugadores del equipo visitante
        ArrayList<Jugador> jugadoresEquipoVisitante = new ArrayList<>();
        for(Jugador jug: jugadores){
            if(inicialesEquipoVisitante.equals(jug.getnombreEquipo())&& !jugadoresEquipoVisitante.contains(jug)){
                jugadoresEquipoVisitante.add(jug);
            }
            
        }

        
        //VBOX padre
        VBox padre = new VBox();
        //Mensaje
        Label mensaje = new Label("Detalle de equipos");
        
        //Mostrar imagenes equipo local
        VBox equipoLocalHbox = new VBox();
        Label tituloEqLocal = new Label(partidoSeleccionado.getequipoLocal());
        FlowPane equipoLocalFp = new FlowPane();
        equipoLocalFp.setOrientation(Orientation.HORIZONTAL);
        
        for(Jugador jug :jugadoresEquipoLocal){
            try {
                VBox infoJugadorVbox = new VBox();
                Label imagen = new Label(jug.getNombreImg());
                Label nombreJugador = new Label(jug.getnombrejugador());
                infoJugadorVbox.setPrefSize(130,230);
                
                infoJugadorVbox.getChildren().addAll(imagen,nombreJugador);
                equipoLocalFp.getChildren().add(infoJugadorVbox);
                
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen de los jugadores");
            }
        
        }
        equipoLocalHbox.getChildren().addAll(tituloEqLocal,new Label(""),equipoLocalFp);
        
        //Mostrar imagenes equipo visitante
        VBox equipoVisitanteHbox = new VBox();
        Label tituloEqVisitante = new Label(partidoSeleccionado.getequipoVisitante());
        FlowPane equipoVisitanteFp = new FlowPane();
        equipoLocalFp.setOrientation(Orientation.HORIZONTAL);
        
        for(Jugador jug :jugadoresEquipoVisitante){
            try {
                VBox infoJugadorVbox = new VBox();
                Label imagen = new Label(jug.getNombreImg());
                Label nombreJugador = new Label(jug.getnombrejugador());
                infoJugadorVbox.setPrefSize(130,230);
                
                infoJugadorVbox.getChildren().addAll(imagen,nombreJugador);
                equipoVisitanteFp.getChildren().add(infoJugadorVbox);
                
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen de los jugadores");
            }
        
        }
        
        equipoVisitanteHbox.getChildren().addAll(tituloEqVisitante,new Label(""),equipoVisitanteFp);
        
        
        //Montaje de todos los componentes
        padre.getChildren().addAll(mensaje,new Label(""),equipoLocalHbox, new Label(""),equipoVisitanteHbox);
        
        //Agregar un scroll
        ScrollPane sp = new ScrollPane(padre);
        
        
        //Montaje de la escena
        Scene scene = new Scene(new BorderPane(sp),600,600);
        
        
        stage.setScene(scene);
        stage.show();
        System.out.println(stage.getWidth());
        equipoLocalFp.setPrefWidth(stage.getWidth());
        equipoLocalHbox.setPrefWidth(stage.getWidth());
        equipoVisitanteFp.setPrefWidth(stage.getWidth());
        equipoVisitanteHbox.setPrefWidth(stage.getWidth());
        
    }
    
}

