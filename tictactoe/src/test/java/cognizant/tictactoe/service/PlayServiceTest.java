package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
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
    void testPerformHumanAndHumanMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("HUMAN2", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("HUMAN2", "O", 0)),
                new Board(new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performHumanAndHumanMove(game);

        // assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testComputerMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Player tempPlayer = new Player("HUMAN1", "X", 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.easyComputerMove(game, tempPlayer);

        // assert
        assertEquals(expectedResult.getStatus(), result.getStatus());
    }

    @Test
    void testPerformComputerMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performEasyComputerMove(game);

        // assert
        assertEquals(expectedResult.getStatus(), result.getStatus());
    }

    @Test
    void testPerformGameEnd() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Player tempPlayer = new Player("HUMAN1", "X", 0);
        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

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
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Player tempPlayer = new Player("HUMAN1", "X", 0);

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

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
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

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
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performHumanMove(game);

        // assert
        assertEquals(expectedResult.getStatus(), result.getStatus());
    }

    @Test
    void testPerformHumanAndComputerMove() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Game expectedResult = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        // arrange
        final Game result = playServiceUnderTest.performHumanAndEasyComputerMove(game);

        // assert
        assertEquals(expectedResult.getStatus(), result.getStatus());
    }

    @Test
    void checkHorizontalWin_ReturnTrue() {
        // act
        final Game game = new Game(Arrays.asList(
                new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{"X", "X", "X", "O", "O", " ", " ", " ", " "}), "OVER", new Integer[]{0, 0, 0});
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
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});
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
                new Board(new String[]{"X", "O", " ", "X", "O", " ", "X", " ", " "}), "OVER", new Integer[]{0, 0, 0});

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
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

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
                new Board(new String[]{"X", "O", " ", "O", "X", " ", " ", " ", "X"}), "OVER", new Integer[]{0, 0, 0});

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
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

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
                new Board(new String[]{"O", "O", "X", "X", "X", "O", "O", "X", "X"}), "TIE", new Integer[]{0, 0, 0});

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
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        // arrange
        final boolean result = playServiceUnderTest.checkTie(game);

        // assert
        assertFalse(result);
    }
}
