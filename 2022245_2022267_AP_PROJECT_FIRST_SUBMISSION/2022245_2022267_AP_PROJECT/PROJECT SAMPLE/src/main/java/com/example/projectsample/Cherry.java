package com.example.projectsample;

// Class representing a game collectible (e.g., cherries)
class Cherry implements Collectible {
    private double x, y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Constructor
    public Cherry(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Override collect method for cherries
    @Override
    public void collect() {
        // Implementation for collecting cherries
    }
}
