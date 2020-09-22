package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import cognizant.tictactoe.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class GameControllerTest {

    @Mock
    private GameService mockGameService;

    @InjectMocks
    private GameController gameControllerUnderTest;


    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void whenGameIsAgainstComputer() {
        // setup

        final Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        final Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}});

        final Game expected = new Game(Arrays.asList(player1, player2), lastPlayer, board, "stateOfPlay", "typeOfGame", "winnerPlayer", " ");

        when(mockGameService.setUpPlayersHumanComputer(any(Game.class))).thenReturn(expected);
        when(mockGameService.setUpBoard(any(Game.class))).thenReturn(expected);
        when(mockGameService.setUpGame(any(Game.class))).thenReturn(expected);

        // implement the test
        final ResponseEntity<Game> result = gameControllerUnderTest.buildHumanComputerGame();

        // verify the results
        Assertions.assertEquals(result.getBody().getPlayerList(), expected.getPlayerList());
    }
}
