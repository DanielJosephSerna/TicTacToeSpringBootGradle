package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setup-game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value="/human-computer", produces="application/json")
    public ResponseEntity<Game> buildGame() {
        // set up players
        Game game = new Game();
        game = gameService.setUpPlayers(game);

        // set up board
        game = gameService.setUpBoard(game);
/*        String testBord [][] = game.getBoard().getBoardArr();
        System.out.println(testBord);
        System.out.println(testBord[4][0]+""+testBord[4][1]+""+testBord[4][2]+""+testBord[4][3]+""+testBord[4][4]);
        System.out.println(testBord[3][0]+""+testBord[3][1]+""+testBord[3][2]+""+testBord[3][3]+""+testBord[3][4]);
        System.out.println(testBord[2][0]+""+testBord[2][1]+""+testBord[2][2]+""+testBord[2][3]+""+testBord[2][4]);
        System.out.println(testBord[1][0]+""+testBord[1][1]+""+testBord[1][2]+""+testBord[1][3]+""+testBord[1][4]);
        System.out.println(testBord[0][0]+""+testBord[0][1]+""+testBord[0][2]+""+testBord[0][3]+""+testBord[0][4]);*/


        // set up
        game = gameService.setUpGame(game);

        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
