module com.example.assignment5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.assignment5 to javafx.fxml;
    exports com.example.assignment5;
}