package ec.edu.ista.marlon.guia_practica_unidad_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class GoogleApp extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GoogleApp.class.getResource("google-app-vista.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cargar Archivo al Google Cloud");
        Image iconApp= new Image("C:\\Users\\pato0\\Documents\\GitHub\\Google_Cloud_Storage_JavaFX\\src\\main\\resources\\carga-en-la-nube.png");
        stage.getIcons().add(iconApp);
        stage.setScene(scene);
        stage.show();
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