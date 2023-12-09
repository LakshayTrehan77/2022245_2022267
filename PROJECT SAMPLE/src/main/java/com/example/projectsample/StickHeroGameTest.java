package com.example.projectsample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.example.projectsample.Scene3.score;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StickHeroGameTest {

    @BeforeAll
    static void setUp() {
        // Initialize JavaFX Toolkit
        javafx.application.Platform.startup(() -> {});
    }

    @Test
    void testScene3Components() {
        try {
            // Load Scene 3 from FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectsample/scene3.fxml"));
            Parent scene3Root = loader.load();

            // Access the controller of Scene 3
            Scene3 scene3Controller = loader.getController();

            // Test various components of Scene 3
            assertNotNull(scene3Controller.getStickRectangle());
            assertNotNull(scene3Controller.getBgImage());
            assertNotNull(scene3Controller.getStandingtower());
            assertNotNull(scene3Controller.getStickHero());
            assertNotNull(scene3Controller.getCherryImage());
            assertNotNull(scene3Controller.getHeroImageView());
            assertNotNull(scene3Controller.getScorecard());
            assertNotNull(scene3Controller.getCherry());

            // Add more assertions as needed

            // Optional: Show the Scene for visual inspection
            javafx.application.Platform.runLater(() -> {
                Stage stage = new Stage();
                stage.setScene(new Scene(scene3Root));
                stage.show();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    @Test
    void testScene4Components() {
        try {
            // Load Scene 4 from FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectsample/scene4.fxml"));
            Parent scene4Root = loader.load();

            // Access the controller of Scene 4
            Scene4 scene4Controller = loader.getController();

            // Test various components of Scene 4
            assertNotNull(scene4Controller.getCondition());
            assertNotNull(scene4Controller.getRevindbutton());
            assertNotNull(scene4Controller.getCurrentscore());
            assertNotNull(scene4Controller.getHome());
            assertNotNull(scene4Controller.getClass());
            assertNotNull(scene4Controller.getCondition());

            // Add more assertions as needed

            // Optional: Show the Scene for visual inspection
            javafx.application.Platform.runLater(() -> {
                Stage stage = new Stage();
                stage.setScene(new Scene(scene4Root));
                stage.show();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
