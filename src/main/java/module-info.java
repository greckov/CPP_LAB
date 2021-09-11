module ua.nure.cpplab {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;

    opens ua.nure.cpplab to javafx.fxml;

    exports ua.nure.cpplab;
    exports ua.nure.cpplab.controller;
    opens ua.nure.cpplab.controller to javafx.fxml;
}
