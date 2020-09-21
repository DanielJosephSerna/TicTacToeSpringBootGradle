package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Data
public class Game {

    private List<Player> playerList;
    private LastPlayer lastPlayer;

    private Board board;

    private String stateOfPlay;
    private String typeOfGame;
    private String winnerPlayer;
    private String winnerPiece;

    public Game(List<Player> playerList, LastPlayer lastPlayer, Board board, String stateOfPlay, String typeOfGame, String winnerPlayer, String winnerPiece) {
        this.playerList = playerList;
        this.lastPlayer = lastPlayer;
        this.board = board;
        this.stateOfPlay = stateOfPlay;
        this.typeOfGame = typeOfGame;
        this.winnerPlayer = winnerPlayer;
        this.winnerPiece = winnerPiece;
    }

    public Game(List<Player> playerList, LastPlayer lastPlayer, Board board, String stateOfPlay, String typeOfGame) {
        this.playerList = playerList;
        this.lastPlayer = lastPlayer;
        this.board = board;
        this.stateOfPlay = stateOfPlay;
        this.typeOfGame = typeOfGame;
    }

    public Game(List<Player> playerList, LastPlayer lastPlayer) {
        this.playerList = playerList;
        this.lastPlayer = lastPlayer;
    }

    public Game() {
    }


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public LastPlayer getLastPlayer() { return lastPlayer; }

    public void setLastPlayer(LastPlayer lastPlayer) { this.lastPlayer = lastPlayer; }

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

    public String getWinnerPlayer() { return winnerPlayer; }

    public void setWinnerPlayer(String winnerPlayer) { this.winnerPlayer = winnerPlayer; }

    public String getWinnerPiece() { return winnerPiece; }

    public void setWinnerPiece(String winnerPiece) { this.winnerPiece = winnerPiece; }
}
