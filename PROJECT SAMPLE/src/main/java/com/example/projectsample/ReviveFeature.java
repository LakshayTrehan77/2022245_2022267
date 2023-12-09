package com.example.projectsample;

// Class representing the ReviveFeature
class ReviveFeature {
    private int cherriesRequired = 5;
    private int previousScore;
    private StickHeroReviveException reviveException;

    public int getCherriesRequired() {
        return cherriesRequired;
    }

    public void setCherriesRequired(int cherriesRequired) {
        this.cherriesRequired = cherriesRequired;
    }

    public void setPreviousScore(int storedScore) {
        this.previousScore = storedScore;
        this.reviveException = new StickHeroReviveException("Revive not possible");

    }

    // Constructor
    public ReviveFeature(int cherriesRequired) {
        this.cherriesRequired = cherriesRequired;
    }

    // Methods for revive feature
    public boolean checkRevivePossibility() throws StickHeroReviveException {
        if (cherriesRequired>=cherriesRequired) {
            throw reviveException;
        }
        return true;
    }


}
