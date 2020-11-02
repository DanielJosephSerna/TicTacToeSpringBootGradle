package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import cognizant.tictactoe.service.SetUpService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SetUpControllerTest {

    SetUpController controller;
    SetUpService service;

    @BeforeEach
    public void setUp() {
        service = Mockito.mock(SetUpService.class);
        controller = new SetUpController(service);
    }

    @Test
    void setUpHumanCompGame_ReturnsSetUpResponseEntity() {
        // arrange
        People playerZero = new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOne, playerZero), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        when(service.setUpHumanCompGame()).thenReturn(expected);

        // act
        SetUp actual = controller.setUpHumanCompGame().getBody();

        // assert
        Mockito.verify(service).setUpHumanCompGame();

        assertEquals(expected, actual);
    }

    @Test
    void setUpHumanHumanGame_ReturnsSetUpResponseEntity() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOne, playerTwo), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        when(service.setUpHumanHumanGame()).thenReturn(expected);

        // act
        SetUp actual = controller.setUpHumanHumanGame().getBody();

        // assert
        Mockito.verify(service).setUpHumanHumanGame();

        assertEquals(expected, actual);
    }
}
