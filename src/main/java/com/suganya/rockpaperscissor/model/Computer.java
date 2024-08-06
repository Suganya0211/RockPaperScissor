package com.suganya.rockpaperscissor.model;

/**
 * Represents Computer(Player) of the game
 */
public class Computer {
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
        return "Computer{" + "gesture=" + gesture + ", score=" + score + '}';
    }
}
