package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.LastPlayer;
import cognizant.tictactoe.model.Player;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GameService implements GameServiceInterface {

    public Game setUpPlayersHumanComputer(Game game) {
        Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O);

        game.setPlayerList(Arrays.asList(player1, player2));
        game.setLastPlayer(lastPlayer);

        return game;
    }

    public Game setUpPlayersComputerHuman(Game game) {
        Player player1 = new Player(PlayerConst.COMPUTER, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        Player player2 = new Player(PlayerConst.HUMAN1, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O);

        game.setPlayerList(Arrays.asList(player1, player2));
        game.setLastPlayer(lastPlayer);

        return game;
    }

    public Game setUpBoard(Game game) {
        String [][] boardArr = {{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}};
        Board board = new Board();
        board.setBoardArr(boardArr);


        game.setBoard(board);

        return game;
    }

    public Game setUpGame(Game game) {
        String stateOfPlay = GameConst.ONGOING;
        String typeOfGame = GameConst.HUMAN_VS_COMPUTER;
        String winnerPlayer = " ";
        String winnerPiece = " ";

        game.setStateOfPlay(stateOfPlay);
        game.setTypeOfGame(typeOfGame);
        game.setWinnerPlayer(winnerPlayer);
        game.setWinnerPiece(winnerPiece);

        return game;
    }
}
