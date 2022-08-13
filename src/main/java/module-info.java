module com.mycompany.proyecto2poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto2poo to javafx.fxml;
    exports com.mycompany.proyecto2poo;
}
