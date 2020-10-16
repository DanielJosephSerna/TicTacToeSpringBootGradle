package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
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
    void getPlay_performHumanAndComputerMoveOnTheBoard() {
        // arrange
        final Game expected = new Game(
                Arrays.asList(new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final ResponseEntity<Game> expectedResponse = new ResponseEntity<>(new Game(
                Arrays.asList(new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0}), HttpStatus.OK);

        final Game expected2 = new Game(Arrays.asList(new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        when(playService.performHumanAndComputerMove(new Game(Arrays.asList(new Player("HUMAN1", "X", 0), new Player("COMPUTER", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0}))).thenReturn(expected2);

        // act
        final ResponseEntity<Game> result = playController.performHumanAndComputerMove(expected);

        // assert
        assertEquals(expectedResponse, result);
    }

    @Test
    void getPlay_performHumanAndHumanMoveOnTheBoard() {
        // arrange
        final Game parameter = new Game(
                Arrays.asList(new Player("HUMAN1", "X", 0), new Player("HUMAN2", "O", 0)),
                new Board(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final Game serviceReturn = new Game(
                Arrays.asList(new Player("HUMAN1", "X", 0), new Player("HUMAN2", "O", 0)),
                new Board(new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0});

        final ResponseEntity<Game> expectedResponse = new ResponseEntity<>(new Game(
                Arrays.asList(new Player("HUMAN1", "X", 0), new Player("HUMAN2", "O", 0)),
                new Board(new String[]{"X", " ", " ", " ", " ", " ", " ", " ", " "}), "ONGOING", new Integer[]{0, 0, 0}), HttpStatus.OK);

        when(playService.performHumanAndHumanMove(parameter)).thenReturn(serviceReturn);

        // act
        final ResponseEntity<Game> result = playController.performHumanAndHumanMove(parameter);

        // assert
        assertEquals(expectedResponse, result);
    }
}
