package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PlayServiceTest {

    private PlayService playServiceUnderTest;

    @BeforeEach
    void setUp() {
        playServiceUnderTest = new PlayService();
        playServiceUnderTest.tempBoard = new String[][]{{"value"}};
        playServiceUnderTest.tempPlayer = mock(Player.class);
    }

    @Test
    void testComputerMove() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Player tempPlayer = new Player("HUMAN1", "X", 0, 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final Game result = playServiceUnderTest.computerMove(game, tempPlayer);

        // Verify the results
        assertEquals(expectedResult.getLastPlayer().getLastPlayer(), result.getLastPlayer().getLastPlayer());
    }

    @Test
    void testPerformComputerMove() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final Game result = playServiceUnderTest.performComputerMove(game);

        // Verify the results
        assertEquals(expectedResult.getLastPlayer().getLastPlayer(), result.getLastPlayer().getLastPlayer());
    }

    @Test
    void testPerformPlayerSwitch() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Player tempPlayer = new Player("HUMAN1", "X", 0, 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final Game result = playServiceUnderTest.performPlayerSwitch(game, tempPlayer);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testPerformGameEnd() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Player tempPlayer = new Player("HUMAN1", "X", 0, 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final Game result = playServiceUnderTest.performGameEnd(game, tempPlayer);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testHumanMove() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Player tempPlayer = new Player("HUMAN1", "X", 0, 0);

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final Game result = playServiceUnderTest.humanMove(game, tempPlayer);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetPlayerDetails() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Player expectedResult = new Player("HUMAN1", "X", 0, 0);

        // Run the test
        final Player result = playServiceUnderTest.getPlayerDetails(game);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testPerformHumanMove() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final Game result = playServiceUnderTest.performHumanMove(game);

        // Verify the results
        assertEquals(expectedResult.getLastPlayer().getLastPlayer(), result.getLastPlayer().getLastPlayer());
    }

    @Test
    void testPerformHumanAndComputerMove() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{"X", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final Game result = playServiceUnderTest.performHumanAndComputerMove(game);

        // Verify the results
        assertEquals(expectedResult.getLastPlayer().getLastPlayer(), result.getLastPlayer().getLastPlayer());
    }

    @Test
    void checkHorizontalWin_ReturnTrue() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", "X", "|", "X"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", "O"}}), "OVER", "HUMAN VS COMPUTER", "HUMAN1", "X");
        // Run the test
        final boolean result = playServiceUnderTest.checkHorizontalWin(game, "X");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void checkHorizontalWin_ReturnFalse() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");
        // Run the test
        final boolean result = playServiceUnderTest.checkHorizontalWin(game, "X");

        // Verify the results
        assertFalse(result);
    }

    @Test
    void checkVerticalWin_ReturnTrue() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 2), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{" ", "|", "X", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", "X", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", "X", "|", "O"}}), "OVER", "HUMAN VS COMPUTER", "HUMAN1", "X");

        // Run the test
        final boolean result = playServiceUnderTest.checkVerticalWin(game, "X");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void checkVerticalWin_ReturnFalse() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final boolean result = playServiceUnderTest.checkVerticalWin(game, "X");

        // Verify the results
        assertFalse(result);
    }

    @Test
    void checkDiagonalWin_ReturnTrue() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", "X", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", "O", "|", "X"}}), "OVER", "HUMAN VS COMPUTER", "HUMAN1", "X");

        // Run the test
        final boolean result = playServiceUnderTest.checkDiagonalWin(game, "X");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void checkDiagonalWin_ReturnFalse() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final boolean result = playServiceUnderTest.checkDiagonalWin(game, "X");

        // Verify the results
        assertFalse(result);
    }

    @Test
    void checkTie_ReturnTrue() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", "O", "|", "O"},
                        {"-", "+", "-", "+", "-"},
                        {"O", "|", "X", "|", "X"},
                        {"-", "+", "-", "+", "-"},
                        {"X", "|", "X", "|", "O"}}), "TIE", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final boolean result = playServiceUnderTest.checkTie(game);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void checkTie_ReturnFalse() {
        // Setup
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[][]{{"X", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        // Run the test
        final boolean result = playServiceUnderTest.checkTie(game);

        // Verify the results
        assertFalse(result);
    }
}
