package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.Player;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class PlayService implements PlayServiceInterface {

    String [] tempBoard;
    Player tempPlayer;
    Integer [] winningLine;
    int countMoves;

    public int getNumberOfMoves(String [] board) {
        countMoves = 0;

        for(int i = 0; i < 9; i=i+1) {
            if(!board[i].equals(" ")) {
                countMoves = countMoves + 1;
            }
        }

        return countMoves;
    }

    public Game mediumComputerMove(Game game, Player tempPlayer) {

        String [] copyBoard = new String[9];

        for(int i = 0; i < 9; i=i+1) {
            copyBoard[i] =  tempBoard[i];
        }

        int compare = countMoves;
        int checkForTwoMoves = countMoves;

        if(countMoves == 1) {
            if(copyBoard[4].equals(" ")) {
                copyBoard[4] = tempPlayer.getPiece(); compare = compare + 1;
            } else if(copyBoard[0].equals(" ")) {
                copyBoard[0] = tempPlayer.getPiece(); compare = compare + 1;
            } else if(copyBoard[2].equals(" ")) {
                copyBoard[2] = tempPlayer.getPiece(); compare = compare + 1;
            } else if(copyBoard[6].equals(" ")) {
                copyBoard[6] = tempPlayer.getPiece(); compare = compare + 1;
            } else if(copyBoard[8].equals(" ")) {
                copyBoard[8] = tempPlayer.getPiece(); compare = compare + 1;
            }
        } else if(countMoves > 2) {
            if(copyBoard[4].equals("X") && copyBoard[6].equals("X") && copyBoard[2].equals(" ")) {
                copyBoard[2] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[2].equals("X") && copyBoard[6].equals("X") && copyBoard[4].equals(" ")) {
                copyBoard[4] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[2].equals("X") && copyBoard[4].equals("X") && copyBoard[6].equals(" ")) {
                copyBoard[6] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[0].equals("X") && copyBoard[4].equals("X") && copyBoard[8].equals(" ")) {
                copyBoard[8] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[0].equals("X") && copyBoard[8].equals("X") && copyBoard[4].equals(" ")) {
                copyBoard[4] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[4].equals("X") && copyBoard[8].equals("X") && copyBoard[0].equals(" ")) {
                copyBoard[0] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[5].equals("X") && copyBoard[8].equals("X") && copyBoard[2].equals(" ")) {
                copyBoard[2] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[2].equals("X") && copyBoard[8].equals("X") && copyBoard[5].equals(" ")) {
                copyBoard[5] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[2].equals("X") && copyBoard[5].equals("X") && copyBoard[8].equals(" ")) {
                copyBoard[8] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[1].equals("X") && copyBoard[4].equals("X") && copyBoard[7].equals(" ")) {
                copyBoard[7] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[1].equals("X") && copyBoard[7].equals("X") && copyBoard[4].equals(" ")) {
                copyBoard[4] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[4].equals("X") && copyBoard[7].equals("X") && copyBoard[1].equals(" ")) {
                copyBoard[1] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[0].equals("X") && copyBoard[3].equals("X") && copyBoard[6].equals(" ")) {
                copyBoard[6] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[0].equals("X") && copyBoard[6].equals("X") && copyBoard[3].equals(" ")) {
                copyBoard[3] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[3].equals("X") && copyBoard[6].equals("X") && copyBoard[0].equals(" ")) {
                copyBoard[0] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[6].equals("X") && copyBoard[7].equals("X") && copyBoard[8].equals(" ")) {
                copyBoard[8] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[6].equals("X") && copyBoard[8].equals("X") && copyBoard[7].equals(" ")) {
                copyBoard[7] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[7].equals("X") && copyBoard[8].equals("X") && copyBoard[6].equals(" ")) {
                copyBoard[6] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[3].equals("X") && copyBoard[4].equals("X") && copyBoard[5].equals(" ")) {
                copyBoard[5] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[3].equals("X") && copyBoard[5].equals("X") && copyBoard[4].equals(" ")) {
                copyBoard[4] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[4].equals("X") && copyBoard[5].equals("X") && copyBoard[3].equals(" ")) {
                copyBoard[3] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[0].equals("X") && copyBoard[1].equals("X") && copyBoard[2].equals(" ")) {
                copyBoard[2] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[0].equals("X") && copyBoard[2].equals("X") && copyBoard[1].equals(" ")) {
                copyBoard[1] = tempPlayer.getPiece(); compare = compare + 1;
            }

            if(copyBoard[1].equals("X") && copyBoard[2].equals("X") && copyBoard[0].equals(" ")) {
                copyBoard[0] = tempPlayer.getPiece(); compare = compare + 1;
            }
        }

        boolean loop = true;
        int i = 0;
        if(compare == countMoves) {

            while(loop) {
                if(copyBoard[i].equals(" ")) {
                    copyBoard[i] = tempPlayer.getPiece();
                    compare = compare + 1;
                    loop = false;
                } i=i+1;
            }
        }

        i = 8;
        loop = true;


        if(compare == (checkForTwoMoves + 2)) {

            while(i > -1 && loop) {

                if (!tempBoard[i].equals(copyBoard[i])) {

                    copyBoard[i] = tempBoard[1];
                    loop = false;
                }
                i = i - 1;
            }
        }

        game.getBoard().setBoardArr(copyBoard);
        tempBoard = copyBoard;

        return game;
    }

    public Game performMediumComputerMove(Game game) {
        tempPlayer = getPlayerDetails(game);

        game = mediumComputerMove(game, tempPlayer);

        countMoves = countMoves + 1;

        game = performGameEnd(game, tempPlayer);

        return game;
    }

    public Game performHumanAndMediumComputerMove(Game game) {

        countMoves = getNumberOfMoves(game.getBoard().getBoardArr());

        game  = performHumanMove(game);

        if(game.getStatus().equals(GameConst.OVER) || game.getStatus().equals(GameConst.TIE)) {
            return game;
        }

        game = performMediumComputerMove(game);

        return game;
    }

    public Game performHumanAndHumanMove(Game game) {

        game = performHumanMove(game);

        return game;
    }

    public Game easyComputerMove(Game game, Player tempPlayer) {

        tempBoard = game.getBoard().getBoardArr();
        Random random = new Random();

        int loopCondition = -1;
        int computerMove;

        if(countMoves == 1) {

            if(tempBoard[4].equals(" ")) {
                tempBoard[4] = tempPlayer.getPiece();
            } else if(tempBoard[0].equals(" ")) {
                tempBoard[0] = tempPlayer.getPiece();
            } else if(tempBoard[2].equals(" ")) {
                tempBoard[2] = tempPlayer.getPiece();
            } else if(tempBoard[6].equals(" ")) {
                tempBoard[6] = tempPlayer.getPiece();
            } else if(tempBoard[8].equals(" ")) {
                tempBoard[8] = tempPlayer.getPiece();
            }
        } else {
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
        }

        game.getBoard().setBoardArr(tempBoard);

        return game;
    }

    public Game performEasyComputerMove(Game game) {
        tempPlayer = getPlayerDetails(game);

        game = easyComputerMove(game, tempPlayer);

        countMoves = countMoves + 1;

        game = performGameEnd(game, tempPlayer);

        return game;
    }

    public Game humanMove(Game game, Player tempPlayer) {
        tempBoard = game.getBoard().getBoardArr();

        tempBoard[tempPlayer.getMove()] = tempPlayer.getPiece();

        game.getBoard().setBoardArr(tempBoard);

        return game;
    }

    public Game performHumanMove(Game game) {

        tempPlayer = getPlayerDetails(game);

        game = humanMove(game, tempPlayer);

        countMoves = countMoves + 1;

        game = performGameEnd(game, tempPlayer);

        return game;
    }

    public Game performHumanAndEasyComputerMove(Game game) {

        game  = performHumanMove(game);

        if(game.getStatus().equals(GameConst.OVER) || game.getStatus().equals(GameConst.TIE)) {
            return game;
        }

        game = performEasyComputerMove(game);

        return game;
    }

    public Player getPlayerDetails(Game game) {

        int switchPlayer = 0;
        tempBoard = game.getBoard().getBoardArr();

        for(int i = 0; i < 9; i=i+1) {
            if(tempBoard[i].equals(" ")) {
                switchPlayer = switchPlayer + 1;
            }
        }

        if(switchPlayer % 2 == 0) {
            return game.getPlayerList().get(PlayerConst.ONE);
        } else {
            return game.getPlayerList().get(PlayerConst.ZERO);
        }
    }

    public Game performGameEnd(Game game, Player tempPlayer) {
        if(checkHorizontalWin(game, tempPlayer.getPiece())
                || checkVerticalWin(game, tempPlayer.getPiece())
                || checkDiagonalWin(game, tempPlayer.getPiece())) {
            game.setStatus(GameConst.OVER);
            return game;
        }

        if(checkTie(game)) {
            game.setStatus(GameConst.TIE);
            return game;
        }
        return game;
    }

    public boolean checkHorizontalWin(Game game, String piece) {
        tempBoard = game.getBoard().getBoardArr();

        for(int i = 0; i < 9; i=i+3) {
            if(tempBoard[i].equals(piece) && tempBoard[i + 1].equals(piece) && tempBoard[i + 2].equals(piece)) {
                winningLine=new Integer[]{i, i+1, i+2};
                game.setWinningLine(winningLine);
                return true;
            }
        }

        return false;
    }

    public boolean checkVerticalWin(Game game, String piece) {
        tempBoard = game.getBoard().getBoardArr();

        for(int i = 0; i <= 2; i=i+1) {
            if(tempBoard[i].equals(piece) && tempBoard[i + 3].equals(piece) && tempBoard[i + 6].equals(piece)) {
                winningLine=new Integer[]{i, i+3, i+6};
                game.setWinningLine(winningLine);
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagonalWin(Game game, String piece) {
        tempBoard = game.getBoard().getBoardArr();

        for(int i = 0; i <= 2; i=i+2) {
            if(i == 0) {
                if(tempBoard[i].equals(piece) && tempBoard[i + 4].equals(piece) && tempBoard[i + 8].equals(piece)) {
                    winningLine=new Integer[]{i, i+4, i+8};
                    game.setWinningLine(winningLine);
                    return true;
                }
            } else if(i == 2 && tempBoard[i].equals(piece) && tempBoard[i + 2].equals(piece) && tempBoard[i + 4].equals(piece)) {
                winningLine=new Integer[]{i, i+2, i+4};
                game.setWinningLine(winningLine);
                return true;
            }
        }

        return false;
    }

    public boolean checkTie(Game game) {
        tempBoard = game.getBoard().getBoardArr();
        for(int i = 0; i < 9; i++) {
            if(tempBoard[i].equals(GameConst.EMPTY)) {
                return false;
            }
        }

        return true;
    }
}
