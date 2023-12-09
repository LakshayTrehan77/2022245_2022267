package com.example.projectsample;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;

import static com.example.projectsample.Scene3.*;

public class Scene4 {
    public ImageView revive;
    @FXML
    private Text currentscore;
    @FXML
    private Text bestscore;

    public Text getCurrentscore() {
        return currentscore;
    }

    public Text getBestscore() {
        return bestscore;
    }

    public ImageView getHome() {
        return home;
    }

    public ImageView getRevindbutton() {
        return revindbutton;
    }

    public Text getCondition() {
        return condition;
    }

    @FXML
    private ImageView home;
    @FXML
    private ImageView revindbutton;
    @FXML
    private Text condition;


    public static boolean reviveing = true;

    public void initialize() {
        // Assuming score is a variable defined in your class
        // Replace this with the actual score

        // Set the text for currentscore
        currentscore.setText(" " + score);

        // Set the text for bestscore
        bestscore.setText(" " + getBestScore());  // Replace getBestScore() with your logic to get the best score

        // Set up the event handler for homebutton
        home.setOnMouseClicked(this::handleHomeButtonClick);

        // Set up the event handler for revindbutton
        revindbutton.setOnMouseClicked(this::handleRevindButtonClick);

        revive.setOnMouseClicked(this::handleReviveButtonClick);

        condition.setVisible(false);
    }

    public void handleReviveButtonClick(MouseEvent event) {
        if (cherries > 5) {
            try {
                cherries-=5;
                reviveing = true;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the Scene
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setFullScreen(true);
                stage.show();




                // Close the current stage (Scene4.fxml)
                Stage currentStage = (Stage) revive.getScene().getWindow();
                currentStage.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            condition.setVisible(true);

        }
    }


    // You need to define a method to get the best score, replace this with your logic
    private int getBestScore() {
        // Replace this with the logic to get the best score
        return HighScore;
    }

    // Event handler for homebutton click
    public void handleHomeButtonClick(MouseEvent event) {
        try {
            // Load Scene1.fxml
            try {
                System.out.println("Lol");
                FXMLLoader helloLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                Parent helloRoot = helloLoader.load();
                Scene helloScene = new Scene(helloRoot);
                Stage stage = new Stage();
                stage.setScene(helloScene);
                stage.setFullScreen(true);
                stage.show();

                javafx.scene.image.ImageView playNowImageView = (javafx.scene.image.ImageView) helloScene.lookup("#playButton");
                Text cherriesText = (Text) helloScene.lookup("#cherriestext");
                Text cherriesscore = (Text) helloScene.lookup("#cherriesscore");

                cherriesText.setVisible(false);
                cherriesscore.setVisible(false);

                javafx.scene.image.ImageView Cherries = (javafx.scene.image.ImageView) helloScene.lookup("#cherrylogo");
                Cherries.setOnMouseClicked(events ->{
                    cherriesscore.setText(" " + cherries);
                    cherriesText.setVisible(true);


                    cherriesscore.setVisible(true);
                });

                javafx.scene.image.ImageView TutorialImageView = (javafx.scene.image.ImageView) helloScene.lookup("#Tutorial");


// Make the sound off button clickable
                TutorialImageView.setOnMouseClicked(eventww -> {
                    FXMLLoader loaders = new FXMLLoader(StickHeroGame.class.getResource("Scene5.fxml"));
                    Parent roots;
                    try {
                        roots = loaders.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    // Set up the primary stage
                    Scene scenes = new Scene(roots);
                    Stage stages = new Stage();
                    stages.setFullScreen(true);
                    scenes.setFill(null);
                    stages.setTitle("Stick Hero Game");
                    stages.setScene(scenes);
                    stages.show();

                    // Find the MediaView and MediaPlayer
                    MediaView mediaViews = (MediaView) scenes.lookup("#mediaView");
                    MediaPlayer mediaPlayers = mediaViews.getMediaPlayer();

                    mediaPlayers.setOnEndOfMedia(() -> {
                        stages.close();
                    });

                });

                // Add ScaleTransition to the "Play Now" button
                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), playNowImageView);
                scaleTransition.setToX(1.2); // Adjust the scaling factors as needed
                scaleTransition.setToY(1.2);
                scaleTransition.setAutoReverse(true); // Reverse the animation direction
                scaleTransition.setCycleCount(ScaleTransition.INDEFINITE); // Repeat indefinitely
                scaleTransition.play();
                // Assuming there is a button with the id "playButton" in Scene2.fxml
                helloScene.lookup("#playButton").setOnMouseEntered(events -> {
                    // Set the cursor to HAND when hovering over the button
                    helloScene.setCursor(Cursor.HAND);
                });

                helloScene.lookup("#playButton").setOnMouseExited(events -> {
                    // Set the default cursor when not hovering over the button
                    helloScene.setCursor(Cursor.DEFAULT);
                });

                helloScene.lookup("#playButton").setOnMouseClicked(events -> {
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
                ;
            } catch (Exception e) {
                e.printStackTrace();
            }


            // Close the current stage (Scene4.fxml)
            Stage currentStage = (Stage) home.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleRevindButtonClick(MouseEvent event) {


            try {

                // Load Scene3.fxml
                System.out.println("Clicked on the revind button");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
                Parent root = loader.load();
                score = 0;

                // Create a new stage and set the Scene
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setFullScreen(true);
                stage.show();







                // Close the current stage (Scene4.fxml)
                Stage currentStage = (Stage) revindbutton.getScene().getWindow();
                currentStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }




    // Event handler for revindbutton click


