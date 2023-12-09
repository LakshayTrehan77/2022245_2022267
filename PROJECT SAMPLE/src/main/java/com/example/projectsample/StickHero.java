package com.example.projectsample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

// Class representing the Stick Hero character
public class StickHero extends GameCharacter {
    private double stickLength;
    private boolean isFlipped;
    private Timeline extendTimeline;




    private Rectangle stickRectangle;

    public Timeline getExtendTimeline() {
        return extendTimeline;
    }

    public Rectangle getStickRectangle() {
        return stickRectangle;
    }

    public ImageView getHeroImageViews() {
        return heroImageViews;
    }

    public ImageView getNewTowerImageView() {
        return newTowerImageView;
    }

    public long getMousePressTime() {
        return mousePressTime;
    }

    public RotateTransition getRotateTransition() {
        return rotateTransition;
    }

    @FXML
    private ImageView heroImageViews;



    @FXML
    private ImageView newTowerImageView;
    private long mousePressTime; // Variable to store the time when the mouse is pressed

    public double getStickLength() {
        return stickLength;
    }

    public void setStickLength(double stickLength) {
        this.stickLength = stickLength;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public ReviveFeature getReviveFeature() {
        return reviveFeature;
    }

    public void setReviveFeature(ReviveFeature reviveFeature) {
        this.reviveFeature = reviveFeature;
    }

    private ReviveFeature reviveFeature; // Add a field for ReviveFeature

    // Constructor
    public StickHero(double x, double y, double width, double height, double velocity, double stickLength) {
        super(x, y, width, height, velocity);
        this.stickLength = stickLength;
        this.isFlipped = false;
        this.stickRectangle = new Rectangle(9.0, 300.0); // Initial values for the stickRectangle
        // Set the initial position of the stickRectangle
        this.stickRectangle.setTranslateX(-555.0);
        this.stickRectangle.setTranslateY(0.0);
        this.extendTimeline = new Timeline(new KeyFrame(Duration.millis(16), this::extendStick));
        this.extendTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void extendStick(ActionEvent actionEvent) {
        stickRectangle.setHeight(stickRectangle.getHeight() + 5.0); // Adjust the increment as needed
    }

    public void startExtendStick() {
        // Capture the time when the mouse is pressed
        mousePressTime = System.currentTimeMillis();
        extendTimeline.play();
    }
    RotateTransition rotateTransition;

    // New method to stop extending the stick
    public void stopExtendStick() {
        extendTimeline.pause();

        // Calculate the duration the mouse was held down
        long mouseHoldDuration = System.currentTimeMillis() - mousePressTime;

        // Update the duration of the Timeline based on the mouse hold duration

        extendTimeline.getKeyFrames().setAll(
                new KeyFrame(Duration.millis(mouseHoldDuration), this::extendStick)

        );
        rotateTransition = new RotateTransition(Duration.seconds(1), stickRectangle);
        rotateTransition.setToAngle(90); // Rotate to 90 degrees (horizontal)
        rotateTransition.play();
    }

    private void rotateAndFallStick(ActionEvent actionEvent) {
        // Rotate the stickRectangle 90 degrees to the right

        // Implement a falling animation, e.g., translate the stickRectangle downward
        Timeline fallTimeline = new Timeline(new KeyFrame(Duration.millis(0), event -> {
            stickRectangle.setTranslateY(stickRectangle.getTranslateY() + 5.0); // Adjust the increment as needed
        }));
        fallTimeline.setCycleCount(50); // Adjust the cycle count for a smoother falling animation
        fallTimeline.play();

        // You may want to add additional logic here, such as checking for collisions or updating game state
    }


    // Override move method for Stick Hero
    @Override
    public void move() {
        int rotate = (int) (heroImageViews.getFitWidth()/2);
        Timeline heroMoveTimeline = new Timeline(
                new KeyFrame(Duration.seconds(5), new KeyValue(heroImageViews.translateXProperty(), (-550 + rotate + 35)))

        );

    }


    // Additional methods for Stick Hero, e.g., flipCharacter, fall, checkGameEnd, etc.



    public void setStickRectangle(Rectangle stickRectangle) {
        this.stickRectangle = stickRectangle;
    }

    // Additional method for Stick Hero, e.g., collectCherries, revive, etc.

    // ... (existing code)
}
