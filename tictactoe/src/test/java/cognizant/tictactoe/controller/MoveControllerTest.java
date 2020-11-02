package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import cognizant.tictactoe.service.MoveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MoveControllerTest {

    MoveController controller;
    MoveService service;

    @BeforeEach
    public void setUp() {
        service = Mockito.mock(MoveService.class);
        controller = new MoveController(service);
    }

    @Test
    void move_performHumanMove() {
        // arrange
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 0, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 1, new Integer[]{0, 0, 0});

        when(service.performMove(param)).thenReturn(expected);

        // act
        SetUp actual = controller.performMove(param).getBody();

        // assert
        Mockito.verify(service).performMove(param);

        assertEquals(expected, actual);
    }

/*    @Test
    void move_performHumanThenComputerMove() {
        // arrange
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 0, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{' ', 'O', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 2, new Integer[]{0, 0, 0});

        when(service.performMove(param)).thenReturn(expected);

        // act
        SetUp actual = controller.performMove(param).getBody();

        // assert
        Mockito.verify(service).performMove(param);

        assertEquals(null, actual);
    }

    @Test
    void move_performHumanThenEndGame_NoComputerMove() {
        // arrange
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'X', ' '},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 4, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 1, 2});

        when(service.performMove(param)).thenReturn(expected);

        // act
        SetUp actual = controller.performMove(param).getBody();

        // assert
        Mockito.verify(service).performMove(param);

        assertEquals(null, actual);
    }*/

/*    @Test
    void move_performHumanComputerMove() {
        // arrange

        // act

        // assert
    }*/
}
