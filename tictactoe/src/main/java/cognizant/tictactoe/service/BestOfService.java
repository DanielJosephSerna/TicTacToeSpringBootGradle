package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.BestOf;
import cognizant.tictactoe.model.People;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.model.TicTacToeBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BestOfService implements BestOfServiceInterface {

    @Autowired
    SetUpService setUpService;

    public BestOf setUpHumanHumanGame() {
        People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, PeopleConst.ONGOING, 0, new Integer[]{0, 0, 0});

        return new BestOf(setUp, 1, 0, 0, PeopleConst.ONGOING);
    }

    public BestOf setUpHumanCompGame() {
        People playerZero= new People(PeopleConst.COMPUTER, PeopleConst.O);
        People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
        TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
        SetUp setUp = new SetUp(Arrays.asList(playerOne, playerZero), board, PeopleConst.ONGOING, 0, new Integer[]{0, 0, 0});

        return new BestOf(setUp, 1, 0, 0, PeopleConst.ONGOING);
    }

    public BestOf performBestOf(BestOf bestOf) {
        int r = bestOf.getSetUp().getWinningLine()[2] / 3;
        int c = bestOf.getSetUp().getWinningLine()[2] % 3;
        int desiredScore = bestOf.getTotalGamesToPlay() / 2 + 1;

        if(bestOf.getSetUp().getStatus().equals("OVER")) {

            if(bestOf.getSetUp().getBoardArr().getBoardArr()[r][c].equals('X')) {

                bestOf.setScore1(bestOf.getScore1() + 1);
            } else {

                bestOf.setScore2(bestOf.getScore2() + 1);
            }

            if( desiredScore == bestOf.getScore1()
                    || desiredScore == bestOf.getScore2() ) {

                bestOf.setIsOver("FINAL");
                return bestOf; // end of best-of-game cycle
            } else {

                if(bestOf.getSetUp().getPeopleList().get(1).getType().equals("HUMAN2")) {

                    People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
                    People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
                    TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
                    SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, PeopleConst.ONGOING, 0, new Integer[]{0, 0, 0});

                    return new BestOf(setUp, bestOf.getTotalGamesToPlay(), bestOf.getScore1(), bestOf.getScore2(), PeopleConst.ONGOING);
                } else {

                    People playerZero = new People(PeopleConst.COMPUTER, PeopleConst.O);
                    People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
                    TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
                    SetUp setUp = new SetUp(Arrays.asList(playerOne, playerZero), board, PeopleConst.ONGOING, 0, new Integer[]{0, 0, 0});

                    return new BestOf(setUp, bestOf.getTotalGamesToPlay(), bestOf.getScore1(), bestOf.getScore2(), PeopleConst.ONGOING);
                }
            }
        } else if(bestOf.getSetUp().getStatus().equals("TIE")) {

            if(bestOf.getSetUp().getPeopleList().get(1).getType().equals("HUMAN2")) {

                People playerTwo = new People(PeopleConst.HUMAN2, PeopleConst.O);
                People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
                TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
                SetUp setUp = new SetUp(Arrays.asList(playerOne, playerTwo), board, PeopleConst.ONGOING, 0, new Integer[]{0, 0, 0});

                return new BestOf(setUp, bestOf.getTotalGamesToPlay(), bestOf.getScore1(), bestOf.getScore2(), PeopleConst.ONGOING);

            } else if(bestOf.getSetUp().getPeopleList().get(1).getType().equals("COMPUTER")) {

                People playerZero = new People(PeopleConst.COMPUTER, PeopleConst.O);
                People playerOne = new People(PeopleConst.HUMAN1, PeopleConst.X);
                TicTacToeBoard board = new TicTacToeBoard(new Character[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}}, 0);
                SetUp setUp = new SetUp(Arrays.asList(playerOne, playerZero), board, PeopleConst.ONGOING, 0, new Integer[]{0, 0, 0});

                return new BestOf(setUp, bestOf.getTotalGamesToPlay(), bestOf.getScore1(), bestOf.getScore2(), PeopleConst.ONGOING);

            }
        }

        return bestOf;
    }
}
