package com.suganya.rockpaperscissor.factory;

import com.suganya.rockpaperscissor.model.IGesture;
import com.suganya.rockpaperscissor.model.Paper;
import com.suganya.rockpaperscissor.model.Rock;
import com.suganya.rockpaperscissor.model.Scissor;

import java.util.Random;

/**
 * Generates IGesture of the players
 *
 */
public class GestureFactory {

    private static Random random = new Random();

    /**
     * Creates player gesture for input
     *
     * @param playerInput
     * @return the respective IGesture
     * @throws IllegalArgumentException for Invalid input
     */
    public static IGesture createPlayerGesture(int playerInput) {
        return switch (playerInput) {
            case 1 -> Rock.INSTANCE;
            case 2 -> Paper.INSTANCE;
            case 3 -> Scissor.INSTANCE;
            default -> throw new IllegalArgumentException("Invalid input by player: " + playerInput);
        };
    }

    /**
     * Generates random gesture for computer
     *
     * @return a Random IGesture
     */
    public static IGesture generateComputerGesture() {
        IGesture[] gestures = {Rock.INSTANCE, Paper.INSTANCE, Scissor.INSTANCE};
        return gestures[random.nextInt(gestures.length)];
    }
}
