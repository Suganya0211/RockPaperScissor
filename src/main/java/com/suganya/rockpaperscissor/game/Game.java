package com.suganya.rockpaperscissor.game;

import com.suganya.rockpaperscissor.factory.GestureFactory;
import com.suganya.rockpaperscissor.model.Computer;
import com.suganya.rockpaperscissor.model.IGesture;
import com.suganya.rockpaperscissor.model.Player;
import com.suganya.rockpaperscissor.model.Result;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Represents Game between a Player and a computer
 *
 */
public class Game {
    private static final Logger logger = Logger.getLogger(Game.class.getName());

    private final Scanner input;
    private final Player player;
    private final Computer computer;
    private int roundsPlayed = 0;

    public Game(Scanner input, Player player, Computer computer) {
        this.input = input;
        this.player = player;
        this.computer = computer;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public Game(Player player, Computer computer) {
        this.input = null;
        this.player = player;
        this.computer = computer;
    }

    public void start(int rounds) {
        playGame(rounds);
        calculateFinalScore();
    }

    /**
     * Plays the game for specified number of rounds
     *
     * @param rounds
     */
    private void playGame(int rounds) {
        for (int i = 0; i < rounds; i++) {
            Integer playerInput = getPlayerInput(input);
            if (playerInput == null) {
                return;
            }

            try {
                IGesture playerGesture = GestureFactory.createPlayerGesture(playerInput);
                player.setGesture(playerGesture);
            } catch (IllegalArgumentException e) {
                logger.warning("Invalid Input!! Exiting the Game");
                return;
            }
            computer.setGesture(GestureFactory.generateComputerGesture());
            logger.info("Player Gesture: " + player.getGesture());
            logger.info("Computer Gesture: " + computer.getGesture());
            findWinner(player, computer);
            roundsPlayed++;
        }
    }

    /**
     * Takes the player's choice(gesture) from Rock,Paper,Scissor
     * valid input 1 - 4
     * @param input
     * @return
     */
    private Integer getPlayerInput(Scanner input) {
        logger.info("Choose your gesture: \n" +
                "1.Rock\n" +
                "2.Paper\n" +
                "3.Scissor\n" +
                "4.Exit");

        try {
            int playerInput = input.nextInt();
            if (playerInput == 4) {
                logger.info("Exiting the game");
                return null;
            }

            if (playerInput >= 1 && playerInput <= 3)
                return playerInput;
            else {
                logger.warning("Invalid choice, Please choose between 1 and 4");
            }
        } catch (InputMismatchException e) {
            logger.warning("Invalid input! Exiting the game");
            return null;
        }
        return null;
    }

    /**
     * Finds the winner by comparing the gestures and increments the score of winner
     *
     * @param player
     * @param computer
     */
    public void findWinner(Player player, Computer computer) {
        if (player.getGesture() == computer.getGesture()) {
            logger.info(Result.DRAW.getMessage());
        } else if (player.getGesture().canBeat(computer.getGesture())) {
            logger.info(Result.PLAYER_WINS.getMessage() + player.getGesture().getSuccessMessage());
            player.incrementScore();
        } else {
            logger.info(Result.COMPUTER_WINS.getMessage() + computer.getGesture().getSuccessMessage());
            computer.incrementScore();
        }
    }

    /**
     * Displays the score of the players and the winner based on final score
     */
    public void calculateFinalScore() {
        logger.info("----------------Final Score----------------------");
        if (computer.getScore() > player.getScore()) {
            logger.info(Result.COMPUTER_WINS.getMessage());
        } else if (computer.getScore() == player.getScore()) {
            logger.info(Result.DRAW.getMessage());
        } else {
            logger.info(Result.PLAYER_WINS.getMessage());
        }

        logger.info("GAMES PLAYED: " + roundsPlayed);
        logger.info("COMPUTER SCORE: " + computer.getScore());
        logger.info("PLAYER SCORE: " + player.getScore());
        int draws = roundsPlayed - (computer.getScore() + player.getScore());
        logger.info("DRAWS: " + draws);
    }

}
