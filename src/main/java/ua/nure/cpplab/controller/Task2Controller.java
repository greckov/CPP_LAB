package ua.nure.cpplab.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ua.nure.cpplab.staff.Matrix;

import java.io.IOException;

public class Task2Controller extends BaseTaskController {
    @FXML
    private Label drawnText;

    public static void display() throws IOException {
        displayInternal("Task 2.4", "task2-view.fxml");
    }

    public void initialize() {
        final var logBuilder = new StringBuilder();
        final var matrix1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        final var matrix2 = new Matrix(new double[][]{{7, 8, 9}, {10, 11, 12}});

        logBuilder.append("Matrix 1: ").append(matrix1);
        logBuilder.append("\nMatrix 2: ").append(matrix2);
        logBuilder.append("\nMatrix 1 + Matrix 2 = ").append(matrix1.add(matrix2));
        logBuilder.append("\nMatrix 1 * 5.0 = ").append(matrix1.multiply(5.0));
        logBuilder.append("\nMatrix 1 * Matrix 2 = ").append(matrix1.multiply(matrix2));
        logBuilder.append("\nTranspose Matrix 1 = ").append(matrix1.transpose());

        drawnText.setText(logBuilder.toString());
    }
}
