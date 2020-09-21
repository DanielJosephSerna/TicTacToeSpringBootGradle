package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;

public interface PlayServiceInterface {
    public Game makeHumanMove(Game game);

    public Game makeComputerMove(Game game);

    public Game checkWin(Game game);

    public Game checkTie(Game game);
}
