package com.suganya.rockpaperscissor.model;

/**
 * Represents Gestures of the game
 *
 * Implementations of this interface has the behavior of the gesture if it can win or lose to another
 */
public sealed interface IGesture permits Rock, Paper, Scissor {
    /**
     * Finds if the gesture can beat other
     *
     * @param other gesture for comparison
     * @return
     */
    boolean canBeat(IGesture other);

    /**
     * Gives Success message when the gesture wins
     *
     * @return success message of the getsure
     */
    String getSuccessMessage();
}
