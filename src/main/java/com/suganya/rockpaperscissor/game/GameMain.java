package com.suganya.rockpaperscissor.game;

import com.suganya.rockpaperscissor.model.Computer;
import com.suganya.rockpaperscissor.model.Player;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * ROCK-PAPER-SCISSOR Game main
 *
 * @author Suganya
 */
public class GameMain {
    private static final Logger logger = Logger.getLogger(GameMain.class.getName());

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int rounds = getNoOfRounds(input);
            Player player = new Player();
            Computer computer = new Computer();
            Game game = new Game(input, player, computer);
            game.start(rounds);
        }
    }

    /**
     * Takes the number of times the player wish to play
     *
     * @param input - number of plays
     * @return
     */
    public static int getNoOfRounds(Scanner input) {
        logger.info("--------------GAME STARTS------------");
        logger.info("Enter the number of rounds you want to play:");
        while (true) {
            if (input.hasNextInt()) {
                int rounds = input.nextInt();
                if (rounds > 0) {
                    return rounds;
                } else {
                    logger.warning("The number of rounds must be greater than 0. Please enter a valid number:");
                }
            } else {
                logger.warning("Invalid input. Please enter a valid number:");
                input.next();
            }
        }
    }

}
