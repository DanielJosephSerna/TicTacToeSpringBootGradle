package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    private GameService gameServiceUnderTest;

    @BeforeEach
    void setUp() {
        gameServiceUnderTest = new GameService();
    }

    @Test
    void testSetUpPlayers() {
        // Setup
        final Game expected = new Game();

        // Run the test
        final Game result = gameServiceUnderTest.setUpPlayersHumanComputer(expected);

        // Verify the results
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSetUpBoard() {
        // Setup
        final Game expected = new Game();

        // Run the test
        final Game result = gameServiceUnderTest.setUpBoard(expected);

        // Verify the results
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSetUpGame() {
        // Setup
        final Game expected = new Game();

        // Run the test
        final Game result = gameServiceUnderTest.setUpGame(expected);

        // Verify the results
        Assertions.assertEquals(expected, result);
    }
}
