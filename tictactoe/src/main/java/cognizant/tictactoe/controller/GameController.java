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
        return new ResponseEntity<>(gameService.buildGameHumanComputer(), HttpStatus.OK);
    }
}
