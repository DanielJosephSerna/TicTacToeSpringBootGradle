package cognizant.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetUp {
    private List<People> peopleList;

    private TicTacToeBoard boardArr;

    private String status;
    private Integer countMoves;
    private Integer [] winningLine;
}
