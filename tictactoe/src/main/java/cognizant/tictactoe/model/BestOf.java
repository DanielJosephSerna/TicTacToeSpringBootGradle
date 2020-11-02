package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestOf {
    private SetUp setUp;

    private Integer totalGamesToPlay;
    private Integer score1;
    private Integer score2;
}
