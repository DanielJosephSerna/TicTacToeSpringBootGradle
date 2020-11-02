package cognizant.tictactoe.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String type;
    private String piece;
    private int move;

}
