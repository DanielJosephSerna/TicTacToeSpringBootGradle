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

    public LastPlayer(String lastPlayer, String lastPiece) {
        this.lastPlayer = lastPlayer;
        this.lastPiece = lastPiece;
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
}
