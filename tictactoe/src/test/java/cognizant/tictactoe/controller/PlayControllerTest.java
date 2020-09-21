package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import cognizant.tictactoe.service.PlayService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PlayControllerTest {

    @Mock
    private PlayService mockPlayService;

    @InjectMocks
    private PlayController playControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testPlayMove() {
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

        when(mockPlayService.makeHumanVsComputerMove(any(Game.class))).thenReturn(new Game());

        // Run the test
        final ResponseEntity<Game> result = playControllerUnderTest.playMove(expected);

        // Verify the results
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
    }
}
