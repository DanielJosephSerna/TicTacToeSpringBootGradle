package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.BestOf;
import org.springframework.stereotype.Service;

@Service
public class MoveService implements MoveServiceInterface {

    int width = 3;

    public BestOf performMove(BestOf bestOf) {
        int r = bestOf.getSetUp().getBoardArr().getPeopleMove();
        int c = bestOf.getSetUp().getBoardArr().getPeopleMove();

        r = r / width;
        c = c % width;

        if(bestOf.getSetUp().getCountMoves() == 0) { // checked

            bestOf.getSetUp().getBoardArr().getBoardArr()[r][c] = bestOf.getSetUp().getPeopleList().get(0).getPiece();
            bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);

            return bestOf;
        } else if(bestOf.getSetUp().getCountMoves() > 0 && bestOf.getSetUp().getCountMoves() < 4) { // checked

            placePieceOnBoard(bestOf, r, c);

            return bestOf;
        } else { // checked

            placePieceOnBoard(bestOf, r, c);
            // check for end game
            isGameOver(bestOf);

            return bestOf;
        }
    }

    public BestOf placePieceOnBoard(BestOf bestOf, int r, int c) {

        if(bestOf.getSetUp().getCountMoves() % 2 == 0) { // checked

            bestOf.getSetUp().getBoardArr().getBoardArr()[r][c] = bestOf.getSetUp().getPeopleList().get(0).getPiece();
            bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);

            return bestOf;
        } else {

            if(bestOf.getSetUp().getPeopleList().get(1).getType().equals(PeopleConst.COMPUTER)
                    && bestOf.getSetUp().getStatus().equals(PeopleConst.ONGOING)) {

                if(bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals(' ') && bestOf.getSetUp().getCountMoves() == 1) {

                    bestOf.getSetUp().getBoardArr().getBoardArr()[1][1] = 'O';
                    bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
                } else if(bestOf.getSetUp().getCountMoves() == 1) {

                    bestOf.getSetUp().getBoardArr().getBoardArr()[0][0] = 'O';
                    bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
                } else {
                    computerMove(bestOf);
                }
            } else { // checked

                bestOf.getSetUp().getBoardArr().getBoardArr()[r][c] = bestOf.getSetUp().getPeopleList().get(1).getPiece();
                bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
            }

            return bestOf;
        }
    }

    public BestOf computerMove(BestOf bestOf) {

        boolean moveMade = true;

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[0][2] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[2][0] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[1][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[0][2] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][2].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[1][2] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][2].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[2][2] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][1].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[2][1] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][1].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[0][1] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[2][0] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][0].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[1][0] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[1][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][0].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[0][0] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][2].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[2][2] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][1].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[2][1] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[2][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[2][0] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[1][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][2].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[1][2] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[1][0].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[1][0] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[0][2] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][0].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][1].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[0][1] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][1].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals('X') && bestOf.getSetUp().getBoardArr().getBoardArr()[0][0].equals(' ') && moveMade) {
            bestOf.getSetUp().getBoardArr().getBoardArr()[0][0] = 'O'; moveMade = false; bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
        }

        if(moveMade) { // checked // #24

            for(int i = 0; i < 3 && moveMade; i=i+1) {
                for(int j = 0; j < 3 && moveMade; j=j+1) {
                    if(bestOf.getSetUp().getBoardArr().getBoardArr()[i][j] == ' ') {

                        bestOf.getSetUp().getBoardArr().getBoardArr()[i][j] = 'O';
                        moveMade = false;
                        bestOf.getSetUp().setCountMoves(bestOf.getSetUp().getCountMoves() + 1);
                    }
                }
            }
        }

        return bestOf;
    }

    public BestOf isGameOver(BestOf bestOf) {

        Character tempPiece;

        if(bestOf.getSetUp().getCountMoves() % 2 == 0) {
            tempPiece = bestOf.getSetUp().getPeopleList().get(1).getPiece();
        } else {  // checked
            tempPiece = bestOf.getSetUp().getPeopleList().get(0).getPiece();
        }

        checkHorizontalWin(bestOf, tempPiece);

        if(bestOf.getSetUp().getStatus().equals(PeopleConst.ONGOING)) {
            // check vertical
            checkVerticalWin(bestOf, tempPiece);
        }

        if(bestOf.getSetUp().getStatus().equals(PeopleConst.ONGOING)) {
            checkDiagonalWinConditionOne(bestOf, tempPiece);
        }

        if(bestOf.getSetUp().getStatus().equals(PeopleConst.ONGOING)) {
            checkDiagonalWinConditionTwo(bestOf, tempPiece);
        }

        if(bestOf.getSetUp().getStatus().equals(PeopleConst.ONGOING)) {
            checkTie(bestOf);
        }

        return bestOf;
    }

    public BestOf checkHorizontalWin(BestOf bestOf, Character tempPiece) { // checked

        for(int i = 0; i < 3 && bestOf.getSetUp().getStatus().equals(PeopleConst.ONGOING); i=i+1) {
            if(bestOf.getSetUp().getBoardArr().getBoardArr()[i][0].equals(tempPiece)
                    && bestOf.getSetUp().getBoardArr().getBoardArr()[i][1].equals(tempPiece)
                    && bestOf.getSetUp().getBoardArr().getBoardArr()[i][2].equals(tempPiece)) {

                bestOf.getSetUp().getWinningLine()[0] = width * i;
                bestOf.getSetUp().getWinningLine()[1] = width * i + 1;
                bestOf.getSetUp().getWinningLine()[2] = width * i + 2;
                bestOf.getSetUp().setStatus("OVER");
            }
        }

        return bestOf;
    }

    public BestOf checkVerticalWin(BestOf bestOf, Character tempPiece) { // checked

        for(int i = 0; i < 3 && bestOf.getSetUp().getStatus().equals(PeopleConst.ONGOING); i=i+1) {
            if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][i].equals(tempPiece)
                    && bestOf.getSetUp().getBoardArr().getBoardArr()[1][i].equals(tempPiece)
                    && bestOf.getSetUp().getBoardArr().getBoardArr()[2][i].equals(tempPiece)) {

                bestOf.getSetUp().getWinningLine()[0] = i;
                bestOf.getSetUp().getWinningLine()[1] = width + i;
                bestOf.getSetUp().getWinningLine()[2] = width * 2 + i;
                bestOf.getSetUp().setStatus("OVER");
            }
        }
        return bestOf;
    }

    public BestOf checkDiagonalWinConditionOne(BestOf bestOf, Character tempPiece) { // checked

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][0].equals(tempPiece)
                && bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals(tempPiece)
                && bestOf.getSetUp().getBoardArr().getBoardArr()[2][2].equals(tempPiece)) {

                bestOf.getSetUp().getWinningLine()[0] = 0;
                bestOf.getSetUp().getWinningLine()[1] = width + 1;
                bestOf.getSetUp().getWinningLine()[2] = width * 2 + 2;
                bestOf.getSetUp().setStatus("OVER");

        }

        return bestOf;
    }

    public BestOf checkDiagonalWinConditionTwo(BestOf bestOf, Character tempPiece) {

        if(bestOf.getSetUp().getBoardArr().getBoardArr()[0][2].equals(tempPiece)
                && bestOf.getSetUp().getBoardArr().getBoardArr()[1][1].equals(tempPiece)
                && bestOf.getSetUp().getBoardArr().getBoardArr()[2][0].equals(tempPiece)) {

                bestOf.getSetUp().getWinningLine()[0] = 2;
                bestOf.getSetUp().getWinningLine()[1] = width + 1;
                bestOf.getSetUp().getWinningLine()[2] = width * 2;
                bestOf.getSetUp().setStatus("OVER");

        }

        return bestOf;
    }

    public BestOf checkTie(BestOf bestOf) {

        if(bestOf.getSetUp().getCountMoves() == 9) {
            bestOf.getSetUp().setStatus("TIE");
            return bestOf;
        }

        return bestOf;
    }
}
