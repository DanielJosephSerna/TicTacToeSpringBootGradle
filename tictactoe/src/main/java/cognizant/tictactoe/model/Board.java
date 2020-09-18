package cognizant.tictactoe.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Board {

    private char [] boardArr;
    private int moveCount;

    public char[] getBoardArr() {
        return boardArr;
    }

    public void setBoardArr(char[] boardArr) {
        this.boardArr = boardArr;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
