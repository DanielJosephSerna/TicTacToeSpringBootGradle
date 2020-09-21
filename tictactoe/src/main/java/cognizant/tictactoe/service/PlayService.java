package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Game;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PlayService implements PlayServiceInterface {

    public Game makeHumanVsComputerMove(Game game) {
        String [][] tempBoardArr;
        Random random = new Random();


        if(!game.getPlayerList().get(PlayerConst.ZERO).getType().equals(game.getLastPlayer().getLastPlayer())) {
            // plot human move on board
            tempBoardArr = game.getBoard().getBoardArr();
            tempBoardArr[game.getPlayerList().get(PlayerConst.ZERO).getxMove()][game.getPlayerList().get(PlayerConst.ZERO).getyMove()] = game.getPlayerList().get(PlayerConst.ZERO).getPiece();
            game.getBoard().setBoardArr(tempBoardArr);

            game.getPlayerList().get(PlayerConst.ZERO).setxMove(PlayerConst.RESET);
            game.getPlayerList().get(PlayerConst.ZERO).setyMove(PlayerConst.RESET);
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(PlayerConst.FIRST_PLAYER).getPiece());
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(PlayerConst.FIRST_PLAYER).getType());
            game.getLastPlayer().setKey(PlayerConst.FIRST_PLAYER);

            return game;
        } else {
            // plot computer move on board
            tempBoardArr = game.getBoard().getBoardArr();
            int loopCondition = -1;
            int computerMove;
        while(loopCondition == -1) {
            computerMove = random.nextInt(9) + 1;

            switch (computerMove) {
                case 1:
                    if (tempBoardArr[0][0].equals(GameConst.EMPTY)) {
                        tempBoardArr[0][0] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 2:
                    if (tempBoardArr[0][2].equals(GameConst.EMPTY)) {
                        tempBoardArr[0][2] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 3:
                    if (tempBoardArr[0][4].equals(GameConst.EMPTY)) {
                        tempBoardArr[0][4] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 4:
                    if (tempBoardArr[2][0].equals(GameConst.EMPTY)) {
                        tempBoardArr[2][0] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 5:
                    if (tempBoardArr[2][2].equals(GameConst.EMPTY)) {
                        tempBoardArr[2][2] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 6:
                    if (tempBoardArr[2][4].equals(GameConst.EMPTY)) {
                        tempBoardArr[2][4] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 7:
                    if (tempBoardArr[4][0].equals(GameConst.EMPTY)) {
                        tempBoardArr[4][0] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 8:
                    if (tempBoardArr[4][2].equals(GameConst.EMPTY)) {
                        tempBoardArr[4][2] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                case 9:
                    if (tempBoardArr[4][4].equals(GameConst.EMPTY)) {
                        tempBoardArr[4][4] = game.getPlayerList().get(PlayerConst.ONE).getPiece();
                    }
                    loopCondition = 1;
                    break;
                default:
                    return null;
            }
        }
/*            game.getPlayerList().get(PlayerConst.SECOND_PLAYER).setxMove(PlayerConst.RESET);
            game.getPlayerList().get(PlayerConst.SECOND_PLAYER).setyMove(PlayerConst.RESET);*/
            game.getLastPlayer().setLastPiece(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getPiece());
            game.getLastPlayer().setLastPlayer(game.getPlayerList().get(PlayerConst.SECOND_PLAYER).getType());
            game.getLastPlayer().setKey(PlayerConst.SECOND_PLAYER);

            return game;
        }
    }
}
