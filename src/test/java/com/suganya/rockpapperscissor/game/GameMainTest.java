package com.suganya.rockpapperscissor.game;

import com.suganya.rockpaperscissor.game.GameMain;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for GameMain
 *
 */
public class GameMainTest {

    @Test
    void testGetNoOfRounds_ValidInput() {
        String input = "5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int rounds = GameMain.getNoOfRounds(scanner);
        assertEquals(5, rounds, "The number of rounds should be 5.");
    }


    @Test
    void testGetNoOfRounds_InvalidInputThenValidInput() {
        String input = "invalid\nanotherInvalid\n3\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int rounds = GameMain.getNoOfRounds(scanner);
        assertEquals(3, rounds, "The number of rounds should be 3 after invalid inputs.");
    }
}
