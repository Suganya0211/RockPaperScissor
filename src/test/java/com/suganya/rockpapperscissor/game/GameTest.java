package com.suganya.rockpapperscissor.game;

import com.suganya.rockpaperscissor.factory.GestureFactory;
import com.suganya.rockpaperscissor.game.Game;
import com.suganya.rockpaperscissor.model.Computer;
import com.suganya.rockpaperscissor.model.IGesture;
import com.suganya.rockpaperscissor.model.Player;
import com.suganya.rockpaperscissor.model.Result;
import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for Game Test
 *
 */
public class GameTest {

    private Player player;
    private Computer computer;
    private Game game;
    private LogCaptor logCaptor;

    @BeforeEach
    void setUp() {
        player = mock(Player.class);
        computer = mock(Computer.class);
        game = new Game(player, computer);
        logCaptor = LogCaptor.forClass(Game.class);
    }

    @Test
    void testFindWinner_Draw() {
        IGesture gesture = GestureFactory.createPlayerGesture(1);
        when(player.getGesture()).thenReturn(gesture);
        when(computer.getGesture()).thenReturn(gesture);

        game.findWinner(player, computer);
        assertTrue(logCaptor.getInfoLogs().contains(Result.DRAW.getMessage()));
    }

    @Test
    void testFindWinner_PlayerWins() {
        IGesture playerGesture = GestureFactory.createPlayerGesture(1);
        IGesture computerGesture = GestureFactory.createPlayerGesture(3);
        when(player.getGesture()).thenReturn(playerGesture);
        when(computer.getGesture()).thenReturn(computerGesture);

        game.findWinner(player, computer);

        assertTrue(logCaptor.getInfoLogs().contains(Result.PLAYER_WINS.getMessage() + playerGesture.getSuccessMessage()));
        verify(player).incrementScore();
        verify(computer, never()).incrementScore();
    }

    @Test
    void testFindWinner_ComputerWins() {
        IGesture playerGesture = GestureFactory.createPlayerGesture(3);
        IGesture computerGesture = GestureFactory.createPlayerGesture(1);
        when(player.getGesture()).thenReturn(playerGesture);
        when(computer.getGesture()).thenReturn(computerGesture);

        game.findWinner(player, computer);

        assertTrue(logCaptor.getInfoLogs().contains(Result.COMPUTER_WINS.getMessage() + computerGesture.getSuccessMessage()));
        verify(computer).incrementScore();
        verify(player, never()).incrementScore();
    }

    @Test
    void testCalculateFinalScore_ComputerWins() {
        when(player.getScore()).thenReturn(1);
        when(computer.getScore()).thenReturn(3);
        game.setRoundsPlayed(5);
        game.calculateFinalScore();
        assertTrue(logCaptor.getInfoLogs().contains(Result.COMPUTER_WINS.getMessage()));
        assertTrue(logCaptor.getInfoLogs().contains("GAMES PLAYED: 5"));
        assertTrue(logCaptor.getInfoLogs().contains("COMPUTER SCORE: 3"));
        assertTrue(logCaptor.getInfoLogs().contains("PLAYER SCORE: 1"));
        assertTrue(logCaptor.getInfoLogs().contains("DRAWS: 1"));
    }

    @Test
    void testCalculateFinalScore_PlayerWins() {
        when(player.getScore()).thenReturn(3);
        when(computer.getScore()).thenReturn(1);
        game.setRoundsPlayed(5);
        game.calculateFinalScore();
        assertTrue(logCaptor.getInfoLogs().contains(Result.PLAYER_WINS.getMessage()));
        assertTrue(logCaptor.getInfoLogs().contains("GAMES PLAYED: 5"));
        assertTrue(logCaptor.getInfoLogs().contains("COMPUTER SCORE: 1"));
        assertTrue(logCaptor.getInfoLogs().contains("PLAYER SCORE: 3"));
        assertTrue(logCaptor.getInfoLogs().contains("DRAWS: 1"));
    }
}
