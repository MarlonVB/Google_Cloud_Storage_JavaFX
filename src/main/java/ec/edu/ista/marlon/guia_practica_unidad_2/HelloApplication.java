package ec.edu.ista.marlon.guia_practica_unidad_2;

import ec.edu.ista.marlon.guia_practica_unidad_2.google.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        //HelloController controller= new HelloController(stage);

        /*Conexion subir= new Conexion();
        subir.subirArchivo();*/

    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}