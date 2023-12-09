package com.example.projectsample;

// Class representing a game collectible (e.g., cherries)
class Cherry implements Collectible {
    private static Cherry instance;
    private double x, y;

    private Cherry(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Cherry getInstance(double x, double y) {
        if (instance == null) {
            instance = new Cherry(x, y);
        }
        return instance;
    }

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

    // Override collect method for cherries
    @Override
    public void collect() {
        System.out.println("Cherry Collected");
    }
}
