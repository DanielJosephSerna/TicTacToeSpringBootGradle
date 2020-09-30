package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String type;
    private String piece;
    private int xMove;
    private int yMove;

}
