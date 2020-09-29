package cognizant.tictactoe.service;

import cognizant.tictactoe.model.Game;

public interface GameServiceInterface {

    Game setUpHumanComputerGame();

    Game setUpComputerHumanGame();

    Game setUpHumanHumanGame();
}
