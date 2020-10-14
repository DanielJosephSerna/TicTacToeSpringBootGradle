package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    private List<Player> playerList;

    private Board board;

    private String status;
    private Integer [] winningLine;
}
