package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.Player;

public interface PlayServiceInterface {

    Game performHumanAndHumanMove(Game game);

    Game easyComputerMove(Game game, Player tempPlayer);

    Game mediumComputerMove(Game game, Player tempPlayer);

    Game performEasyComputerMove(Game game);

    Game performMediumComputerMove(Game game);

    Game performGameEnd(Game game, Player tempPlayer);

    Game humanMove(Game game, Player tempPlayer);

    Player getPlayerDetails(Game game);

    Game performHumanMove(Game game);

    Game performHumanAndEasyComputerMove(Game game);

    Game performHumanAndMediumComputerMove(Game game);

    boolean checkHorizontalWin(Game game, String piece);

    boolean checkVerticalWin(Game game, String piece);

    boolean checkDiagonalWin(Game game, String piece);

    boolean checkTie(Game game);
}
