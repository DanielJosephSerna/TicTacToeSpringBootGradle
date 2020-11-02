package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.SetUp;
import org.springframework.stereotype.Service;

@Service
public class MoveService implements MoveServiceInterface {

    int WIDTH = 3;

    public SetUp performMove(SetUp setUp) {
        int r = setUp.getBoardArr().getPeopleMove();
        int c = setUp.getBoardArr().getPeopleMove();

        r = r / WIDTH;
        c = c % WIDTH;

        if(setUp.getCountMoves() == 0) { // checked

            setUp.getBoardArr().getBoardArr()[r][c] = setUp.getPeopleList().get(0).getPiece();
            setUp.setCountMoves(setUp.getCountMoves() + 1);

            return setUp;
        } else if(setUp.getCountMoves() > 0 && setUp.getCountMoves() < 4) { // checked

            placePieceOnBoard(setUp, r, c);

            return setUp;
        } else { // checked

            placePieceOnBoard(setUp, r, c);
            // check for end game
            isGameOver(setUp);

            return setUp;
        }
    }

    public SetUp placePieceOnBoard(SetUp setUp, int r, int c) {

        if(setUp.getCountMoves() % 2 == 0) { // checked

            setUp.getBoardArr().getBoardArr()[r][c] = setUp.getPeopleList().get(0).getPiece();
            setUp.setCountMoves(setUp.getCountMoves() + 1);

            return setUp;
        } else {

            if(setUp.getPeopleList().get(1).getType().equals(PeopleConst.COMPUTER)
                    && setUp.getStatus().equals("ONGOING")) {

                if(setUp.getBoardArr().getBoardArr()[1][1].equals(' ') && setUp.getCountMoves() == 1) {

                    setUp.getBoardArr().getBoardArr()[1][1] = 'O';
                    setUp.setCountMoves(setUp.getCountMoves() + 1);
                } else if(setUp.getCountMoves() == 1) {

                    setUp.getBoardArr().getBoardArr()[0][0] = 'O';
                    setUp.setCountMoves(setUp.getCountMoves() + 1);
                } else {
                    computerMove(setUp);
                }
            } else { // checked

                setUp.getBoardArr().getBoardArr()[r][c] = setUp.getPeopleList().get(1).getPiece();
                setUp.setCountMoves(setUp.getCountMoves() + 1);
            }

            return setUp;
        }
    }

    public SetUp computerMove(SetUp setUp) {

        boolean moveMade = true;

        if(setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][0].equals('X') && setUp.getBoardArr().getBoardArr()[0][2].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[0][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

/*            if(setUp.getBoardArr().getBoardArr()[0][2].equals('X') && setUp.getBoardArr().getBoardArr()[2][0].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals(' ') && moveMade) {
                setUp.getBoardArr().getBoardArr()[1][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
            } // checked - also take this out along with test // #1*/

        if(setUp.getBoardArr().getBoardArr()[0][2].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][0].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[2][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

/*            if(setUp.getBoardArr().getBoardArr()[0][0].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals(' ') && moveMade) {
                setUp.getBoardArr().getBoardArr()[2][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
            } // checked - also take this out along with test // #3*/

/*            if(setUp.getBoardArr().getBoardArr()[0][0].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals(' ') && moveMade) {
                setUp.getBoardArr().getBoardArr()[1][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
            } // checked = also take this out along with test // #4*/

/*            if(setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals('X') && setUp.getBoardArr().getBoardArr()[0][0].equals(' ') && moveMade) {
                setUp.getBoardArr().getBoardArr()[0][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
            } // checked - also take this out along with test // #5*/

        if(setUp.getBoardArr().getBoardArr()[1][2].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals('X') && setUp.getBoardArr().getBoardArr()[0][2].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[0][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][2].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals('X') && setUp.getBoardArr().getBoardArr()[1][2].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[1][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][2].equals('X') && setUp.getBoardArr().getBoardArr()[1][2].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[2][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][1].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][1].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[2][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

/*            if(setUp.getBoardArr().getBoardArr()[0][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][1].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals(' ') && moveMade) {
                setUp.getBoardArr().getBoardArr()[1][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
            } // checked - also take this out along with test // #10*/

        if(setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][1].equals('X') && setUp.getBoardArr().getBoardArr()[0][1].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[0][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][0].equals('X') && setUp.getBoardArr().getBoardArr()[1][0].equals('X') && setUp.getBoardArr().getBoardArr()[2][0].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[2][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][0].equals('X') && setUp.getBoardArr().getBoardArr()[2][0].equals('X') && setUp.getBoardArr().getBoardArr()[1][0].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[1][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[1][0].equals('X') && setUp.getBoardArr().getBoardArr()[2][0].equals('X') && setUp.getBoardArr().getBoardArr()[0][0].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[0][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[2][0].equals('X') && setUp.getBoardArr().getBoardArr()[2][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[2][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[2][0].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals('X') && setUp.getBoardArr().getBoardArr()[2][1].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[2][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[2][1].equals('X') && setUp.getBoardArr().getBoardArr()[2][2].equals('X') && setUp.getBoardArr().getBoardArr()[2][0].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[2][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[1][0].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[1][2].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[1][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

/*            if(setUp.getBoardArr().getBoardArr()[1][0].equals('X') && setUp.getBoardArr().getBoardArr()[1][2].equals('X') && setUp.getBoardArr().getBoardArr()[1][1].equals(' ') && moveMade) {
                setUp.getBoardArr().getBoardArr()[1][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
            } // checked - also take this out along with test // #19*/

        if(setUp.getBoardArr().getBoardArr()[1][1].equals('X') && setUp.getBoardArr().getBoardArr()[1][2].equals('X') && setUp.getBoardArr().getBoardArr()[1][0].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[1][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][0].equals('X') && setUp.getBoardArr().getBoardArr()[0][1].equals('X') && setUp.getBoardArr().getBoardArr()[0][2].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[0][2] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][0].equals('X') && setUp.getBoardArr().getBoardArr()[0][2].equals('X') && setUp.getBoardArr().getBoardArr()[0][1].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[0][1] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(setUp.getBoardArr().getBoardArr()[0][1].equals('X') && setUp.getBoardArr().getBoardArr()[0][2].equals('X') && setUp.getBoardArr().getBoardArr()[0][0].equals(' ') && moveMade) {
            setUp.getBoardArr().getBoardArr()[0][0] = 'O'; moveMade = false; setUp.setCountMoves(setUp.getCountMoves() + 1);
        }

        if(moveMade == true) { // checked // #24

            for(int i = 0; i < 3 && moveMade; i=i+1) {
                for(int j = 0; j < 3 && moveMade; j=j+1) {
                    if(setUp.getBoardArr().getBoardArr()[i][j] == ' ') {

                        setUp.getBoardArr().getBoardArr()[i][j] = 'O';
                        moveMade = false;
                        setUp.setCountMoves(setUp.getCountMoves() + 1);
                    }
                }
            }
        }

        return setUp;
    }

    public SetUp isGameOver(SetUp setUp) {

        Character tempPiece;

        if(setUp.getCountMoves() % 2 == 0) {
            tempPiece = setUp.getPeopleList().get(1).getPiece();
        } else {  // checked
            tempPiece = setUp.getPeopleList().get(0).getPiece();
        }

        checkHorizontalWin(setUp, tempPiece);

        if(setUp.getStatus().equals("ONGOING")) {
            // check vertical
            checkVerticalWin(setUp, tempPiece);
        }

        if(setUp.getStatus().equals("ONGOING")) {
            checkDiagonalWinConditionOne(setUp, tempPiece);
        }

        if(setUp.getStatus().equals("ONGOING")) {
            checkDiagonalWinConditionTwo(setUp, tempPiece);
        }

        if(setUp.getStatus().equals("ONGOING")) {
            checkTie(setUp);
        }

        return setUp;
    }

    public SetUp checkHorizontalWin(SetUp setUp, Character tempPiece) { // checked

        for(int i = 0; i < 3 && setUp.getStatus().equals("ONGOING"); i=i+1) {
            if(setUp.getBoardArr().getBoardArr()[i][0].equals(tempPiece)
                    && setUp.getBoardArr().getBoardArr()[i][1].equals(tempPiece)
                    && setUp.getBoardArr().getBoardArr()[i][2].equals(tempPiece)) {

                setUp.getWinningLine()[0] = WIDTH * i;
                setUp.getWinningLine()[1] = WIDTH * i + 1;
                setUp.getWinningLine()[2] = WIDTH * i + 2;
                setUp.setStatus("OVER");
            }
        }

        return setUp;
    }

    public SetUp checkVerticalWin(SetUp setUp, Character tempPiece) { // checked

        for(int i = 0; i < 3 && setUp.getStatus().equals("ONGOING"); i=i+1) {
            if(setUp.getBoardArr().getBoardArr()[0][i].equals(tempPiece)
                    && setUp.getBoardArr().getBoardArr()[1][i].equals(tempPiece)
                    && setUp.getBoardArr().getBoardArr()[2][i].equals(tempPiece)) {

                setUp.getWinningLine()[0] = i;
                setUp.getWinningLine()[1] = WIDTH + i;
                setUp.getWinningLine()[2] = WIDTH * 2 + i;
                setUp.setStatus("OVER");
            }
        }
        return setUp;
    }

    public SetUp checkDiagonalWinConditionOne(SetUp setUp, Character tempPiece) { // checked

        if(setUp.getBoardArr().getBoardArr()[0][0].equals(tempPiece) && setUp.getBoardArr().getBoardArr()[1][1].equals(tempPiece)) {

            if(setUp.getBoardArr().getBoardArr()[1][1].equals(tempPiece) && setUp.getBoardArr().getBoardArr()[2][2].equals(tempPiece)) {
                setUp.getWinningLine()[0] = 0;
                setUp.getWinningLine()[1] = WIDTH + 1;
                setUp.getWinningLine()[2] = WIDTH * 2 + 2;
                setUp.setStatus("OVER");
            }
        }

        return setUp;
    }

    public SetUp checkDiagonalWinConditionTwo(SetUp setUp, Character tempPiece) { // checked

        if(setUp.getBoardArr().getBoardArr()[0][2].equals(tempPiece) && setUp.getBoardArr().getBoardArr()[1][1].equals(tempPiece)) {

            if(setUp.getBoardArr().getBoardArr()[1][1].equals(tempPiece) && setUp.getBoardArr().getBoardArr()[2][0].equals(tempPiece)) {

                setUp.getWinningLine()[0] = 2;
                setUp.getWinningLine()[1] = WIDTH + 1;
                setUp.getWinningLine()[2] = WIDTH * 2;
                setUp.setStatus("OVER");
            }
        }

        return setUp;
    }

    public SetUp checkTie(SetUp setUp) {

        if(setUp.getCountMoves() == 9) {
            setUp.setStatus("TIE");
            return setUp;
        }

        return setUp;
    }
}
