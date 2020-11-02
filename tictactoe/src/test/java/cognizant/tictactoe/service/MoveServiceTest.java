package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveServiceTest {

    MoveService service;

    @BeforeEach
    public void setUp() { service = new MoveService(); }

    @Test
    void move_PerformFirstMove_ExpectCountMovesIncrementedAndOnePieceOnBoard() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 0, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 1, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformSecondMove_ExpectCountMovesIncrementedAndTwoPieceOnBoard() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 1);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 1, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 1);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 2, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformSecondMove_ComputerMove_ExpectPlacementInCenterOfBoard() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 1, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{' ', 'O', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 2, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformSecondMove_ComputerMove_ExpectPlacementInTopLeftOfBoard() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'X', ' '},{' ', ' ', ' '}}, 4);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 1, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{' ', 'X', ' '},{' ', ' ', ' '}}, 4);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 2, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformThirdMove_ExpectCountMovesIncrementedAndThreePieceOnBoard() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'O', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 3);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 2, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', ' '},{'X', ' ', ' '},{' ', ' ', ' '}}, 3);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 3, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformFifthMove_ExpectOngoingStatus() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'O', 'O'},{'X', ' ', ' '},{' ', ' ', ' '}}, 7);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 4, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', 'O'},{'X', ' ', ' '},{' ', 'X', ' '}}, 7);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 5, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformSixthMove_ExpectOngoingStatus() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'O', ' '},{'X', 'O', ' '},{' ', 'X', ' '}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 5, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', ' '},{'X', 'O', ' '},{' ', 'X', 'O'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 6, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformSixthMove_WithComputer_ExpectOngoingStatus() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'O', ' '},{'X', 'O', ' '},{' ', 'X', ' '}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 5, new Integer[]{0, 0, 0});

/*
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', ' '},{'X', 'O', ' '},{' ', 'X', 'O'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 6, new Integer[]{0, 0, 0});
*/

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(param, actual);
        assertEquals(param.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformFifthMove_ExpectOverStatus() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'O', 'O'},{'X', ' ', ' '},{' ', ' ', ' '}}, 6);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 4, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', 'O'},{'X', ' ', ' '},{'X', ' ', ' '}}, 6);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 3, 6});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformFifthMove_ExpectOverStatus_HorizontalWin() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'X', ' '},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 4, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 1, 2});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformFifthMove_ExpectOverStatus_DiagonalWinFirstCondition() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{'O', 'X', 'O'},{' ', ' ', ' '}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 4, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{'O', 'X', 'O'},{' ', ' ', 'X'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 4, 8});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformFifthMove_ExpectOverStatus_DiagonalWinSecondCondition() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{'O', 'X', ' '},{' ', ' ', ' '}}, 6);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 4, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{'O', 'X', ' '},{'X', ' ', ' '}}, 6);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{2, 4, 6});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformEigthMove_ExpectOngoingStatus_CheckTie() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {' ', 'X', ' '}}, 6);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 7, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', ' '}}, 6);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 8, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_PerformNinthMove_ExpectTieStatus_CheckTie() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', ' '}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 8, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', 'X'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "TIE", 9, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_checkVerticalWin() {
        Character temp = 'X';

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', 'O'},{'X', ' ', ' '},{'X', ' ', ' '}}, 6);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 3, 6});

        // arrange
        SetUp actual = service.checkVerticalWin(expected, temp);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_checkHorizontalWin() {
        // act
        Character temp = 'X';

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'X', 'X'},{'O', 'O', ' '},{' ', ' ', ' '}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 1, 2});

        // arrange
        SetUp actual = service.checkHorizontalWin(expected, temp);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_checkDiagonalConditionOne() {
        // act
        Character temp = 'X';
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{'O', 'X', 'O'},{' ', ' ', 'X'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{0, 4, 8});

        // arrange
        SetUp actual = service.checkDiagonalWinConditionOne(expected, temp);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_checkDiagonalConditionTwo() {
        // act
        Character temp = 'X';
        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{'O', 'X', ' '},{'X', ' ', ' '}}, 6);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "OVER", 5, new Integer[]{2, 4, 6});

        // arrange
        SetUp actual = service.checkDiagonalWinConditionOne(expected, temp);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_checkTie_ReturnsOngoing() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', ' '}}, 7);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 8, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', ' '}}, 7);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 8, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.checkTie(expected);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    void move_checkTie_ReturnsTie() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', 'X'}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 9, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', 'X'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "TIE", 9, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.checkTie(expected);

        // assert
        assertEquals(expected, actual);
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    /*******************************************************************************/

    @Test
    void move_PerformComputerFourthMove_ScenarioZero() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{' ', 'X', ' '},{'X', ' ', ' '}}, 4);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', 'O'},{' ', 'X', ' '},{'X', ' ', ' '}}, 4);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

/*    @Test
    void move_PerformComputerFourthMove_ScenarioOne() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{' ', ' ', ' '},{'X', ' ', ' '}}, 2);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{' ', 'O', ' '},{'X', ' ', ' '}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }*/

    @Test
    void move_PerformComputerFourthMove_ScenarioTwo() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{' ', 'X', ' '},{' ', ' ', ' '}}, 2);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{' ', 'X', ' '},{'O', ' ', ' '}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

/*    @Test
    void move_PerformComputerFourthMove_ScenarioThree() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', 'O'},{' ', 'X', ' '},{' ', ' ', ' '}}, 4);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', 'O'},{' ', 'X', ' '},{' ', ' ', 'O'}}, 4);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }*/

/*    @Test
    void move_PerformComputerFourthMove_ScenarioFour() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', 'O'},{' ', ' ', ' '},{' ', ' ', 'X'}}, 2);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', 'O'},{' ', 'O', ' '},{' ', ' ', 'X'}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }*/

/*    @Test
    void move_PerformComputerFourthMove_ScenarioFive() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', 'O'},{' ', 'X', ' '},{' ', ' ', 'X'}}, 4);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', 'O'},{' ', 'X', ' '},{' ', ' ', 'X'}}, 4);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }*/

    @Test
    void move_PerformComputerFourthMove_ScenarioSix() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'O', 'X'},{' ', ' ', 'X'}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', 'O'},{' ', 'O', 'X'},{' ', ' ', 'X'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioSeven() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', 'X'},{' ', 'O', ' '},{' ', ' ', 'X'}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', 'X'},{' ', 'O', 'O'},{' ', ' ', 'X'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioEight() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', 'X'},{' ', 'O', 'X'},{' ', ' ', ' '}}, 2);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', 'X'},{' ', 'O', 'X'},{' ', ' ', 'O'}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioNine() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'X', ' '},{' ', 'X', ' '},{' ', ' ', ' '}}, 1);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'X', ' '},{' ', 'X', ' '},{' ', 'O', ' '}}, 1);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

/*    @Test
    void move_PerformComputerFourthMove_ScenarioTen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', 'X', ' '},{' ', ' ', ' '},{' ', 'X', ' '}}, 1);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'X', ' '},{' ', 'O', ' '},{' ', 'X', ' '}}, 1);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }*/

    @Test
    void move_PerformComputerFourthMove_ScenarioEleven() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{' ', 'X', ' '},{' ', 'X', ' '}}, 4);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'O', ' '},{' ', 'X', ' '},{' ', 'X', ' '}}, 4);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioTwelve() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{'X', 'O', ' '},{' ', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{'X', 'O', ' '},{'O', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioThirteen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{' ', 'O', ' '},{'X', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', ' ', ' '},{'O', 'O', ' '},{'X', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioFourteen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{'X', 'O', ' '},{'X', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{'X', 'O', ' '},{'X', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioFifthteen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'O', ' '},{'X', 'X', ' '}}, 6);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'O', ' '},{'X', 'X', 'O'}}, 6);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioSixteen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'O', ' '},{'X', ' ', 'X'}}, 6);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'O', ' '},{'X', 'O', 'X'}}, 6);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioSeventeen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'O', ' '},{' ', 'X', 'X'}}, 8);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', 'O', ' '},{'O', 'X', 'X'}}, 8);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioEightteen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{'X', 'X', ' '},{' ', ' ', ' '}}, 3);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{'X', 'X', 'O'},{' ', ' ', ' '}}, 3);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

/*    @Test
    void move_PerformComputerFourthMove_ScenarioNineteen() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{'X', ' ', 'X'},{' ', ' ', ' '}}, 3);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{'X', 'O', 'X'},{' ', ' ', ' '}}, 3);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }*/

    @Test
    void move_PerformComputerFourthMove_ScenarioTwenty() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{' ', 'X', 'X'},{' ', ' ', ' '}}, 4);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', ' '},{'O', 'X', 'X'},{' ', ' ', ' '}}, 4);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioTwentyOne() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', 'X', ' '},{' ', 'O', ' '},{' ', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'X', 'O'},{' ', 'O', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioTwentyTwo() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{'X', ' ', 'X'},{' ', 'O', ' '},{' ', ' ', ' '}}, 0);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'X', 'O', 'X'},{' ', 'O', ' '},{' ', ' ', ' '}}, 0);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioTwentyThree() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', 'X', 'X'},{' ', 'O', ' '},{' ', ' ', ' '}}, 1);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', 'X', 'X'},{' ', 'O', ' '},{' ', ' ', ' '}}, 1);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void move_PerformComputerFourthMove_ScenarioTwentyFour() {
        // act
        People playerOneParam = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoParam = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardParam = new TicTacToeBoard(new Character[][]{{' ', ' ', 'X'},{' ', 'O', ' '},{'X', ' ', ' '}}, 2);
        SetUp param = new SetUp(Arrays.asList(playerOneParam, playerTwoParam), boardParam, "ONGOING", 3, new Integer[]{0, 0, 0});

        People playerOneExpected = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwoExpected = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard boardExpected = new TicTacToeBoard(new Character[][]{{'O', ' ', 'X'},{' ', 'O', ' '},{'X', ' ', ' '}}, 2);
        SetUp expected = new SetUp(Arrays.asList(playerOneExpected, playerTwoExpected), boardExpected, "ONGOING", 4, new Integer[]{0, 0, 0});

        // arrange
        SetUp actual = service.performMove(param);

        // assert
        assertEquals(expected, actual);
    }
}
