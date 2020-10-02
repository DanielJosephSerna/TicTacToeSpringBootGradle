package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import cognizant.tictactoe.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GameControllerTest {

    GameController gameController;
    GameService gameService;

    @BeforeEach
    public void setup() {
        gameService = Mockito.mock(GameService.class);
        gameController = new GameController(gameService);
    }

    @Test
    void getGame_setUpHumanComputerGameModel() {
        // arrange
        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O);

        Board board = new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "});

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.COMPUTER_VS_HUMAN, GameConst.EMPTY, GameConst.EMPTY);

        when(gameService.setUpHumanComputerGame()).thenReturn(expected);

        // act
        Game actual = gameController.buildHumanComputerGame().getBody();

        // assert
        Mockito.verify(gameService).setUpHumanComputerGame();

        assertEquals(expected, actual);
    }

    @Test
    void getGame_setUpComputerHumanGameModel() {
        // arrange
        final Player player1 = new Player(PlayerConst.COMPUTER, PlayerConst.X, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.HUMAN1, PlayerConst.O, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.HUMAN1, PlayerConst.O);

        Board board = new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "});

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.COMPUTER_VS_HUMAN, GameConst.EMPTY, GameConst.EMPTY);

        when(gameService.setUpComputerHumanGame()).thenReturn(expected);

        // act
        Game actual = gameController.buildComputerHumanGame().getBody();

        // assert
        Mockito.verify(gameService).setUpComputerHumanGame();

        assertEquals(expected, actual);
    }

    @Test
    void getGame_setUpHumanHumanGameModel() {
        // arrange
        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.HUMAN2, PlayerConst.O, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.HUMAN2, PlayerConst.O);

        Board board = new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "});

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.HUMAN_VS_HUMAN, GameConst.EMPTY, GameConst.EMPTY);

        when(gameService.setUpComputerHumanGame()).thenReturn(expected);

        // act
        Game actual = gameController.buildComputerHumanGame().getBody();

        // assert
        Mockito.verify(gameService).setUpComputerHumanGame();

        assertEquals(expected, actual);
    }
}
