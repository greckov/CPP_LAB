package ua.nure.cpplab.controller;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainController {
    @FXML
    protected void showTask1Demo() throws IOException {
        Task1Controller.display();
    }

    @FXML
    protected void showTask2Demo() throws IOException {
        Task2Controller.display();
    }

    @FXML
    protected void showTask3Demo() throws IOException {
        Task3Controller.display();
    }

    @FXML
    protected void showTask4Demo() throws IOException {
        Task4Controller.display();
    }
}
