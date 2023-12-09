package com.example.projectsample;

import java.util.List;

// Class representing the game level
class GameLevel implements Level {
    private StickHero stickHero;
    private List<Platform> platforms;

    public void setStickHero(StickHero stickHero) {
        this.stickHero = stickHero;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public void setCherries(List<Cherry> cherries) {
        this.cherries = cherries;
    }

    private List<Cherry> cherries;

    public GameLevel(StickHero stickHero, List<Platform> platforms, List<Cherry> cherries) {
        this.stickHero = stickHero;
        this.platforms = platforms;
        this.cherries = cherries;
    }



    public StickHero getStickHero() {
        return stickHero;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public List<Cherry> getCherries() {
        return cherries;
    }

    // Implementation of interface methods
    @Override
    public void loadLevel() {
        // Implementation for loading a level
    }



    public void saveProgress() {
        // Implementation for saving progress
    }



    public void loadGame() {
        // Implementation for loading a saved game
    }
}

