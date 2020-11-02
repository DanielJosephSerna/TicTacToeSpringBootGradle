package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SetUpService implements SetUpServiceInterface {

    public SetUp setUpHumanCompGame() {
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerZero = new People(PeopleConst.COMPUTER, PeopleConst.O);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        return new SetUp(Arrays.asList(playerOne, playerZero), board, "ONGOING", 0, new Integer[]{0, 0, 0});
    }

    public SetUp setUpHumanHumanGame() {
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        return new SetUp(Arrays.asList(playerOne, playerTwo), board, "ONGOING", 0, new Integer[]{0, 0, 0});
    }
}
