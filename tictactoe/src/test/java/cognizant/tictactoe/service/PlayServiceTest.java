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
        playServiceUnderTest.tempPlayer = mock(Player.class);
    }

    @Test
    void testComputerMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Player tempPlayer = new Player("HUMAN1", "X", 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.computerMove(game, tempPlayer);

        // assert
        assertEquals(expectedResult.getLastPlayer().getPreviousPlayer(), result.getLastPlayer().getPreviousPlayer());
    }

    @Test
    void testPerformComputerMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performComputerMove(game);

        // assert
        assertEquals(expectedResult.getLastPlayer().getPreviousPlayer(), result.getLastPlayer().getPreviousPlayer());
    }

    @Test
    void testPerformPlayerSwitch() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Player tempPlayer = new Player("HUMAN1", "X", 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performPlayerSwitch(game, tempPlayer);

        // assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testPerformGameEnd() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Player tempPlayer = new Player("HUMAN1", "X", 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performGameEnd(game, tempPlayer);

        // assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testHumanMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Player tempPlayer = new Player("HUMAN1", "X", 0);

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.humanMove(game, tempPlayer);

        // assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetPlayerDetails() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Player expectedResult = new Player("HUMAN1", "X", 0);

        // arrange
        final Player result = playServiceUnderTest.getPlayerDetails(game);

        // assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testPerformHumanMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performHumanMove(game);

        // assert
        assertEquals(expectedResult.getLastPlayer().getPreviousPlayer(), result.getLastPlayer().getPreviousPlayer());
    }

    @Test
    void testPerformHumanAndComputerMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performHumanAndComputerMove(game);

        // assert
        assertEquals(expectedResult.getLastPlayer().getPreviousPlayer(), result.getLastPlayer().getPreviousPlayer());
    }

    @Test
    void checkHorizontalWin_ReturnTrue() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{"X", "X", "X", "O", "O", " ", " ", " ", " "}), "OVER", "HUMAN VS COMPUTER", "HUMAN1", "X", new Integer[]{0, 0, 0});
        // arrange
        final boolean result = playServiceUnderTest.checkHorizontalWin(game, "X");

        // assert
        assertTrue(result);
    }

    @Test
    void checkHorizontalWin_ReturnFalse() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});
        // arrange
        final boolean result = playServiceUnderTest.checkHorizontalWin(game, "X");

        // assert
        assertFalse(result);
    }

    @Test
    void checkVerticalWin_ReturnTrue() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{"X", "O", " ", "X", "O", " ", "X", " ", " "}), "OVER", "HUMAN VS COMPUTER", "HUMAN1", "X", new Integer[]{0, 0, 0});

        // arrange
        final boolean result = playServiceUnderTest.checkVerticalWin(game, "X");

        // assert
        assertTrue(result);
    }

    @Test
    void checkVerticalWin_ReturnFalse() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final boolean result = playServiceUnderTest.checkVerticalWin(game, "X");

        // assert
        assertFalse(result);
    }

    @Test
    void checkDiagonalWin_ReturnTrue() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{"X", "O", " ", "O", "X", " ", " ", " ", "X"}), "OVER", "HUMAN VS COMPUTER", "HUMAN1", "X", new Integer[]{0, 0, 0});

        // arrange
        final boolean result = playServiceUnderTest.checkDiagonalWin(game, "X");

        // assert
        assertTrue(result);
    }

    @Test
    void checkDiagonalWin_ReturnFalse() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final boolean result = playServiceUnderTest.checkDiagonalWin(game, "X");

        // assert
        assertFalse(result);
    }

    @Test
    void checkTie_ReturnTrue() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{"O", "O", "X", "X", "X", "O", "O", "X", "X"}), "TIE", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final boolean result = playServiceUnderTest.checkTie(game);

        // assert
        assertTrue(result);
    }

    @Test
    void checkTie_ReturnFalse() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new LastPlayer("HUMAN1", "X"),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", "HUMAN VS COMPUTER", " ", " ", new Integer[]{0, 0, 0});

        // arrange
        final boolean result = playServiceUnderTest.checkTie(game);

        // assert
        assertFalse(result);
    }
}
