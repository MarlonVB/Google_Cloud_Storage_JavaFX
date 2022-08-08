package ec.edu.ista.marlon.guia_practica_unidad_2;

import ec.edu.ista.marlon.guia_practica_unidad_2.google.Conexion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class GoogleAppControlador implements Initializable {
    private String path;
    private String idProyecto;

    private File archivo;
    @FXML
    private Button abrirArchivo;

    @FXML
    private Button enviarArchivo;
    @FXML
    private Button quitarArchivo;
    @FXML
    private TextField txtNombreObj;
    @FXML
    private TextField txtNombreBucket;
    @FXML
    private TextField txtNombreProyecto;
    @FXML
    private Label labelArchivo;

    @FXML
    private ImageView img_errorObj;

    @FXML
    private ImageView img_errorBucket;



    @FXML
    protected void recogerDatos() {

        do{
            archivo = openChooser();

            if (archivo!=null){
                quitarArchivo.setDisable(false);
                path=archivo.getAbsolutePath();
                enviarArchivo.setDisable(false);
                labelArchivo.setText(archivo.getName());
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("¡ERROR!");
                alert.setTitle("No se ha elegido un archivo");
                alert.setContentText("Debes elegir un archivo");
                Optional<ButtonType> action = alert.showAndWait();
            }
        }while (archivo==null);
    }

    @FXML
    protected void enviarArchivo() {
        Conexion conexion= new Conexion();
        String nombreArchico=null;
        String nombreBucket=null;

        if (!(txtNombreBucket.getText().isEmpty() && txtNombreObj.getText().isEmpty())){
            nombreArchico= txtNombreObj.getText();
            nombreBucket= txtNombreBucket.getText();

            try {
                conexion.subirArchivo(idProyecto, nombreBucket, nombreArchico, path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            mostrarError();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("¡ERROR!");
            alert.setTitle("Debes rellenar todos los campos");
            alert.setContentText("Debes llenar los campos necesarios antes de continuar");
            Optional<ButtonType> action = alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idProyecto="durable-sound-356201";
        txtNombreProyecto.setText(idProyecto);
        txtNombreProyecto.setEditable(false);
        enviarArchivo.setDisable(true);
        quitarArchivo.setDisable(true);
        img_errorObj.setVisible(false);
        img_errorBucket.setVisible(false);
    }

    private File openChooser(){
        GoogleApp googleApp = new GoogleApp();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Archivo");

        // Obtener archivos
        File archivo = fileChooser.showOpenDialog(googleApp.getStage());

        return archivo;
    }

    @FXML
    private void quitarArchivo(){

        System.out.println("ARCHIVO ENTRA: "+archivo.getName());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de quitar el archivo?");
        Optional<ButtonType> action = alert.showAndWait();

        // Si hemos pulsado en aceptar
        if (action.get() == ButtonType.OK) {
            archivo=null;
            labelArchivo.setText("");
            enviarArchivo.setDisable(true);
            quitarArchivo.setDisable(true);
        }
    }

    private void mostrarError(){
        if (txtNombreObj.getText().isEmpty()){
            img_errorObj.setVisible(true);
            txtNombreObj.setStyle("-fx-border-color: red");
        }

        if (txtNombreBucket.getText().isEmpty()){
            img_errorBucket.setVisible(true);
            txtNombreBucket.setStyle("-fx-border-color: red");
        }
    }
}