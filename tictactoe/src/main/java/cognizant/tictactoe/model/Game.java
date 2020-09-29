package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    private List<Player> playerList;
    private LastPlayer lastPlayer;

    private Board board;

    private String stateOfPlay;
    private String typeOfGame;
    private String winnerPlayer;
    private String winnerPiece;

}
