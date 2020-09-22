package cognizant.tictactoe.model;

import lombok.*;

@Data
@Setter
@Getter
@ToString
public class Board {

    private String [][] boardArr;

    public Board() {
    }

    public Board(String[][] boardArr) {
        this.boardArr = boardArr;
    }

    public String[][] getBoardArr() {
        return boardArr;
    }

    public void setBoardArr(String[][] boardArr) {
        this.boardArr = boardArr;
    }
}
