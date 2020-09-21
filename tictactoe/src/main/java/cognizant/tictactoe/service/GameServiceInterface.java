package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;

public interface GameServiceInterface {

    public Game setUpPlayers(Game game);

    public Game setUpBoard(Game game);

    public Game setUpGame(Game game);
}
