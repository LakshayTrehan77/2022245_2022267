module com.example.projectsamples{
    requires org.junit.jupiter.api; // Requires JUnit for testing
    requires com.example.projectsample;
    requires javafx.graphics;
    requires javafx.fxml; // Requires the main module for testing

    opens com.example.projectsamples to org.junit.platform.commons; // Open the test package for JUnit
}