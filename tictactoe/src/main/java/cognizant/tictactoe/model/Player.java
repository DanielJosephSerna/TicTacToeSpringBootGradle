package cognizant.tictactoe.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Player {

    private String type;
    private String piece;
    private int xMove;
    private int yMove;

}
