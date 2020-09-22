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
    public ResponseEntity<Game> buildHumanComputerGame() {
        // set up players
        Game game = new Game();

        game = gameService.setUpPlayersHumanComputer(game);

        // set up board
        game = gameService.setUpBoard(game);

        // set up
        game = gameService.setUpGame(game);

        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping(value="/computer-human", produces="application/json")
    public ResponseEntity<Game> buildComputerHumanGame() {
        // set up players
        Game game = new Game();

        game = gameService.setUpPlayersComputerHuman(game);

        // set up board
        game = gameService.setUpBoard(game);

        // set up
        game = gameService.setUpGame(game);

        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
