package com.example.projectsample;

// Specific exceptions derived from StickHeroGameException
class StickHeroCollisionException extends StickHeroGameException {
    public StickHeroCollisionException(String message) {
        super(message);
    }
}