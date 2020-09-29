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

    public Game setUpHumanComputerGame() {
        Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        Player player2 = new Player(PlayerConst.COMPUTER, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.COMPUTER, PlayerConst.O);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}});

        return new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.HUMAN_VS_COMPUTER, GameConst.EMPTY, GameConst.EMPTY);
    }

    public Game setUpComputerHumanGame() {
        Player player1 = new Player(PlayerConst.COMPUTER, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        Player player2 = new Player(PlayerConst.HUMAN1, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.HUMAN1, PlayerConst.O);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}});

        return new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.COMPUTER_VS_HUMAN, GameConst.EMPTY, GameConst.EMPTY);
    }

    public Game setUpHumanHumanGame() {
        Player player1 = new Player(PlayerConst.HUMAN1, PlayerConst.X, PlayerConst.ZERO, PlayerConst.ZERO);

        Player player2 = new Player(PlayerConst.HUMAN2, PlayerConst.O, PlayerConst.ZERO, PlayerConst.ZERO);

        LastPlayer lastPlayer = new LastPlayer(PlayerConst.HUMAN2, PlayerConst.O);

        Board board = new Board(new String[][]{{" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "},
                {"-", "+", "-", "+", "-"},
                {" ", "|", " ", "|", " "}});

        return new Game(Arrays.asList(player1, player2), lastPlayer, board, GameConst.ONGOING, GameConst.HUMAN_VS_HUMAN, GameConst.EMPTY, GameConst.EMPTY);
    }
}
