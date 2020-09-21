package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class PlayServiceTest {

    private PlayService playServiceUnderTest;

    @BeforeEach
    void setUp() {
        playServiceUnderTest = new PlayService();
    }

    @Test
    void testMakeHumanMove() {
        // Setup
        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.HUMAN_COMPUTER);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}}, false);

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, "stateOfPlay", "typeOfGame", "winnerPlayer", " ");

        // Run the test
        final Game result = playServiceUnderTest.makeHumanMove(expected);
        System.out.println(expected);
        System.out.println(result);
        System.out.println("PAUSE");
        // Verify the results
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMakeComputerMove() {
        // Setup
        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.HUMAN_COMPUTER);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}}, false);

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, "stateOfPlay", "typeOfGame", "winnerPlayer", " ");

        // Run the test
        final Game result = playServiceUnderTest.makeComputerMove(expected);

        // Verify the results
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckWin() {
        // Setup
        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.HUMAN_COMPUTER);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}}, false);

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, "stateOfPlay", "typeOfGame", "winnerPlayer", " ");

        // Run the test
        final Game result = playServiceUnderTest.checkWin(expected);

        // Verify the results
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckTie() {
        // Setup
        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.HUMAN_COMPUTER);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}}, false);

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, "stateOfPlay", "typeOfGame", "winnerPlayer", " ");


        // Run the test
        final Game result = playServiceUnderTest.checkTie(expected);

        // Verify the results
        Assertions.assertEquals(expected, result);
    }
}
