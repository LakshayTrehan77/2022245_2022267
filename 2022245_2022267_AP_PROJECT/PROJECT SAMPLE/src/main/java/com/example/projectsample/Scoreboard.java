package com.example.projectsample;

public class Scoreboard {
    private int currentScore = 0;
    private int bestScore = 0;

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public void updateScore(int points) {
        // Add your scoring logic here
        // For example, you can increment the score based on collected cherries
        currentScore += points;

        // Update the best score if the current score is higher
        if (currentScore > bestScore) {
            bestScore = currentScore;
        }
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getBestScore() {
        return bestScore;
    }
}
