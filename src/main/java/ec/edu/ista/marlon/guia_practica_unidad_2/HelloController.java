package ec.edu.ista.marlon.guia_practica_unidad_2;

import ec.edu.ista.marlon.guia_practica_unidad_2.google.Conexion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private String path;
    private String idProyecto;
    @FXML
    private Button abrirArchivo;

    @FXML
    private TextField txtNombreObj;
    @FXML
    private TextField txtNombreBucket;
    @FXML
    private TextField txtNombreProyecto;


    @FXML
    protected void abrirSelector() {

        HelloApplication helloApplication= new HelloApplication();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Archivo");

        // Obtener archivos
        File imgFile = fileChooser.showOpenDialog(helloApplication.getStage());
        path=imgFile.getAbsolutePath();

        System.out.println("PATH: "+imgFile.getAbsolutePath());

    }

    @FXML
    protected void enviarArchivo() {
        Conexion conexion= new Conexion();
        String nombreArchico= txtNombreObj.getText();
        String nombreBucket= txtNombreBucket.getText();

        try {
            conexion.subirArchivo(idProyecto, nombreBucket, nombreArchico, path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idProyecto="durable-sound-356201";
        txtNombreProyecto.setText(idProyecto);
        txtNombreProyecto.setEditable(false);
    }
}