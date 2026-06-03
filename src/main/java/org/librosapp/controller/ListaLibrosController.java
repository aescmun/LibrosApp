package org.librosapp.controller;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.librosapp.model.Libro;
import org.librosapp.service.LibroService;
import java.io.IOException;

public class ListaLibrosController {
    private LibroService libroService = new LibroService();
    @FXML private TableView<Libro> tablaLibros;
    @FXML private TableColumn<Libro, Integer> colId;
    @FXML private TableColumn<Libro, String> colTitulo;
    @FXML private TableColumn<Libro, String> colFecha;
    @FXML private TableColumn<Libro, Integer> colPaginas;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getId())
        );

        colTitulo.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getTitulo())
        );

        colFecha.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        String.valueOf(data.getValue().getFechaPublicacion())
                )
        );

        colPaginas.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPaginas())
        );

        tablaLibros.setItems(
                FXCollections.observableArrayList(libroService.obtenerTodos())
        );

        FadeTransition fade = new FadeTransition(Duration.millis(800), tablaLibros);
        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition move = new TranslateTransition(Duration.millis(800), tablaLibros);
        move.setFromY(30);
        move.setToY(0);

        fade.play();
        move.play();
    }

    @FXML
    public void volver() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) tablaLibros.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}