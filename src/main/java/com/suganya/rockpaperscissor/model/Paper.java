package com.suganya.rockpaperscissor.model;

/**
 * Represents PAPER gesture in the ROCK-PAPER-SCISSOR GAME
 */
public enum Paper implements IGesture {
    INSTANCE;

    /**
     * Paper can beat rock
     * @param other gesture for comparison
     * @return
     */
    @Override
    public boolean canBeat(IGesture other) {
        return other == Rock.INSTANCE;
    }

    /**
     * Success message when Paper wins
     *
     * @return
     */
    @Override
    public String getSuccessMessage() {
        return "Paper beats (wraps) rock";
    }

    @Override
    public String toString() {
        return "PAPER";
    }
}
