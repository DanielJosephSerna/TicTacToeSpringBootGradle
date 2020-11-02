package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.PeopleConst;
import cognizant.tictactoe.model.BestOf;
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
    public ResponseEntity<BestOf> performMove(@RequestBody BestOf bestOf) {

        if(bestOf.getSetUp().getPeopleList().get(1).getType().equals(PeopleConst.COMPUTER)) {

            bestOf = moveService.performMove(bestOf);

            if(bestOf.getSetUp().getStatus().equals("ONGOING")) {

                bestOf = moveService.performMove(bestOf);
            }

        } else {
            bestOf = moveService.performMove(bestOf);
        }

        return new ResponseEntity<>(bestOf, HttpStatus.OK);
    }

}
