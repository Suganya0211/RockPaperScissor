package com.suganya.rockpaperscissor.model;

import java.util.logging.Logger;

/**
 * Represents player of the game
 *
 */
public class Player {

    private IGesture gesture;
    private int score;

    public IGesture getGesture() {
        return gesture;
    }

    public void setGesture(IGesture gesture) {
        this.gesture = gesture;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "gesture=" + gesture +
                ", score=" + score +
                '}';
    }
}
