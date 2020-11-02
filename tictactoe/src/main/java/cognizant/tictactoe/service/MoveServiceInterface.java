package cognizant.tictactoe.service;

import cognizant.tictactoe.model.BestOf;

public interface MoveServiceInterface {

    BestOf performMove(BestOf bestOf);

    BestOf placePieceOnBoard(BestOf bestOf, int r, int c);

    BestOf computerMove(BestOf bestOf);

    BestOf isGameOver(BestOf bestOf);

    BestOf checkHorizontalWin(BestOf bestOf, Character tempPiece);

    BestOf checkVerticalWin(BestOf bestOf, Character tempPiece);

    BestOf checkDiagonalWinConditionOne(BestOf bestOf, Character tempPiece);

    BestOf checkDiagonalWinConditionTwo(BestOf bestOf, Character tempPiece);

    BestOf checkTie(BestOf bestOf);
}
