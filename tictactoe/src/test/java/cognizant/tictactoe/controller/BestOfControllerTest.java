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

        BestOf expected = new BestOf(setUp, 1, 0, 0, "ONGOING");

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

        BestOf expected = new BestOf(setUp, 1, 0, 0, "ONGOING");

        when(service.setUpHumanCompGame()).thenReturn(expected);

        // act
        BestOf actual = controller.setUpHumanCompGame().getBody();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void bestOf_PerformCheckForHumanHuman_isOverReturnsOngoing() {
        // arrange
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'X', 'X'},{'X', 'X', 'O'},{'O', 'O', 'X'}}, 8);
        SetUp setUpOne = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "TIE", 9, new Integer[]{0, 0, 0});
        BestOf param = new BestOf(setUpOne, 1, 0, 0, "ONGOING");

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUpTwo = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 0, new Integer[]{0, 0, 0});
        BestOf expected = new BestOf(setUpTwo, 1, 0 , 0, "ONGOING");

        when(service.performBestOf(param)).thenReturn(expected);

        // act
        BestOf actual = controller.performBestOf(param).getBody();

        // assert
        Mockito.verify(service).performBestOf(param);

        assertEquals(expected, actual);
    }

    @Test
    void bestOf_PerformCheckForHumanComp_isOverReturnsOngoing() {
        // arrange
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'X', 'X'},{'X', 'X', 'O'},{'O', 'O', 'X'}}, 8);
        SetUp setUpOne = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "TIE", 0, new Integer[]{0, 0, 0});
        BestOf param = new BestOf(setUpOne, 1, 0, 0, "ONGOING");

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUpTwo = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 1, new Integer[]{0, 0, 0});
        BestOf expected = new BestOf(setUpTwo, 1, 0 , 0, "ONGOING");

        when(service.performBestOf(param)).thenReturn(expected);

        // act
        BestOf actual = controller.performBestOf(param).getBody();

        // assert
        Mockito.verify(service).performBestOf(param);

        assertEquals(expected, actual);
    }

    @Test
    void bestOf_PlayerOneWins_isOverReturnsFinal() {
        // arrange
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{' ', 'O', 'O'},{' ', ' ', ' '}}, 2);
        SetUp setUpOne = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "OVER", 5, new Integer[]{0, 1, 2});
        BestOf param = new BestOf(setUpOne, 1, 0, 0, "ONGOING");

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{' ', 'O', 'O'},{' ', ' ', ' '}}, 2);
        SetUp setUpTwo = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 1, 2});
        BestOf expected = new BestOf(setUpTwo, 1, 1 , 0, "ONGOING");

        when(service.performBestOf(param)).thenReturn(expected);

        // act
        BestOf actual = controller.performBestOf(param).getBody();

        // assert
        Mockito.verify(service).performBestOf(param);

        assertEquals(expected, actual);
    }

    @Test
    void bestOf_PlayerTwoWins_isOverReturnsFinal() {
        // arrange
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'O', 'O'},{'X', 'O', 'X'},{'X', ' ', 'X'}}, 8);
        SetUp setUpOne = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "OVER", 8, new Integer[]{0, 1, 2});
        BestOf param = new BestOf(setUpOne, 1, 0, 0, "ONGOING");

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'O', 'O'},{'X', 'O', 'X'},{'X', ' ', 'X'}}, 8);
        SetUp setUpTwo = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 8, new Integer[]{0, 1, 2});
        BestOf expected = new BestOf(setUpTwo, 1, 0 , 1, "FINAL");

        when(service.performBestOf(param)).thenReturn(expected);

        // act
        BestOf actual = controller.performBestOf(param).getBody();

        // assert
        Mockito.verify(service).performBestOf(param);

        assertEquals(expected, actual);
    }
}
