package ua.nure.cpplab;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainController {
    @FXML
    protected void showTask1Demo() throws IOException {
        Task1Controller.display();
    }
}
