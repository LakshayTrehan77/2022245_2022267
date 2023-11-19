package com.example.projectsample;

import com.example.projectsample.SoundEffects;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

class GameGraphics {
    private Canvas gameCanvas;
    private GraphicsContext gc;

    public Canvas getGameCanvas() {
        return gameCanvas;
    }

    public void setGameCanvas(Canvas gameCanvas) {
        this.gameCanvas = gameCanvas;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public SoundEffects getSoundEffects() {
        return soundEffects;
    }

    public void setSoundEffects(SoundEffects soundEffects) {
        this.soundEffects = soundEffects;
    }

    private SoundEffects soundEffects; // Composition relationship

    // Constructor
    public GameGraphics(Canvas gameCanvas) {
        this.gameCanvas = gameCanvas;
        this.gc = gameCanvas.getGraphicsContext2D();
        this.soundEffects = new SoundEffects(); // Instantiate SoundEffects
    }

    // Methods for rendering game elements
    public void renderCharacter(StickHero stickHero) {
        // Implementation for rendering the character
    }

    public void renderPlatforms(List<Platform> platforms) {
        // Implementation for rendering platforms
    }

    public void renderCherries(List<Cherry> cherries) {
        // Implementation for rendering cherries
    }

    public void animateCharacter() {
        // Implementation for animating the character
    }

    // Method to play background music using SoundEffects
    public void playBackgroundMusic() {
        soundEffects.playBackgroundMusic();
    }

    // Method to play collect cherry sound using SoundEffects
    public void playCollectCherrySound() {
        soundEffects.playCollectCherrySound();
    }

    // Method to play fall sound using SoundEffects
    public void playFallSound() {
        soundEffects.playFallSound();
    }
}
