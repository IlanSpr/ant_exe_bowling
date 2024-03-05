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
    @DisplayName("Score given gutter game should be 0")
    void Score_GivenGutterGame_ShouldBe0() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    @DisplayName("Score given all ones should be 20")
    void Score_GivenAllOnes_ShouldBe20() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    @DisplayName("Score given one spare should be 16")
    void Score_GivenOneSpare_ShouldBe16() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    @DisplayName("Score given one strike should be 24")
    void Score_GivenOneStrike_ShouldBeTwentyFour() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    @DisplayName("Score given perfect game should be 300")
    void Score_GivenPerfectGame_ShouldBe360() {
        rollMany(12, 10);
        assertEquals(360, game.score());
    }

    @Test
    @DisplayName("Score given extra roll for spare in tenth frame should be 15")
    void Score_GivenExtraRollForSpareInTenthFrame_ShouldBeTwenty() {
        rollMany(18, 0);
        rollSpare();
        game.roll(5);
        assertEquals(15, game.score());
    }

    @Test
    @DisplayName("Score given extra roll for strike in tenth frame should be 20")
    void Score_GivenExtraRollForStrikeInTenthFrame_ShouldBeTwenty() {
        rollMany(18, 0);
        rollStrike();
        game.roll(3);
        game.roll(4);
        assertEquals(17, game.score());
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
