package cognizant.tictactoe.model;

import lombok.*;

@Data
@Setter
@Getter
@ToString
public class Board {

    private String [][] boardArr;
    private boolean isWin;

    public Board() {
    }

    public Board(String[][] boardArr, boolean isWin) {
        this.boardArr = boardArr;
        this.isWin = isWin;
    }

    public boolean isWin() { return isWin; }

    public void setWin(boolean win) { isWin = win; }

    public String[][] getBoardArr() {
        return boardArr;
    }

    public void setBoardArr(String[][] boardArr) {
        this.boardArr = boardArr;
    }
}
