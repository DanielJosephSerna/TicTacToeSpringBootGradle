package cognizant.tictactoe.service;

import cognizant.tictactoe.model.SetUp;

public interface MoveServiceInterface {

    SetUp performMove(SetUp setUp);


    SetUp placePieceOnBoard(SetUp setUp, int r, int c);

    SetUp computerMove(SetUp setUp);

    SetUp isGameOver(SetUp setUp);

    SetUp checkHorizontalWin(SetUp setUp, Character tempPiece);

    SetUp checkVerticalWin(SetUp setUp, Character tempPiece);

    SetUp checkDiagonalWinConditionOne(SetUp setUp, Character tempPiece);

    SetUp checkDiagonalWinConditionTwo(SetUp setUp, Character tempPiece);

    SetUp checkTie(SetUp setUp);
}
