package com.example.projectsample;

import com.example.projectsample.SoundEffects;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
        double specificX = 100.0;  // Replace with your specific X value
        double specificY = 200.0;  // Replace with your specific Y value
        double specificStickLength = 150.0;  // Replace with your specific stick length



    }

    // Method to render platforms
    public void renderPlatforms(List<Platform> platforms) {
        gc.setFill(Color.GREEN); // Set the platform color (modify as needed)

        for (Platform platform : platforms) {
            gc.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());
        }
    }

    // Method to render cherries
    public void renderCherries(List<Cherry> cherries) {
        gc.setFill(Color.RED); // Set the cherry color (modify as needed)

        for (Cherry cherry : cherries) {
            gc.fillOval(cherry.getX(), cherry.getY(), 20, 20); // Example: Draw a circle as the cherry
        }
    }




    // Method to play background music using SoundEffects
    public void playBackgroundMusic() {
        soundEffects.playBackgroundMusic();
    }

    // Method to play collect cherry sound using SoundEffects

}
