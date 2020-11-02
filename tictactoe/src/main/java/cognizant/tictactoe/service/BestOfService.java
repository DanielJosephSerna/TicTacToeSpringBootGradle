package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.BestOf;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BestOfService {

    public BestOf setUpHumanHumanGame() {
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        return new BestOf(setUp, 1, 0, 0);
    }

    public BestOf setUpHumanCompGame() {
        People playerZero= new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerZero), board, "ONGOING", 0, new Integer[]{0, 0, 0});

        return new BestOf(setUp, 1, 0, 0);
    }
}
