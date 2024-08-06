package com.suganya.rockpaperscissor.model;

/**
 * Represents SCISSOR gesture in the ROCK-PAPER-SCISSOR GAME
 */
public enum Scissor implements IGesture{
    INSTANCE;

    /**
     * Scissor can beat Paper
     * @param other gesture for comparison
     * @return
     */
    @Override
    public boolean canBeat(IGesture other) {
        return other == Paper.INSTANCE;
    }

    /**
     * Success message when Scissor wins
     * @return
     */
    @Override
    public String getSuccessMessage() {
        return "Scissor beats (cuts) paper";
    }

    @Override
    public String toString() {
        return "SCISSOR";
    }
}
