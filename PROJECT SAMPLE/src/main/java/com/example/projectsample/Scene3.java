package com.example.projectsample;


import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.junit.jupiter.api.Test;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.projectsample.GameLevel.restartLevel;
import static com.example.projectsample.GameLevel.saveProgress;
import static com.example.projectsample.Scene4.reviveing;
import static com.example.projectsample.StickHeroGame.loadScene4;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Scene3 extends Thread{

    @FXML
    private Rectangle stickRectangle;
    @FXML
    private ImageView bgImage;

    @FXML
    private ImageView standingtower;

    private StickHero stickHero;

    @FXML
    private Text level;
    private int currentLevel = 0;

    @FXML
    private ImageView cherryImage;

    public Rectangle getStickRectangle() {
        return stickRectangle;
    }

    public ImageView getBgImage() {
        return bgImage;
    }

    public ImageView getStandingtower() {
        return standingtower;
    }

    public StickHero getStickHero() {
        return stickHero;
    }

    public ImageView getCherryImage() {
        return cherryImage;
    }

    public ImageView getHeroImageView() {
        return heroImageView;
    }

    public Text getScorecard() {
        return Scorecard;
    }

    public Text getCherry() {
        return cherry;
    }

    public static int getScore() {
        return score;
    }

    public int getCherries() {
        return cherries;
    }

    public static int getHighScore() {
        return HighScore;
    }

    public static boolean isGameover() {
        return gameover;
    }

    public ImageView getNewTowerImageView() {
        return newTowerImageView;
    }

    public ImageView getGamma() {
        return gamma;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static boolean isFilpped() {
        return filpped;
    }

    public static boolean isCounted() {
        return counted;
    }

    public int getCliked() {
        return cliked;
    }

    public boolean isHeroNotLandedLogicExecuted() {
        return heroNotLandedLogicExecuted;
    }

    @FXML
    public ImageView heroImageView;

    @FXML
    private Text Scorecard;

    @FXML
    private Text cherry;

    public static int score;

    public static int  cherries = 0;

    public static int HighScore = 0;

    public static boolean gameover = false;
    @FXML
    private ImageView newTowerImageView;

    @FXML
    private ImageView gamma;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private Stage primaryStage;



    public void setStickRectangle(Rectangle stickRectangle) {
        this.stickRectangle = stickRectangle;
    }


    public static boolean movement = false;

    public static boolean isMovementActive() {
        return movement;
    }


    int cliked = 0;








    @FXML
    public void initialize() {

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(25), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        increaseLevel();
                    }
                })
        );

        // Repeat the timeline indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        // Create an instance of StickHero and set its stickRectangle


        stickHero = new StickHero(0, 0, 0, 0, 0, 0);

        stickHero.setStickRectangle(stickRectangle);


        // Set up event handler for mouse pressed on the stickRectangle
        stickRectangle.setOnMousePressed(this::handleMousePressed);

        // Set up event handler for mouse clicked on the stickRectangle
        stickRectangle.setOnMouseClicked(this::handleMouseClicked);

        gamma.setVisible(false);

        bgImage.setOnMouseClicked(this::handleBgImageClicked);


        cliked = 0;

        filpped = false;







        counted = false;

        filpped = false;

        cherry.setText(" " + cherries);
        //This is the latest code

        Platform platform = new Platform(0,0,100 , 100);
        List<Platform> platforms = new ArrayList<Platform>();
        Cherry cherry = Cherry.getInstance(0 , 0 );
        List<Cherry> cherrys = new ArrayList<Cherry>();

        GameLevel level = new GameLevel(stickHero , platforms , cherrys );
        level.loadLevel();

        SoundEffects soundEffects = new SoundEffects();











    }
    private static boolean filpped = false;
    private static boolean counted = false;



    private void increaseLevel() {
        // Increase the level and update the Text
        currentLevel++;
        level.setText(" " + currentLevel);
    }
    private void checkForCherryIntersection() {
        Thread cherryThread = new Thread(() -> {
            if (heroImageView.getBoundsInParent().intersects(cherryImage.getBoundsInParent()) && heroImageView.getTranslateX() > cherryImage.getTranslateX()) {
                cherries++;
                cherry.setText("" + cherries);
                cherryImage.setVisible(false);
                counted = true;
            }
        });

        cherryThread.start();
    }

    private void handleBgImageClicked(MouseEvent event) {
        Thread bgImageThread = new Thread(() -> {
            // Toggle the vertical flip property of heroImageView
            if (cliked % 2 == 0) {
                heroImageView.setTranslateY(60);
                filpped = false;
            } else {
                heroImageView.setTranslateY(-60);
                filpped = true;
            }

            cliked++;
            heroImageView.setScaleY(heroImageView.getScaleY() * -1);
        });

        bgImageThread.start();
    }


    // Event handler for mouse pressed on the stickRectangle
    private void handleMousePressed(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            // Create and start two threads in parallel
            Thread t1 = new Thread(() -> {
                // Call the extendStick method directly from the StickHero instance
                stickHero.startExtendStick();
            });

            Thread t2 = new Thread(() -> {
                // Check for cherry intersection
                checkForCherryIntersection();
            });

            // Start the threads in parallel
            t1.start();
            t2.start();
        }
    }



    // Global event handler for mouse clicks
    @FXML
    private void handleMouseClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            // Call the extendStick method directly from the StickHero instance
            //and intersects with newTowerImageView
            Thread t1 = new Thread(() -> {
                // Call the extendStick method directly from the StickHero instance
                stickHero.startExtendStick();
            });

            Thread t2 = new Thread(() -> {
                // Check for cherry intersection
                checkForCherryIntersection();

                // Check if heroImageView is flipped and intersects with newTowerImageView
                // (Add your logic here)
            });

            // Start the threads in parallel
            t1.start();
            t2.start();
        }

        }


    private void handleHeroNotLandedOnTower() {
        // Create and start two threads in parallel
        Thread t1 = new Thread(() -> {
            // Hero gradually falls
            TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(2), heroImageView);
            fallTransition.setToY(500); // Adjust the Y value as needed
            fallTransition.play();
        });

        Thread t2 = new Thread(() -> {
            // Rotate the hero continuously
            RotateTransition rotateHero = new RotateTransition(Duration.seconds(1), heroImageView);
            rotateHero.setByAngle(360);
            rotateHero.setCycleCount(2);
            rotateHero.play();

            rotateHero.setOnFinished(ROTATED -> {
                gameover = true;
            });
        });

        // Start the threads in parallel
        t1.start();
        t2.start();
    }


    private boolean heroNotLandedLogicExecuted = false;




    @FXML
    public void handleMouseReleased(MouseEvent event) throws InterruptedException {
        if (event.getButton() == MouseButton.PRIMARY) {
            // Stop extending the stick when mouse is released
            stickHero.stopExtendStick();


            ExecutorService executorService = Executors.newFixedThreadPool(1);



            executorService.submit(() -> {


                // Create a translation animation to move the hero image along with the falling stick
                TranslateTransition heroTranslateTransition = new TranslateTransition(Duration.seconds(1), heroImageView);

                double rotate = stickRectangle.getHeight() / 2;
// Create a timeline to update the hero's X translation gradually
                Timeline checkCherryIntersectionTimeline = new Timeline(
                        new KeyFrame(Duration.millis(0.5), evenAt -> {
                            if (!counted && heroImageView.getBoundsInParent().intersects(cherryImage.getBoundsInParent())) {
                                System.out.println("YAYAYYAYAYAYAYAYYAY");
                                cherries++;
                                cherry.setText("" + cherries);
                                cherryImage.setVisible(false);
                                counted = true;
                                Cherry cherry = Cherry.getInstance(cherryImage.getTranslateX(), cherryImage.getTranslateY());
                                cherry.collect();
                            }


                        })
                );
                checkCherryIntersectionTimeline.setCycleCount(Timeline.INDEFINITE);
                checkCherryIntersectionTimeline.play();


// Create a timeline to update the hero's X translation gradually
                Timeline heroMoveTimeline = new Timeline(
                        new KeyFrame(Duration.seconds(5), new KeyValue(heroImageView.translateXProperty(), (-550 + rotate + 35)))

                );

                movement = true;


                System.out.println(rotate);

// Play both the translation transition and the timeline together
                ParallelTransition parallelTransition = new ParallelTransition(heroTranslateTransition, heroMoveTimeline);
                parallelTransition.play();


                parallelTransition.setOnFinished(finisher -> {
                    if (stickRectangle.getBoundsInParent().intersects(newTowerImageView.getBoundsInParent())
                            && stickRectangle.getBoundsInParent().getMaxX() < newTowerImageView.getBoundsInParent().getMaxX() && filpped) {


                        // Your code here


                        // Hero landed on the tower
                        System.out.println("Stick landed on the tower!");


                        score++;
                        Scorecard.setText("" + score);
                        if (score > HighScore) {
                            HighScore = score;
                        }


                        TranslateTransition moveLeftTransition = new TranslateTransition(Duration.seconds(1), newTowerImageView);
                        moveLeftTransition.setToX(-700);
                        moveLeftTransition.play();


                        TranslateTransition moveLeftTransitions = new TranslateTransition(Duration.seconds(1), heroImageView);
                        moveLeftTransitions.setToX(-700);

                        moveLeftTransitions.setOnFinished(finishedEventS -> {
                            // Reset positions for the next interaction
                            heroImageView.setTranslateX(-670);
                            stickRectangle.setTranslateX(-555);

                            checkForCherryIntersection();

                            newTowerImageView.setVisible(true);
                            stickRectangle.setVisible(false);

                            // Create a rotation animation to make the stick fall horizontally
                            RotateTransition rotateTransitions = new RotateTransition(Duration.seconds(0.1), stickRectangle);
                            rotateTransitions.setToAngle(270);
                            rotateTransitions.play();
                            rotateTransitions.setOnFinished(rotateFinishedEvent -> {
                                // Set the stickRectangle to a 90-degree rotation
                                stickRectangle.setRotate(0);
                                stickRectangle.setHeight(100);
                                stickRectangle.setVisible(true);

                                double randomFitWidth = Math.random() * (100 - 50) + 50;
                                newTowerImageView.setFitWidth(randomFitWidth);

                                double randomTranslateX = Math.random() * (400 - (-500)) - 500;
                                newTowerImageView.setTranslateX(randomTranslateX);
                                stickRectangle.setTranslateY(0);

                                cherryImage.setVisible(true);

                                double towerWidthMargin = 50; // Adjust the margin as needed

                                double standingTowerRightEdge = standingtower.getTranslateX() + standingtower.getFitWidth() + towerWidthMargin;

                                double newTowerLeftEdge = newTowerImageView.getTranslateX() - towerWidthMargin;

                                double minDistanceBetweenEdges = newTowerLeftEdge - standingTowerRightEdge;

                                if (minDistanceBetweenEdges < 0 || newTowerImageView.getBoundsInParent().intersects(cherryImage.getBoundsInParent()) || cherryImage.getTranslateX() > newTowerImageView.getTranslateX()) {
                                    cherryImage.setVisible(false);
                                    System.out.println("ENTERED LOL CONDITION");
                                    System.out.println(cherryImage.getTranslateX() + " " + newTowerImageView.getTranslateX());
                                    System.out.println(cherryImage.getTranslateX() > newTowerImageView.getTranslateX());
                                } else {
                                    System.out.println(cherryImage.getTranslateX() + " " + newTowerImageView.getTranslateX());
                                    System.out.println(cherryImage.getTranslateX() > newTowerImageView.getTranslateX());
                                    double randomPosition = Math.random() * (minDistanceBetweenEdges) + standingTowerRightEdge;

                                    // Ensure that the random position is within the specified range
                                    randomPosition = Math.min(randomPosition, newTowerLeftEdge - towerWidthMargin);

                                    cherryImage.setTranslateX(randomPosition);
                                    cherryImage.setTranslateY(50); // Adjust the Y value as needed
                                    cherryImage.setVisible(true);
                                }


                            });

                            // Add any additional setup needed for the next interaction
                        });

                        moveLeftTransitions.play();

                        restartgame();

                    } else {


                        System.out.println("Stick doesn't land on the tower!");

                        checkForCherryIntersection();

                        // Hero gradually falls
                        TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(2), heroImageView);
                        fallTransition.setToY(500); // Adjust the Y value as needed
                        fallTransition.play();

                        // Rotate the hero continuously
                        RotateTransition rotateHero = new RotateTransition(Duration.seconds(1), heroImageView);
                        rotateHero.setByAngle(360);
                        rotateHero.setCycleCount(2);
                        rotateHero.play();

                        rotateHero.setOnFinished(ROTATED -> {
                            gameover = true;
                            saveProgress();
                            loadScene4();


                        });


                    }
                });


                // Check if the stick landed on the tower
            }); executorService.close();
        }}

    private void restartgame() {
        // Create and start two threads in parallel
        Thread t1 = new Thread(() -> {
            restartLevel();
        });

        Thread t2 = new Thread(() -> {
            initialize();
        });

        // Start the threads in parallel
        t1.start();
        t2.start();
    }



    // Add other methods for interacting with the Rectangle or StickHero as needed
}