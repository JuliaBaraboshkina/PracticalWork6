module com.example.practical_work_6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.practical_work_6 to javafx.fxml;
    exports com.example.practical_work_6;
}