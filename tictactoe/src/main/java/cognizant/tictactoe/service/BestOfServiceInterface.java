package cognizant.tictactoe.service;

import cognizant.tictactoe.model.BestOf;

public interface BestOfServiceInterface {

    BestOf setUpHumanHumanGame();

    BestOf setUpHumanCompGame();

    BestOf performBestOf(BestOf bestOf);

}
