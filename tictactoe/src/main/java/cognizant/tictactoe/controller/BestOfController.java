package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.BestOf;
import cognizant.tictactoe.service.BestOfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/best-of")
@CrossOrigin
public class BestOfController {

    private final BestOfService bestOfService;

    public BestOfController(BestOfService bestOfService) { this.bestOfService = bestOfService; }

    @GetMapping("/human-human")
    public ResponseEntity<BestOf> setUpHumanHumanGame() {
        return new ResponseEntity<>(bestOfService.setUpHumanHumanGame(), HttpStatus.OK);
    }

    @GetMapping("/human-comp")
    public ResponseEntity<BestOf> setUpHumanCompGame() {
        return new ResponseEntity<>(bestOfService.setUpHumanCompGame(), HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<BestOf> performBestOf(@RequestBody BestOf bestOf) {
        return new ResponseEntity<>(bestOfService.performBestOf(bestOf), HttpStatus.OK);
    }


}
