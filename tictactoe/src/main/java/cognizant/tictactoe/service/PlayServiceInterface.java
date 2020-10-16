package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.Player;

public interface PlayServiceInterface {

    Game performHumanAndHumanMove(Game game);

    Game computerMove(Game game, Player tempPlayer);

    Game performComputerMove(Game game);

    Game performGameEnd(Game game, Player tempPlayer);

    Game humanMove(Game game, Player tempPlayer);

    Player getPlayerDetails(Game game);

    Game performHumanMove(Game game);

    Game performHumanAndComputerMove(Game game);

    boolean checkHorizontalWin(Game game, String piece);

    boolean checkVerticalWin(Game game, String piece);

    boolean checkDiagonalWin(Game game, String piece);

    boolean checkTie(Game game);
}
