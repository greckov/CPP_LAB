module ua.nure.cpplab {
    requires javafx.controls;
    requires javafx.fxml;


    opens ua.nure.cpplab to javafx.fxml;
    exports ua.nure.cpplab;
}