package com.example.projectsample;

// Abstract class representing a game character
abstract class GameCharacter {
    protected double x, y, width, height, velocity;

    // Constructor
    public GameCharacter(double x, double y, double width, double height, double velocity) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }

    // Abstract method for character movement
    public abstract void move();
}