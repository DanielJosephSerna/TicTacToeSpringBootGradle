package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.Player;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PlayService implements PlayServiceInterface {

    String [] tempBoard;
    Player tempPlayer;

    public Game computerMove(Game game, Player tempPlayer) {
        tempBoard = game.getBoard().getBoardArr();
        Random random = new Random();

        int loopCondition = -1;
        int computerMove;

        while(loopCondition == -1) {

            computerMove = random.nextInt(9) + 1;

            switch (computerMove) {
                case 1:
                    if (tempBoard[0].equals(GameConst.EMPTY)) {
                        tempBoard[0] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 2:
                    if (tempBoard[1].equals(GameConst.EMPTY)) {
                        tempBoard[1] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 3:
                    if (tempBoard[2].equals(GameConst.EMPTY)) {
                        tempBoard[2] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 4:
                    if (tempBoard[3].equals(GameConst.EMPTY)) {
                        tempBoard[3] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 5:
                    if (tempBoard[4].equals(GameConst.EMPTY)) {
                        tempBoard[4] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 6:
                    if (tempBoard[5].equals(GameConst.EMPTY)) {
                        tempBoard[5] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 7:
                    if (tempBoard[6].equals(GameConst.EMPTY)) {
                        tempBoard[6] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 8:
                    if (tempBoard[7].equals(GameConst.EMPTY)) {
                        tempBoard[7] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                case 9:
                    if (tempBoard[8].equals(GameConst.EMPTY)) {
                        tempBoard[8] = tempPlayer.getPiece();
                        loopCondition = 1;
                    }
                    break;
                default:
                    return null;
            }
        }

        game.getBoard().setBoardArr(tempBoard);

        return game;
    }

    public Game performComputerMove(Game game) {
        // acquire player's type, piece, x & y coordinates
        tempPlayer = getPlayerDetails(game);

        // set move in board
        game = computerMove(game, tempPlayer);

        // switch the player
        game = performPlayerSwitch(game, tempPlayer);

        // check for win or tie
        game = performGameEnd(game, tempPlayer);

        return game;
    }

    public Game performPlayerSwitch(Game game, Player tempPlayer) {
        game.getLastPlayer().setPreviousPlayer(tempPlayer.getType());
        game.getLastPlayer().setLastPiece(tempPlayer.getPiece());
        return game;
    }

    public Game performGameEnd(Game game, Player tempPlayer) {
        if(checkHorizontalWin(game, tempPlayer.getPiece())
                || checkVerticalWin(game, tempPlayer.getPiece())
                || checkDiagonalWin(game, tempPlayer.getPiece())) {
            game.setStateOfPlay(GameConst.OVER);
            game.setWinnerPlayer(game.getLastPlayer().getPreviousPlayer());
            game.setWinnerPiece(game.getLastPlayer().getLastPiece());
            return game;
        }

        if(checkTie(game)) {
            game.setStateOfPlay(GameConst.TIE);
            return game;
        }
        return game;
    }

    public Game humanMove(Game game, Player tempPlayer) {
        tempBoard = game.getBoard().getBoardArr();

        tempBoard[tempPlayer.getMove()] = tempPlayer.getPiece();

        game.getBoard().setBoardArr(tempBoard);

        return game;
    }

    public Player getPlayerDetails(Game game) {

        if(game.getPlayerList().get(PlayerConst.ZERO).getType().equals(game.getLastPlayer().getPreviousPlayer())) {
            return game.getPlayerList().get(PlayerConst.ONE);
        } else {
            return game.getPlayerList().get(PlayerConst.ZERO);
        }
    }

    public Game performHumanMove(Game game) {

        // acquire player's type, piece, x & y coordinates
        tempPlayer = getPlayerDetails(game);

        // set move in board
        game = humanMove(game, tempPlayer);

        // switch the players
        game = performPlayerSwitch(game, tempPlayer);

        // check for win or tie
        game = performGameEnd(game, tempPlayer);

        return game;
    }

    public Game performHumanAndComputerMove(Game game) {

        // do HUMAN move
        game  = performHumanMove(game);

        // check for win or tie
        if(game.getStateOfPlay().equals(GameConst.OVER) || game.getStateOfPlay().equals(GameConst.TIE)) {
            return game;
        }

        // do COMPUTER move
        game = performComputerMove(game);

        // check for win or tie
        return game;
    }

    public boolean checkHorizontalWin(Game game, String piece) {
        tempBoard = game.getBoard().getBoardArr();
        if(tempBoard[0].equals(piece) && tempBoard[1].equals(piece) && tempBoard[2].equals(piece)) { return true; }
        if(tempBoard[3].equals(piece) && tempBoard[4].equals(piece) && tempBoard[5].equals(piece)) { return true; }
        if(tempBoard[6].equals(piece) && tempBoard[7].equals(piece) && tempBoard[8].equals(piece)) { return true; }

        return false;
    }

    public boolean checkVerticalWin(Game game, String piece) {
        tempBoard = game.getBoard().getBoardArr();
        if(tempBoard[0].equals(piece) && tempBoard[1].equals(piece) && tempBoard[2].equals(piece)) { return true; }
        if(tempBoard[3].equals(piece) && tempBoard[4].equals(piece) && tempBoard[5].equals(piece)) { return true; }
        if(tempBoard[6].equals(piece) && tempBoard[7].equals(piece) && tempBoard[8].equals(piece)) { return true; }

        return false;
    }

    public boolean checkDiagonalWin(Game game, String piece) {
        tempBoard = game.getBoard().getBoardArr();
        if(tempBoard[0].equals(piece) && tempBoard[4].equals(piece) && tempBoard[8].equals(piece)) { return true; }
        if(tempBoard[2].equals(piece) && tempBoard[4].equals(piece) && tempBoard[8].equals(piece)) { return true; }

        return false;
    }

    public boolean checkTie(Game game) {
        for(int i = 0; i < 9; i++) {
            if(! tempBoard[i].equals(GameConst.EMPTY)) {
                return false;
            }
        }

        return true;
    }
}
