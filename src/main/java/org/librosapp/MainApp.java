package org.librosapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.librosapp.database.DatabaseInitializer;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseInitializer.init();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/login.fxml")
        );
        Pane loginPane = loader.load();

        Scene scene = new Scene(loginPane, 400, 350);
        scene.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
        );

        primaryStage.setTitle("LibrosApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}