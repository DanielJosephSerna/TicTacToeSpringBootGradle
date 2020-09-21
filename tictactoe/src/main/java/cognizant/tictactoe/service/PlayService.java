package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Game;
import org.springframework.stereotype.Service;

import java.util.Random;

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
            game.getLastPlayer().setKey(PlayerConst.FIRST_PLAYER);
        } else {
            tempBoardArr[game.getPlayerList().get(PlayerConst.ONE).getxMove()][game.getPlayerList().get(PlayerConst.ONE).getyMove()] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
            game.getBoard().setBoardArr(tempBoardArr);

            game.getPlayerList().get(PlayerConst.ONE).setxMove(PlayerConst.RESET);
            game.getPlayerList().get(PlayerConst.ONE).setyMove(PlayerConst.RESET);
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getPiece());
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getType());
            game.getLastPlayer().setKey(PlayerConst.SECOND_PLAYER);
        }

        return game;
    }

    public Game makeComputerMove(Game game) {
        String [][] compBoardArr = game.getBoard().getBoardArr();
        Random random = new Random();

        int loopCondition = -1;
        int computerMove;

        while(loopCondition == -1) {
            computerMove = random.nextInt(9) + 1;

            switch (computerMove) {
                case 1:
                    if (compBoardArr[0][0].equals(GameConst.EMPTY)) {
                        compBoardArr[0][0] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 2:
                    if (compBoardArr[0][2].equals(GameConst.EMPTY)) {
                        compBoardArr[0][2] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 3:
                    if (compBoardArr[0][4].equals(GameConst.EMPTY)) {
                        compBoardArr[0][4] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 4:
                    if (compBoardArr[2][0].equals(GameConst.EMPTY)) {
                        compBoardArr[2][0] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 5:
                    if (compBoardArr[2][2].equals(GameConst.EMPTY)) {
                        compBoardArr[2][2] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 6:
                    if (compBoardArr[2][4].equals(GameConst.EMPTY)) {
                        compBoardArr[2][4] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 7:
                    if (compBoardArr[4][0].equals(GameConst.EMPTY)) {
                        compBoardArr[4][0] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 8:
                    if (compBoardArr[4][2].equals(GameConst.EMPTY)) {
                        compBoardArr[4][2] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 9:
                    if (compBoardArr[4][4].equals(GameConst.EMPTY)) {
                        compBoardArr[4][4] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                default:
                    return null;
            }
        }

        if(game.getPlayerList().get(1).getType().equals(PlayerConst.COMPUTER)) {
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getPiece());
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getType());
            game.getLastPlayer().setKey(PlayerConst.SECOND_PLAYER);
        } else {
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(PlayerConst.FIRST_PLAYER).getPiece());
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(PlayerConst.FIRST_PLAYER).getType());
            game.getLastPlayer().setKey(PlayerConst.FIRST_PLAYER);
        }


        return game;
    }

    public Game checkWin(Game game) {

        String [][] checkWinBoard = game.getBoard().getBoardArr();

        if(checkWinBoard[0][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[0][2].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[0][4].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        } else if(checkWinBoard[2][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[2][2].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[2][4].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        } else if(checkWinBoard[4][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[4][2].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[4][4].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        } else if(checkWinBoard[0][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[2][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[4][0].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        } else if(checkWinBoard[2][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[2][2].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[2][4].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        } else if(checkWinBoard[4][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[4][2].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[4][4].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        } else if(checkWinBoard[0][0].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[2][2].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[4][4].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        } else if(checkWinBoard[0][4].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[2][2].equals(game.getLastPlayer().getLastPiece())
                && checkWinBoard[4][0].equals(game.getLastPlayer().getLastPiece())) {
            game.setStateOfPlay(GameConst.WINNER);
            game.setWinnerPlayer(game.getLastPlayer().getLastPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
        }

        return game;
    }

    public Game checkTie(Game game) {
        String [][] checkTieBoard = game.getBoard().getBoardArr();
        int count = 0;
        for(int i = 0; i < checkTieBoard.length; i=i+2) {
            for(int j = 0; j < checkTieBoard.length; j=j+2) {
                if(!checkTieBoard[i][j].equals(" ")) {
                    count = count + 1;
                }
            }
        }

        if(count == 9) {
            game.setStateOfPlay(GameConst.TIE);
        }
        return game;
    }
}
