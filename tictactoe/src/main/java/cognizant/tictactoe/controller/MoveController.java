package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.SetUp;
import cognizant.tictactoe.service.MoveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/move")
@CrossOrigin
public class MoveController {

    private final MoveService moveService;

    public MoveController(MoveService moveService) { this.moveService = moveService; }

    @PostMapping("/place-piece")
    public ResponseEntity<SetUp> performMove(@RequestBody SetUp setUp) {

        if(setUp.getPeopleList().get(1).getType().equals(PeopleConst.COMPUTER)) {

            setUp = moveService.performMove(setUp);

            if(setUp.getStatus().equals("ONGOING")) {

                setUp = moveService.performMove(setUp);
            }

        } else {
            setUp = moveService.performMove(setUp);
        }

        return new ResponseEntity<>(setUp, HttpStatus.OK);
    }

}
