package cognizant.tictactoe.service;

import cognizant.tictactoe.constants.GameConst;
import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Board;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService implements GameServiceInterface {

    public Game buildGameHumanComputer() {
        Player player1 = new Player();
        player1.setType(PlayerConst.HUMAN);
        player1.setPiece(PlayerConst.X);
        player1.setxMove(PlayerConst.ZERO);
        player1.setyMove(PlayerConst.ZERO);
        Player player2 = new Player();
        player2.setType(PlayerConst.COMPUTER);
        player2.setPiece(PlayerConst.O);
        player2.setxMove(PlayerConst.ZERO);
        player2.setyMove(PlayerConst.ZERO);
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);

        char [] boardArr = {' ', '|', ' ', '|', ' ', '-', '+', '-', '+', '-', ' ', '|', ' ', '|', ' ', '-', '+', '-', '+', '-', ' ', '|', ' ', '|', ' ',};
        int moveCount = 0;
        Board board = new Board();
        board.setBoardArr(boardArr);
        board.setMoveCount(moveCount);

        String stateOfPlay = GameConst.ONGOING;
        String typeOfGame = GameConst.HUMAN_VS_COMPUTER;

        return new Game(playerList, board, stateOfPlay, typeOfGame);
    }
}
