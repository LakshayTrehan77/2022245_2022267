package com.example.projectsample;

// Class representing the Stick Hero character
class StickHero extends GameCharacter {
    private double stickLength;
    private boolean isFlipped;

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
    }

    // Override move method for Stick Hero
    @Override
    public void move() {
        // Implementation for Stick Hero movement
    }

    // Additional methods for Stick Hero, e.g., flipCharacter, fall, checkGameEnd, etc.
    public void flipCharacter() {
        // Implementation for flipping the character
        isFlipped = !isFlipped;
        checkGameEnd();
    }

    public void fall() {
        // Implementation for the hero falling into the abyss
        System.out.println("Hero fell into the abyss.");
        // You might want to perform additional actions when the hero falls
        // For example, end the game or show a game over screen
        // ...
    }

    private void checkGameEnd() {
        // Check if the character is in a flipped position and end the game if needed
        if (isFlipped) {
            System.out.println("Game Over - Character is flipped!");
            // You can add logic here to handle the game over scenario
            // For example, display a game over screen or reset the level
            // ...
        }
    }

    // Additional method for Stick Hero, e.g., extendStick, collectCherries, etc.
    public <T extends Collectible> void performAction(T collectible) {
        collectible.collect();
    }

    public void revive() {
        // Attempt to revive the character using ReviveFeature
        try {
            if (reviveFeature.checkRevivePossibility()) {
                // Deduct cherries and revive
                reviveFeature.deductCherries();
                System.out.println("Stick Hero revived!");
            } else {
                throw new StickHeroReviveException("Revival not possible - insufficient cherries.");
            }
        } catch (StickHeroGameException e) {
            // Handle the exception (log, display a message, etc.)
            System.out.println(e.getMessage());
        }
    }
}
