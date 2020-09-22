package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Game;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.lang.Math;

@Service
public class PlayService implements PlayServiceInterface {

    public Game makeHumanMove(Game game) {
        String [][] tempBoardArr = game.getBoard().getBoardArr();

        if(!game.getPlayerList().get(0).getType().equals(game.getLastPlayer().getLastPlayer())) {
            tempBoardArr[game.getPlayerList().get(PlayerConst.ZERO).getxMove()][game.getPlayerList().get(PlayerConst.ZERO).getyMove()] = game.getPlayerList().get(PlayerConst.ZERO).getPiece();
            game.getBoard().setBoardArr(tempBoardArr);

            game.getPlayerList().get(PlayerConst.ZERO).setxMove(PlayerConst.RESET);
            game.getPlayerList().get(PlayerConst.ZERO).setyMove(PlayerConst.RESET);
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(PlayerConst.FIRST_PLAYER).getPiece());
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(PlayerConst.FIRST_PLAYER).getType());
        } else {
            tempBoardArr[game.getPlayerList().get(PlayerConst.ONE).getxMove()][game.getPlayerList().get(PlayerConst.ONE).getyMove()] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
            game.getBoard().setBoardArr(tempBoardArr);

            game.getPlayerList().get(PlayerConst.ONE).setxMove(PlayerConst.RESET);
            game.getPlayerList().get(PlayerConst.ONE).setyMove(PlayerConst.RESET);
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getPiece());
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getType());
        }

        return game;
    }

    public Game makeComputerMove(Game game) {
        String [][] compBoardArr = game.getBoard().getBoardArr();
        Random random = new Random();

        int loopCondition = -1;
        int computerMove;
        String computerPiece;

        if(game.getPlayerList().get(0).getType().equals(game.getLastPlayer().getLastPlayer())) {
            computerPiece = game.getPlayerList().get(1).getPiece();
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(1).getType());
            game.getLastPlayer().setLastPiece(computerPiece);
        } else {
            computerPiece = game.getPlayerList().get(0).getPiece();
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(0).getType());
            game.getLastPlayer().setLastPiece(computerPiece);
        }

        while(loopCondition == -1) {

            computerMove = random.nextInt(9) + 1;

            switch (computerMove) {
                case 1:
                    if (compBoardArr[0][0].equals(GameConst.EMPTY)) {
                        compBoardArr[0][0] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 2:
                    if (compBoardArr[0][2].equals(GameConst.EMPTY)) {
                        compBoardArr[0][2] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 3:
                    if (compBoardArr[0][4].equals(GameConst.EMPTY)) {
                        compBoardArr[0][4] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 4:
                    if (compBoardArr[2][0].equals(GameConst.EMPTY)) {
                        compBoardArr[2][0] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 5:
                    if (compBoardArr[2][2].equals(GameConst.EMPTY)) {
                        compBoardArr[2][2] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 6:
                    if (compBoardArr[2][4].equals(GameConst.EMPTY)) {
                        compBoardArr[2][4] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 7:
                    if (compBoardArr[4][0].equals(GameConst.EMPTY)) {
                        compBoardArr[4][0] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 8:
                    if (compBoardArr[4][2].equals(GameConst.EMPTY)) {
                        compBoardArr[4][2] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                case 9:
                    if (compBoardArr[4][4].equals(GameConst.EMPTY)) {
                        compBoardArr[4][4] = computerPiece;
                    }
                    loopCondition = 1;
                    break;
                default:
                    return null;
            }
        }

        return game;
    }

    public Game performComputerAfterHumanMove(Game game) {

        game = makeComputerMove(game);

        if(checkHorizontalWin(game) || checkVerticalWin(game) || checkDiagonalWin(game)) {
            game.setStateOfPlay(GameConst.OVER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
            return game;
        }

        if(checkTie(game)) {
            game.setStateOfPlay(GameConst.TIE);
            return game;
        }

        return game;
    }

    public Game performHumanBeforeComputerMove(Game game) {

        game = setBoard(game);

        game = switchLastPlayer(game);

        // check for win, if true then return game
        // check for tie, if true then return game
        if(checkHorizontalWin(game) || checkVerticalWin(game) || checkDiagonalWin(game)) {
            game.setStateOfPlay(GameConst.OVER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
            return game;
        }

        if(checkTie(game)) {
            game.setStateOfPlay(GameConst.TIE);
            return game;
        }

        return game;
    }

    public Game setBoard(Game game) {
        String [][] humanMoveBoard = game.getBoard().getBoardArr();

        if(game.getPlayerList().get(0).getType().equals(game.getLastPlayer().getLastPlayer())) {
            humanMoveBoard[game.getPlayerList().get(1).getxMove()][game.getPlayerList().get(1).getyMove()] = game.getPlayerList().get(1).getPiece();
        } else {
            humanMoveBoard[game.getPlayerList().get(0).getxMove()][game.getPlayerList().get(0).getyMove()] = game.getPlayerList().get(0).getPiece();
        }

        game.getBoard().setBoardArr(humanMoveBoard);

        return game;
    }

    public Game switchLastPlayer(Game game) {

        if(game.getPlayerList().get(0).getType().equals(game.getLastPlayer().getLastPlayer())) {
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(1).getType());
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(1).getPiece());
        } else {
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(0).getType());
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(0).getPiece());
        }

        return game;
    }

    public boolean checkHorizontalWin(Game game) {
        String [][] board = game.getBoard().getBoardArr();
        if(board[0][0].equals(board[0][2]) && board[0][2].equals(board[0][4])) { return true; }
        else if(board[2][0].equals(board[2][2]) && board[2][2].equals(board[2][4])) { return true; }
        else if(board[4][0].equals(board[4][2]) && board[4][2].equals(board[4][4])) { return true; }

        return false;
    }

    public boolean checkVerticalWin(Game game) {
        String [][] board = game.getBoard().getBoardArr();
        if(board[0][0].equals(board[2][0]) && board[2][0].equals(board[4][0])) { return true; }
        else if(board[2][0].equals(board[2][2]) && board[2][2].equals(board[2][4])) { return true; }
        else if(board[4][0].equals(board[4][2]) && board[4][2].equals(board[4][4])) { return true; }

        return false;
    }

    public boolean checkDiagonalWin(Game game) {
        String [][] board = game.getBoard().getBoardArr();
        if(board[0][0].equals(board[2][2]) && board[2][2].equals(board[4][4])) { return true; }
        else if(board[0][4].equals(board[2][2]) && board[2][2].equals(board[4][0])) { return true; }

        return false;
    }

    public boolean checkTie(Game game) {
        String [][] board = game.getBoard().getBoardArr();
        int count = 0;
        for(int i = 0; i < board.length; i=i+2) {
            for(int j = 0; j < board.length; j=j+2) {
                if(!board[i][j].equals(" ")) {
                    count = count + 1;
                }
            }
        }

        if(count == 9) {
            return true;
        }
        return false;
    }
}
