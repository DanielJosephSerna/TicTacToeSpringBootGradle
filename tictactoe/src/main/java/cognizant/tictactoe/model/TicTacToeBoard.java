package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicTacToeBoard {

    private Character [][] boardArr;
    private Integer peopleMove;

}
