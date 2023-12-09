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

        // Set the text for currentscore
        currentscore.setText(" " + score);

        // Set the text for bestscore
        bestscore.setText(" " + getBestScore());

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

    private int getBestScore() {
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

                // Add ScaleTransition to the "Play Now" button
                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), playNowImageView);
                scaleTransition.setToX(1.2);
                scaleTransition.setToY(1.2);
                scaleTransition.setAutoReverse(true);
                scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
                scaleTransition.play();

                helloScene.lookup("#playButton").setOnMouseEntered(events -> {
                    helloScene.setCursor(Cursor.HAND);
                });

                helloScene.lookup("#playButton").setOnMouseExited(events -> {
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






