package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;

public interface GameServiceInterface {

    public Game setUpPlayersHumanComputer(Game game);

    public Game setUpPlayersComputerHuman(Game game);

    public Game setUpBoard(Game game);

    public Game setUpGame(Game game);
}
