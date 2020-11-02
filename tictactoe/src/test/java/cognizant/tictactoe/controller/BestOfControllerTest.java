package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.BestOf;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import cognizant.tictactoe.service.BestOfService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BestOfControllerTest {

    BestOfController controller;
    BestOfService service;

    @BeforeEach
    public void setUp() {
        service = Mockito.mock(BestOfService.class);
        controller = new BestOfController(service);
    }

    @Test
    void bestOf_CallsController_ExpectHumanHumanSetUp() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        BestOf expected = new BestOf(setUp, 1, 0, 0);

        when(service.setUpHumanHumanGame()).thenReturn(expected);

        // act
        BestOf actual = controller.setUpHumanHumanGame().getBody();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void bestOf_CallsController_ExpectHumanCompSetUp() {
        // arrange
        People playerZero = new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerZero), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        BestOf expected = new BestOf(setUp, 1, 0, 0);

        when(service.setUpHumanCompGame()).thenReturn(expected);

        // act
        BestOf actual = controller.setUpHumanCompGame().getBody();

        // assert
        assertEquals(expected, actual);
    }
}
