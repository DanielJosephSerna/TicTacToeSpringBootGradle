package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PlayerConst;
import cognizant.tictactoe.model.Game;
import cognizant.tictactoe.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/play")
public class PlayController {

    @Autowired
    private PlayService playService;

    @PostMapping(value="/move", consumes="application/json", produces="application/json")
    public ResponseEntity<Game> playMove(@RequestBody Game game) {
        if(game.getPlayerList().get(0).getType().equals(PlayerConst.HUMAN1)) {
            System.out.println(game);
            Game afterHumanMove = playService.makeHumanVsComputerMove(game);
            System.out.println(afterHumanMove);
            return new ResponseEntity<>(afterHumanMove, HttpStatus.OK);
        }
        return null;
    }
}
