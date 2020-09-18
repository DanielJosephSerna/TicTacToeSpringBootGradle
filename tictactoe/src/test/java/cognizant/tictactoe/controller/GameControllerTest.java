package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.Player;
import cognizant.tictactoe.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

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
    void whenGameIsAgainstComputer_AndHumanStarts() {
        // setup - players, board, then game
        Player player1 = new Player();
        player1.setType(PlayerConst.HUMAN);
        player1.setPiece(PlayerConst.X);
        Player player2 = new Player();
        player1.setType(PlayerConst.COMPUTER);
        player1.setPiece(PlayerConst.O);
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);

        char [] boardArr = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        int moveCount = 0;
        Board board = new Board();
        board.setBoardArr(boardArr);
        board.setMoveCount(moveCount);

        String stateOfPlay = GameConst.ONGOING;
        String typeOfGame = GameConst.HUMAN_VS_COMPUTER;
        Game game = new Game(playerList, board, stateOfPlay, typeOfGame);

        when(mockGameService.buildGameHumanComputer()).thenReturn(game);

        // implement the test
        ResponseEntity<Game> gameResponseEntity = gameControllerUnderTest.buildGame();

        // verify the results
        Assertions.assertEquals(game, gameResponseEntity.getBody());
    }
}
