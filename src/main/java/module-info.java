module ec.edu.ista.marlon.guia_practica_unidad_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires google.cloud.storage;
    requires google.cloud.core;
    requires google.cloud.firestore;
    requires com.google.auth;
    requires com.google.auth.oauth2;


    opens ec.edu.ista.marlon.guia_practica_unidad_2 to javafx.fxml;
    exports ec.edu.ista.marlon.guia_practica_unidad_2;
}