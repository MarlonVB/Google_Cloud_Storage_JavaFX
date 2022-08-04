package ec.edu.ista.marlon.guia_practica_unidad_2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private Button abrirArchivo;


    @FXML
    protected void onHelloButtonClick() {

        HelloApplication helloApplication= new HelloApplication();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Archivo");

        // Obtener archivos
        File imgFile = fileChooser.showOpenDialog(helloApplication.getStage());

        System.out.println("PATH: "+imgFile.getAbsolutePath());

    }
}