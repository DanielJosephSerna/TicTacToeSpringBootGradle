package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {

    GameService gameService;

    @BeforeEach
    public void setup() {
        gameService = new GameService();
    }

    @Test
    void getGame_setUpHumanComputerGameModel() {
        // arrange
        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}});

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.HUMAN_VS_COMPUTER, GameConst.EMPTY, GameConst.EMPTY);

        // act

        // assert
        assertEquals(expected, gameService.setUpHumanComputerGame());
    }

    @Test
    void getGame_setUpComputerHumanGameModel() {

        final Player player1 = new Player(PlayerConst.COMPUTER, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.HUMAN1, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.HUMAN1, PlayerConst.O);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}});

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.COMPUTER_VS_HUMAN, GameConst.EMPTY, GameConst.EMPTY);

        // act

        // assert
        assertEquals(expected, gameService.setUpComputerHumanGame());
    }

    @Test
    void getGame_setUpHumanHumanGameModel() {

        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.HUMAN2, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.HUMAN2, PlayerConst.O);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}});

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.HUMAN_VS_HUMAN, GameConst.EMPTY, GameConst.EMPTY);

        // act

        // assert
        assertEquals(expected, gameService.setUpHumanHumanGame());
    }
}
