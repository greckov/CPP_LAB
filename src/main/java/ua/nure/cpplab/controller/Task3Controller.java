package ua.nure.cpplab.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ua.nure.cpplab.staff.queue.CircularQueue;

import java.io.IOException;

public class Task3Controller extends BaseTaskController {
    @FXML
    private Label drawnText;

    public static void display() throws IOException {
        displayInternal("Task 3.2", "task3-view.fxml");
    }

    public void initialize() {
        final var queue = new CircularQueue<String>(5);
        final var logBuilder = new StringBuilder();

        logBuilder.append("queue: ").append(queue);
        queue.enqueue("EL1");
        queue.enqueue("EL2");
        queue.enqueue("EL3");
        queue.enqueue("EL4");
        logBuilder.append("\nafter adding 4 elements: ").append(queue);
        queue.dequeue();
        queue.dequeue();
        logBuilder.append("\nafter deletion 4 elements: ").append(queue);
        queue.enqueue("EL5");
        queue.enqueue("EL6");
        queue.enqueue("EL7");
        logBuilder.append("\nafter adding 3 elements: ").append(queue);

        drawnText.setText(logBuilder.toString());
    }
}
