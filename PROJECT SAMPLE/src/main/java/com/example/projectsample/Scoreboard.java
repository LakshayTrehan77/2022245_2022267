package com.example.projectsample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Scoreboard {
    @FXML
    private Text scoreText;

    private Rectangle stickRectangle;

    private final IntegerProperty currentScore = new SimpleIntegerProperty(0);
    private final IntegerProperty bestScore = new SimpleIntegerProperty(0);

    public void setCurrentScore(int currentScore) {
        this.currentScore.set(currentScore);
    }

    public void setBestScore(int bestScore) {
        this.bestScore.set(bestScore);
    }

    public void updateScore(int points) {
        // Add your scoring logic here
        // For example, you can increment the score based on collected cherries
        currentScore.set(currentScore.get() + points);

        // Update the best score if the current score is higher
        if (currentScore.get() > bestScore.get()) {
            bestScore.set(currentScore.get());
        }

        // Update the score text in the FXML
        scoreText.setText(String.format("%02d", currentScore.get()));
    }




    public int getCurrentScore() {
        return currentScore.get();
    }

    public IntegerProperty currentScoreProperty() {
        return currentScore;
    }

    public int getBestScore() {
        return bestScore.get();
    }

    public IntegerProperty bestScoreProperty() {
        return bestScore;
    }
}
