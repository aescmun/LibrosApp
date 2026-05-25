package org.librosapp.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.librosapp.service.AuthService;

import java.io.IOException;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    private AuthService authService = new AuthService();

    @FXML
    public void login() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        if (authService.autenticar(usuario, password)) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/fxml/menu.fxml")
                );
                Pane menuPane = loader.load();

                Scene scene = new Scene(menuPane, 600, 500);
                scene.getStylesheets().add(
                        getClass().getResource("/css/style.css").toExternalForm()
                );

                Stage stage = (Stage) txtUsuario.getScene().getWindow();

                FadeTransition fade = new FadeTransition(Duration.millis(500), menuPane);
                fade.setFromValue(0);
                fade.setToValue(1);
                fade.play();

                stage.setScene(scene);

            } catch (IOException e) {
                lblMensaje.setText("Error al cargar el menú.");
            }
        } else {
            lblMensaje.setText("Usuario o contraseña incorrectos.");
        }
    }
}