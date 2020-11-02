package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.BestOf;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestOfServiceTest {

    BestOfService service;

    @BeforeEach
    public void setUp() { service = new BestOfService(); }

    @Test
    void bestOf_HumanHumanSetUp() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        BestOf expected = new BestOf(setUp, 1, 0, 0, "ONGOING");
        // act

        // assert
        assertEquals(expected, service.setUpHumanHumanGame());
    }

    @Test
    void bestOf_HumanCompSetUp() {
        // arrange
        People playerZero = new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerZero), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        BestOf expected = new BestOf(setUp, 1, 0, 0, "ONGOING");
        // act

        // assert
        assertEquals(expected, service.setUpHumanCompGame());
    }

    @Test
    void performBestOf_ReturnStatement() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{'O', 'X', 'X'},{'X', 'X', 'O'},{'O', 'O', 'X'}}, 8);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "RETURN", 9, new Integer[]{0, 0, 0});
        BestOf param = new BestOf(setUp, 1, 0, 0, "ONGOING");

        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'X', 'X'},{'X', 'X', 'O'},{'O', 'O', 'X'}}, 8);
        SetUp setUpExpected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "RETURN", 9, new Integer[]{0, 0, 0});
        BestOf expected = new BestOf(setUpExpected, 1, 0, 0, "ONGOING");

        // act

        // assert
        assertEquals(expected, service.performBestOf(param));
    }

    @Test
    void performBestOf_Tie_HumanHuman() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{'O', 'X', 'X'},{'X', 'X', 'O'},{'O', 'O', 'X'}}, 8);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "TIE", 9, new Integer[]{0, 0, 0});
        BestOf param = new BestOf(setUp, 1, 0, 0, "ONGOING");

        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUpExpected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 0, new Integer[]{0, 0, 0});
        BestOf expected = new BestOf(setUpExpected, 1, 0, 0, "ONGOING");

        // act

        // assert
        assertEquals(expected, service.performBestOf(param));
    }

    @Test
    void performBestOf_Tie_HumanComp() {
        // arrange
        People playerZero = new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{'O', 'X', 'X'},{'X', 'X', 'O'},{'O', 'O', 'X'}}, 8);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerZero), board, "TIE", 9, new Integer[]{0, 0, 0});
        BestOf param = new BestOf(setUp, 1, 0, 0, "ONGOING");

        People playerZeroExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUpExpected = new SetUp(Arrays.asList(playerOneExpected, playerZeroExpected), boardExpected, "ONGOING", 0, new Integer[]{0, 0, 0});
        BestOf expected = new BestOf(setUpExpected, 1, 0, 0, "ONGOING");

        // act

        // assert
        assertEquals(expected, service.performBestOf(param));
    }

    @Test
    void performBestOf_Over_ReturnsOngoing_HumanHuman() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "OVER", 5, new Integer[]{0, 1, 2});
        BestOf param = new BestOf(setUp, 3, 0, 0, "ONGOING");

        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUpExpected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 0, new Integer[]{0, 0, 0});
        BestOf expected = new BestOf(setUpExpected, 3, 1, 0, "ONGOING");

        // act

        // assert
        assertEquals(expected, service.performBestOf(param));
    }

    @Test
    void performBestOf_Over_ReturnsOngoing_HumanComp() {
        // arrange
        People playerTwo = new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{'X', 'X', ' '},{'O', 'O', 'O'},{'X', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "OVER", 6, new Integer[]{3, 4, 5});
        BestOf param = new BestOf(setUp, 3, 0, 0, "ONGOING");

        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUpExpected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 0, new Integer[]{0, 0, 0});
        BestOf expected = new BestOf(setUpExpected, 3, 0, 1, "ONGOING");

        // act

        // assert
        assertEquals(expected, service.performBestOf(param));
    }

    @Test
    void performBestOf_Final_HumanHuman_WinnerPlayerOne() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "OVER", 5, new Integer[]{0, 1, 2});
        BestOf param = new BestOf(setUp, 3, 1, 0, "ONGOING");

        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp setUpExpected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 1, 2});
        BestOf expected = new BestOf(setUpExpected, 3, 2, 0, "FINAL");

        // act

        // assert
        assertEquals(expected, service.performBestOf(param));
    }

    @Test
    void performBestOf_Final_HumanHuman_WinnerPlayerTwo() {
        // arrange
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{'X', 'X', ' '},{'O', 'O', 'O'},{'X', ' ', ' '}}, 5);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "OVER", 6, new Integer[]{3, 4, 5});
        BestOf param = new BestOf(setUp, 1, 0, 0, "ONGOING");

        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'X', ' '},{'O', 'O', 'O'},{'X', ' ', ' '}}, 5);
        SetUp setUpExpected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 6, new Integer[]{3, 4, 5});
        BestOf expected = new BestOf(setUpExpected, 1, 0, 1, "FINAL");

        // act

        // assert
        assertEquals(expected, service.performBestOf(param));
    }
}
