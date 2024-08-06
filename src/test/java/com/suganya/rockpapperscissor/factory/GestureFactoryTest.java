package com.suganya.rockpapperscissor.factory;

import com.suganya.rockpaperscissor.factory.GestureFactory;
import com.suganya.rockpaperscissor.model.IGesture;
import com.suganya.rockpaperscissor.model.Paper;
import com.suganya.rockpaperscissor.model.Rock;
import com.suganya.rockpaperscissor.model.Scissor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for GestureFactory
 */
public class GestureFactoryTest {

    @Test
    void validatePlayerGestureForInput() {
        IGesture rock = GestureFactory.createPlayerGesture(1);
        assertTrue(rock instanceof Rock);

        IGesture paper = GestureFactory.createPlayerGesture(2);
        assertTrue(paper instanceof Paper);

        IGesture scissor = GestureFactory.createPlayerGesture(3);
        assertTrue(scissor instanceof Scissor);

    }

    @Test
    void validatePlayerGestureForInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            GestureFactory.createPlayerGesture(6);
        });
    }

    @Test
    void validateComputerGestures() {
        IGesture computerGesture = GestureFactory.generateComputerGesture();
        assertNotNull(computerGesture);
        assertTrue(computerGesture instanceof Rock || computerGesture instanceof Paper || computerGesture instanceof Scissor);
    }

}
