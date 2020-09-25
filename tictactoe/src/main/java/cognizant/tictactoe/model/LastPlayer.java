package cognizant.tictactoe.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LastPlayer {

    private String lastPlayer;
    private String lastPiece;

}
