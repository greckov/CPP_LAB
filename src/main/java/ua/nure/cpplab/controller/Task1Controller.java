package ua.nure.cpplab.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Task1Controller extends BaseTaskController {
    @FXML
    private Label drawnText;

    public static void display() throws IOException {
        displayInternal("Task 1.10", "task1-view.fxml");
    }

    public void initialize() {
        drawnText.setText(generateTriangle());
    }

    @NotNull
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
