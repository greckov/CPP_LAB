package ua.nure.cpplab.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import ua.nure.cpplab.LabApplication;

import java.io.IOException;

abstract class BaseTaskController {
    @FXML
    private Button closeButton;

    protected static void displayInternal(
            @NotNull final String title,
            @NotNull final String resource
    ) throws IOException {
        final var window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(400);
        window.setMinWidth(800);
        window.setResizable(false);

        final var fxmlLoader = new FXMLLoader(LabApplication.class.getResource(resource));
        final var scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    @FXML
    protected void onCloseClick(final ActionEvent event) {
        ((Stage) closeButton.getScene().getWindow()).close();
    }
}
