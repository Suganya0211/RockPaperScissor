package com.suganya.rockpaperscissor.model;

/**
 * Result of the game to represent the winner
 */
public enum Result {
    COMPUTER_WINS("Computer Wins!"),
    PLAYER_WINS("Player Wins!"),
    DRAW("It's a draw!");

    private final String message;

    Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
