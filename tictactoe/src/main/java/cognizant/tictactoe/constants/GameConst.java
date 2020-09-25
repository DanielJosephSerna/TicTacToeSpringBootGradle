package cognizant.tictactoe.constants;

public class GameConst {
    private GameConst() {}
    // state of the game: tie, winner, loser, ongoing
    public static final String TIE = "TIE";
    public static final String ONGOING = "ONGOING";
    public static final String OVER = "OVER";

    // type of game
    public static final String HUMAN_VS_HUMAN = "HUMAN VS HUMAN";
    public static final String HUMAN_VS_COMPUTER = "HUMAN VS COMPUTER";

    // empty string
    public static final String EMPTY = " ";
}
