package cognizant.tictactoe.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Player {

    private String type;
    private char piece;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }
}
