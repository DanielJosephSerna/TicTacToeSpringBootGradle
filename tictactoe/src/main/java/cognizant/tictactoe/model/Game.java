package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Game {

    private List<Player> playerList;
    private Board board;
    private String stateOfPlay;
    private String typeOfGame;

    public Game(List<Player> playerList, Board board, String stateOfPlay, String typeOfGame) {
        this.playerList = playerList;
        this.board = board;
        this.stateOfPlay = stateOfPlay;
        this.typeOfGame = typeOfGame;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getStateOfPlay() {
        return stateOfPlay;
    }

    public void setStateOfPlay(String stateOfPlay) {
        this.stateOfPlay = stateOfPlay;
    }

    public String getTypeOfGame() {
        return typeOfGame;
    }

    public void setTypeOfGame(String typeOfGame) {
        this.typeOfGame = typeOfGame;
    }
}
