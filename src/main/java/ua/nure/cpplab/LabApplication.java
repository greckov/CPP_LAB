package ua.nure.cpplab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LabApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LabApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 540);
        stage.setTitle("NURE Cross platform programming lab work");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
