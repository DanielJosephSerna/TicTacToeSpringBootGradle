package cognizant.tictactoe.model;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LastPlayer {
    private String lastPlayer;
    private String lastPiece;
    private int key;

    public LastPlayer(String lastPlayer, String lastPiece, int key) {
        this.lastPlayer = lastPlayer;
        this.lastPiece = lastPiece;
        this.key = key;
    }

    public String getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(String lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public String getLastPiece() {
        return lastPiece;
    }

    public void setLastPiece(String lastPiece) {
        this.lastPiece = lastPiece;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
