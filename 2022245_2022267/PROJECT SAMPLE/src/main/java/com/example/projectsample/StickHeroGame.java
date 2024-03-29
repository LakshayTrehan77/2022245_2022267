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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static com.example.projectsample.Scene3.*;

public class StickHeroGame extends Application {
    public static void loadScene4() {
        if (gameover) {
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(StickHeroGame.class.getResource("Scene4.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.show();

                // Access the controller and call initialize
                Scene4 scene4Controller = loader.getController();
                scene4Controller.initialize();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void loadScene3() {
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(StickHeroGame.class.getResource("Scene3.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.show();

                // Access the controller and call initialize


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void loadgame() throws IOException{
        FXMLLoader loader = new FXMLLoader(StickHeroGame.class.getResource("Scene1.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setFullScreen(true);
        scene.setFill(null);
        stage.setTitle("Stick Hero Game");
        stage.setScene(scene);
        stage.show();

        MediaView mediaView = (MediaView) scene.lookup("#mediaView");
        MediaPlayer mediaPlayer = mediaView.getMediaPlayer();

        mediaPlayer.setOnEndOfMedia(() -> {
            // Load the Scene2.fxml after the video is done
            try {
                FXMLLoader helloLoader = new FXMLLoader(StickHeroGame.class.getResource("Scene2.fxml"));
                Parent helloRoot = helloLoader.load();
                Scene helloScene = new Scene(helloRoot);
                stage.setScene(helloScene);
                stage.setFullScreen(true);
                String musicFile = StickHeroGame.class.getResource("/com/example/projectsample/Inspiring-Dreams(chosic.com).mp3").toString();
                AudioClip audioClip = new AudioClip(musicFile);
                audioClip.setCycleCount(AudioClip.INDEFINITE);
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


                    }

                    // Toggle the music state
                    isMusicPlaying[0] = !isMusicPlaying[0];
                });

                javafx.scene.image.ImageView playNowImageView = (javafx.scene.image.ImageView) helloScene.lookup("#playButton");

                // Add ScaleTransition to the "Play Now" button
                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), playNowImageView);
                scaleTransition.setToX(1.2);
                scaleTransition.setToY(1.2);
                scaleTransition.setAutoReverse(true);
                scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
                scaleTransition.play();

                helloScene.lookup("#playButton").setOnMouseEntered(event -> {

                    helloScene.setCursor(Cursor.HAND);
                });

                helloScene.lookup("#playButton").setOnMouseExited(event -> {

                    helloScene.setCursor(Cursor.DEFAULT);
                });

                helloScene.lookup("#playButton").setOnMouseClicked(event -> {
                    // Load the Scene3.fxml after clicking the play button
                    try {
                        FXMLLoader scene2Loader = new FXMLLoader(StickHeroGame.class.getResource("Scene3.fxml"));
                        Parent scene2Root = scene2Loader.load();
                        Scene scene2 = new Scene(scene2Root);
                        stage.setScene(scene2);
                        stage.setFullScreen(true);

                        score = 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
                ;} catch (Exception e) {
                e.printStackTrace();
            }


        });
    }


    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file with the video player
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        scene.setFill(null);
        stage.setTitle("Stick Hero Game");
        stage.setScene(scene);
        stage.show();

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
                Text cherriesText = (Text) helloScene.lookup("#cherriestext");
                Text cherriesscore = (Text) helloScene.lookup("#cherriesscore");

                cherriesText.setVisible(false);
                cherriesscore.setVisible(false);

                javafx.scene.image.ImageView Cherries = (javafx.scene.image.ImageView) helloScene.lookup("#cherrylogo");
                Cherries.setOnMouseClicked(event ->{
                    cherriesscore.setText(" " + cherries);
                    cherriesText.setVisible(true);


                    cherriesscore.setVisible(true);
                });


                String musicFile = getClass().getResource("/com/example/projectsample/Inspiring-Dreams(chosic.com).mp3").toString();
                AudioClip audioClip = new AudioClip(musicFile);
                audioClip.setCycleCount(AudioClip.INDEFINITE);
                audioClip.play();
                // Flag to track music state
                final boolean[] isMusicPlaying = {true};
                javafx.scene.image.ImageView soundOffImageView = (javafx.scene.image.ImageView) helloScene.lookup("#soundoff");
                javafx.scene.image.ImageView TutorialImageView = (javafx.scene.image.ImageView) helloScene.lookup("#Tutorial");


                // Make the sound off button clickable
                TutorialImageView.setOnMouseClicked(event -> {
                    FXMLLoader loaders = new FXMLLoader(StickHeroGame.class.getResource("Scene5.fxml"));
                    Parent roots;
                    try {
                        roots = loaders.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Scene scenes = new Scene(roots);
                    Stage stages = new Stage();
                    stages.setFullScreen(true);
                    scenes.setFill(null);
                    stages.setTitle("Stick Hero Game");
                    stages.setScene(scenes);
                    stages.show();

                    MediaView mediaViews = (MediaView) scenes.lookup("#mediaView");
                    MediaPlayer mediaPlayers = mediaViews.getMediaPlayer();

                    mediaPlayers.setOnEndOfMedia(() -> {
                        stages.close();
                    });

                });






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


                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), playNowImageView);
                scaleTransition.setToX(1.2);
                scaleTransition.setToY(1.2);
                scaleTransition.setAutoReverse(true);
                scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
                scaleTransition.play();

                helloScene.lookup("#playButton").setOnMouseEntered(event -> {
                    helloScene.setCursor(Cursor.HAND);
                });

                helloScene.lookup("#playButton").setOnMouseExited(event -> {
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

                        score = 0;
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
