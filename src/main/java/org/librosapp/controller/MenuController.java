package org.librosapp.controller;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.librosapp.model.Libro;

import java.time.LocalDate;

public class MenuController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTitulo;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextField txtPaginas;

    @FXML
    private Label lblResultado;

    private final LibroService libroService = new LibroService();

    @FXML
    public void añadir() {

        try {

            String titulo = txtTitulo.getText();
            LocalDate fecha = dpFecha.getValue();
            int paginas =
                    Integer.parseInt(txtPaginas.getText());

            Libro libro = new Libro(
                    titulo,
                    fecha,
                    paginas
            );

            libroService.agregarLibro(libro);

            mostrarMensaje("Libro añadido correctamente");

            limpiarCampos();

        } catch (Exception e) {

            mostrarMensaje("Error al añadir libro");
        }
    }

    @FXML
    public void buscarPorId() {

        try {

            int id =
                    Integer.parseInt(txtId.getText());

            Libro libro =
                    libroService.buscarPorId(id);

            if (libro != null) {

                txtTitulo.setText(libro.getTitulo());

                dpFecha.setValue(
                        libro.getFechaPublicacion()
                );

                txtPaginas.setText(
                        String.valueOf(
                                libro.getPaginas()
                        )
                );

                mostrarMensaje("Libro encontrado");

            } else {

                mostrarMensaje("Libro no encontrado");
            }

        } catch (Exception e) {

            mostrarMensaje("ID inválido");
        }
    }

    @FXML
    public void modificar() {

        try {

            int id =
                    Integer.parseInt(txtId.getText());

            String titulo = txtTitulo.getText();

            LocalDate fecha =
                    dpFecha.getValue();

            int paginas =
                    Integer.parseInt(
                            txtPaginas.getText()
                    );

            Libro libro = new Libro(
                    id,
                    titulo,
                    fecha,
                    paginas
            );

            libroService.modificarLibro(libro);

            mostrarMensaje("Libro actualizado");

            limpiarCampos();

        } catch (Exception e) {

            mostrarMensaje("Error al actualizar");
        }
    }

    @FXML
    public void eliminar() {

        try {

            int id =
                    Integer.parseInt(txtId.getText());

            libroService.eliminarLibro(id);

            mostrarMensaje("Libro eliminado");

            limpiarCampos();

        } catch (Exception e) {

            mostrarMensaje("Error al eliminar");
        }
    }

    @FXML
    public void verTodos(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/lista.fxml"
                    )
            );

            Scene scene =
                    new Scene(loader.load());

            Stage stage = (Stage)
                    ((Node) event.getSource())
                            .getScene()
                            .getWindow();

            stage.setScene(scene);

            FadeTransition fade =
                    new FadeTransition(
                            Duration.seconds(1),
                            scene.getRoot()
                    );

            fade.setFromValue(0);

            fade.setToValue(1);

            fade.play();

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    public void salir() {

        Platform.exit();
    }

    private void mostrarMensaje(String msg) {

        lblResultado.setText(msg);

        FadeTransition fade =
                new FadeTransition(
                        Duration.seconds(1),
                        lblResultado
                );

        fade.setFromValue(0);

        fade.setToValue(1);

        fade.play();
    }

    private void limpiarCampos() {

        txtId.clear();
        txtTitulo.clear();
        txtPaginas.clear();

        dpFecha.setValue(null);
    }
}
