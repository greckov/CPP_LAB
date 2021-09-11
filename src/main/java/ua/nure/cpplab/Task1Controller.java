package ua.nure.cpplab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Task1Controller {
    @FXML
    private Label drawnText;

    public static void display() throws IOException {
        final var window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Task 1.10 demo");
        window.setMinHeight(400);
        window.setMinWidth(800);
        window.setResizable(false);

        final var fxmlLoader = new FXMLLoader(LabApplication.class.getResource("task1-view.fxml"));
        final var scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.showAndWait();
    }

    public void initialize() {
        drawnText.setText(generateTriangle());
    }

    @FXML
    protected void onCloseClick(final ActionEvent event) {
        ((Stage) drawnText.getScene().getWindow()).close();
    }

    private String generateTriangle() {
        final var builder = new StringBuilder(100);

        final int [][] arrayRow = new int [10][];

        for (int i = 0; i < 10; i++) {
            arrayRow[i] = new int [i + 1];
            arrayRow[i][0] = 1;
            builder.append(arrayRow[i][0]).append(" ");

            for (int j = 1; j < i; j++){
                arrayRow[i][j] = arrayRow[i - 1][j] + arrayRow[i - 1][j - 1];
                builder.append(arrayRow[i][j]).append(" ");
            }

            arrayRow[i][i]=1;

            if (i==0) {
                builder.append("\n");
            } else {
                builder.append(arrayRow[i][i]).append("\n");
            }
        }

        return builder.toString();
    }
}
