package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;

public interface PlayServiceInterface {
    public Game makeHumanMove(Game game);

    public Game makeComputerMove(Game game);

    public Game setBoard(Game game);

    public Game switchLastPlayer(Game game);

    public boolean checkHorizontalWin(Game game);

    public boolean checkVerticalWin(Game game);

    public boolean checkDiagonalWin(Game game);

    public boolean checkTie(Game game);

    public Game performHumanBeforeComputerMove(Game game);
}
