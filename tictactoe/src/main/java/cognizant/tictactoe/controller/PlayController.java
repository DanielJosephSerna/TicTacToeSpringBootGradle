package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.service.PlayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/play")
@CrossOrigin
public class PlayController {

    private final PlayService playService;

    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    @PostMapping("/human-computer")
    public ResponseEntity<Game> performHumanAndComputerMove(@RequestBody Game game) {
        return new ResponseEntity<>(playService.performHumanAndComputerMove(game), HttpStatus.OK);
    }

    @PostMapping("/human-human")
    public ResponseEntity<Game> performHumanAndHumanMove(@RequestBody Game game) {
        return new ResponseEntity<>(playService.performHumanAndHumanMove(game), HttpStatus.OK);
    }
}
