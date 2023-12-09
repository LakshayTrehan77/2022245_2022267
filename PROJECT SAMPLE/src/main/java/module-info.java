module com.example.projectsample {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires javafx.media;

    opens com.example.projectsample to javafx.fxml, org.junit.platform.commons;
    exports com.example.projectsample;
}
