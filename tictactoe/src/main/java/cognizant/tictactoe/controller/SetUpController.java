package cognizant.tictactoe.controller;

import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.service.SetUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setup")
@CrossOrigin
public class SetUpController {

    private final SetUpService setUpService;

    public SetUpController(SetUpService setUpService) { this.setUpService = setUpService; }

    @GetMapping("/human-computer")
    public ResponseEntity<SetUp> setUpHumanCompGame() {
        return new ResponseEntity<>(setUpService.setUpHumanCompGame(), HttpStatus.OK);
    }

    @GetMapping("/human-human")
    public ResponseEntity<SetUp> setUpHumanHumanGame() {
        return new ResponseEntity<>(setUpService.setUpHumanHumanGame(), HttpStatus.OK);
    }
}
