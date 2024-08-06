package com.suganya.rockpaperscissor.model;

/**
 * Represents ROCK gesture in the ROCK-PAPER-SCISSOR GAME
 */
public enum Rock implements IGesture {
    INSTANCE;

    /**
     * Rock can beat scissor
     * @param other gesture for comparison
     * @return
     */
    @Override
    public boolean canBeat(IGesture other) {
        return other == Scissor.INSTANCE;
    }

    /**
     *
     * @return Success message when Rock wins
     */
    @Override
    public String getSuccessMessage() {
        return "Rock beats (blunts) scissors";
    }

    @Override
    public String toString() {
        return "ROCK";
    }
}
