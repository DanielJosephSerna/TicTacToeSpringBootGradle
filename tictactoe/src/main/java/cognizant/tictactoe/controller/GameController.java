package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setup-game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(value="/human-computer")
    public ResponseEntity<Game> buildHumanComputerGame() {
        return new ResponseEntity<>(gameService.setUpHumanComputerGame(), HttpStatus.OK);
    }

    @GetMapping(value="/computer-human")
    public ResponseEntity<Game> buildComputerHumanGame() {
        return new ResponseEntity<>(gameService.setUpComputerHumanGame(), HttpStatus.OK);
    }

    @GetMapping(value="/human-human")
    public ResponseEntity<Game> buildHumanHumanGame() {
        return new ResponseEntity<>(gameService.setUpHumanHumanGame(), HttpStatus.OK);
    }
}
