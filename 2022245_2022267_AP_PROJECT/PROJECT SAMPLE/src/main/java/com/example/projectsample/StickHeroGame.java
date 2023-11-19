package com.example.projectsample;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StickHeroGame extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file with the video player
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        Parent root = loader.load();

        // Set up the primary stage
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        scene.setFill(null);
        stage.setTitle("Stick Hero Game");
        stage.setScene(scene);
        stage.show();

        // Find the MediaView and MediaPlayer
        MediaView mediaView = (MediaView) scene.lookup("#mediaView");
        MediaPlayer mediaPlayer = mediaView.getMediaPlayer();

        // Add a listener to the MediaPlayer to detect when the video is done
        mediaPlayer.setOnEndOfMedia(() -> {
            // Load the Scene2.fxml after the video is done
            try {
                FXMLLoader helloLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                Parent helloRoot = helloLoader.load();
                Scene helloScene = new Scene(helloRoot);
                stage.setScene(helloScene);
                stage.setFullScreen(true);
                String musicFile = getClass().getResource("/com/example/projectsample/Inspiring-Dreams(chosic.com).mp3").toString();
                AudioClip audioClip = new AudioClip(musicFile);
                audioClip.setCycleCount(AudioClip.INDEFINITE); // Set to loop indefinitely
                audioClip.play();
                // Flag to track music state
                final boolean[] isMusicPlaying = {true};
                javafx.scene.image.ImageView soundOffImageView = (javafx.scene.image.ImageView) helloScene.lookup("#soundoff");

// Make the sound off button clickable
                soundOffImageView.setOnMouseClicked(event -> {
                    if (isMusicPlaying[0]) {
                        // Stop the music
                        audioClip.stop();
                        System.out.println("Music stopped!");

                        // Change the image to "play.jpg"

                    } else {
                        // Play the music
                        audioClip.play();
                        System.out.println("Music resumed!");

                        // Change the image back to "soundoff.png"

                    }

                    // Toggle the music state
                    isMusicPlaying[0] = !isMusicPlaying[0];
                });

                javafx.scene.image.ImageView playNowImageView = (javafx.scene.image.ImageView) helloScene.lookup("#playButton");

                // Add ScaleTransition to the "Play Now" button
                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), playNowImageView);
                scaleTransition.setToX(1.2); // Adjust the scaling factors as needed
                scaleTransition.setToY(1.2);
                scaleTransition.setAutoReverse(true); // Reverse the animation direction
                scaleTransition.setCycleCount(ScaleTransition.INDEFINITE); // Repeat indefinitely
                scaleTransition.play();
                // Assuming there is a button with the id "playButton" in Scene2.fxml
                helloScene.lookup("#playButton").setOnMouseEntered(event -> {
                    // Set the cursor to HAND when hovering over the button
                    helloScene.setCursor(Cursor.HAND);
                });

                helloScene.lookup("#playButton").setOnMouseExited(event -> {
                    // Set the default cursor when not hovering over the button
                    helloScene.setCursor(Cursor.DEFAULT);
                });

                helloScene.lookup("#playButton").setOnMouseClicked(event -> {
                    // Load the Scene3.fxml after clicking the play button
                    try {
                        FXMLLoader scene2Loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
                        Parent scene2Root = scene2Loader.load();
                        Scene scene2 = new Scene(scene2Root);
                        stage.setScene(scene2);
                        stage.setFullScreen(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
            ;} catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
