package cognizant.tictactoe.model;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Player {

    private String type;
    private String piece;
    private int xMove;
    private int yMove;

    public Player(String type, String piece, int xMove, int yMove) {
        this.type = type;
        this.piece = piece;
        this.xMove = xMove;
        this.yMove = yMove;
    }

    public int getxMove() {
        return xMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public int getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
}
