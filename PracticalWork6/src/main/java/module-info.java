module com.example.practicalwork6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.practicalwork6 to javafx.fxml;
    exports com.example.practicalwork6;
}