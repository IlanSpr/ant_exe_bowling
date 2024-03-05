package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    void setUp() {
        game = new BowlingGame();
    }

    @Test
    @DisplayName("Score given 20 rolls of 0 pins should be 0")
    void Score_Given20RollsOf0Pins_ShouldBe0() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    @DisplayName("Score given 20 rolls of 1 pin should be 20")
    void Score_Given20RollsOf1Pin_ShouldBe20() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    @DisplayName("Score given spare (5 + 5), then a roll of 3 pins should be 16")
    void Score_GivenSpareAndRollOf3Pins_ShouldBe16() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    @DisplayName("Score given strike (10), then rolls of 3 and 4 pins should be 24")
    void Score_GivenStrikeAndRollsOf3And4Pins_ShouldBe24() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    @DisplayName("Score given a perfect game (12 rolls of 10 pins) should be 300")
    void Score_GivenPerfectGame_ShouldBe300() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }
}
