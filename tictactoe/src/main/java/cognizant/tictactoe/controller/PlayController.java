package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.service.PlayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/play")
public class PlayController {

    private final PlayService playService;

    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    @PostMapping("/human-computer")
    public ResponseEntity<Game> performHumanAndComputerMove(@RequestBody Game game) {
        return new ResponseEntity<>(playService.performHumanAndComputerMove(game), HttpStatus.OK);
    }
}
