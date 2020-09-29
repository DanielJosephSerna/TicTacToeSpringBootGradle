package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import cognizant.tictactoe.service.PlayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PlayControllerTest {

    PlayController playController;
    PlayService playService;

    @BeforeEach
    public void setup() {
        playService = Mockito.mock(PlayService.class);
        playController = new PlayController(playService);
    }

    @Test
    void getPlay_performAMoveOnTheBoard() {
        // arrange
        final Game expected = new Game(
                Arrays.asList(new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        final ResponseEntity<Game> expectedResponse = new ResponseEntity<>(new Game(
                Arrays.asList(new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " "), HttpStatus.OK);

        final Game expected2 = new Game(Arrays.asList(new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " ");

        when(playService.performHumanAndComputerMove(new Game(Arrays.asList(new Player("HUMAN1", "X", 0, 0), new Player("COMPUTER", "O", 0, 0)),
                new LastPlayer("COMPUTER", "O"),
                new Board(new String[][]{{" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "},
                        {"-", "+", "-", "+", "-"},
                        {" ", "|", " ", "|", " "}}), "ONGOING", "HUMAN VS COMPUTER", " ", " "))).thenReturn(expected2);

        // act
        final ResponseEntity<Game> result = playController.performHumanAndComputerMove(expected);

        // assert
        assertEquals(expectedResponse, result);
    }
}
