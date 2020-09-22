package cognizant.tictactoe.controller;

import cognizant.tictactoe.constants.GameConst;
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

/*    @PostMapping("/human-move")
    public ResponseEntity<Game> playHuman(@RequestBody Game game) {
        if(game.getPlayerList().get(0).getType().equals(PlayerConst.HUMAN1)
        && game.getPlayerList().get(1).getType().equals(PlayerConst.HUMAN2)) {

        } else if(game.getPlayerList().get(0).getType().equals(PlayerConst.HUMAN2)
        && game.getPlayerList().get(1).getType().equals(PlayerConst.HUMAN1)) {

        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }*/

    @PostMapping("/human-computer")
    public ResponseEntity<Game> playHumanAndComputerMoves(Game game) {
        Game tempGame = playService.performHumanBeforeComputerMove(game);
        if(tempGame.getStateOfPlay().equals(GameConst.OVER)) {
            return new ResponseEntity<>(tempGame, HttpStatus.OK);
        }

        tempGame = playService.performComputerAfterHumanMove(game);

        return new ResponseEntity<>(tempGame, HttpStatus.OK);
    }

    @PostMapping("/computer-move")
    public ResponseEntity<Game> playComputer(@RequestBody Game game) {
        if(game.getPlayerList().get(0).equals(PlayerConst.HUMAN1)
        && game.getPlayerList().get(1).equals(PlayerConst.COMPUTER)) {
            Game tempGame = playService.performHumanBeforeComputerMove(game);
        } else if(game.getPlayerList().get(0).equals(PlayerConst.COMPUTER)
        && game.getPlayerList().get(1).equals(PlayerConst.HUMAN1)) {

        }

        return new ResponseEntity<>(game, HttpStatus.OK);
    }

/*    @PostMapping("/move")
    public ResponseEntity<Game> playHumanMove(@RequestBody Game game) {

        // When human1 is first in the game and opponent computer
        if(game.getPlayerList().get(PlayerConst.ZERO).getType().equals(PlayerConst.HUMAN1)
        && game.getPlayerList().get(PlayerConst.ONE).getType().equals(PlayerConst.COMPUTER)) {

            Game afterMove = playService.makeHumanMove(game);

            afterMove = playService.checkWin(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.WINNER)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            afterMove = playService.checkTie(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.TIE)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            afterMove = playService.makeComputerMove(afterMove);

            afterMove = playService.checkWin(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.WINNER)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            afterMove = playService.checkTie(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.TIE)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            return new ResponseEntity<>(afterMove, HttpStatus.OK);

            // When computer is first in the game and opponent human1
        } else if(game.getPlayerList().get(PlayerConst.ZERO).getType().equals(PlayerConst.COMPUTER)
                && game.getPlayerList().get(PlayerConst.ONE).getType().equals(PlayerConst.HUMAN1)) {

            Game afterMove = playService.makeComputerMove(game);

            afterMove = playService.checkWin(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.WINNER)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            afterMove = playService.checkTie(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.TIE)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            afterMove = playService.makeHumanMove(afterMove);

            afterMove = playService.checkWin(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.WINNER)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            afterMove = playService.checkTie(afterMove);

            if(afterMove.getStateOfPlay().equals(GameConst.TIE)) {
                return new ResponseEntity<>(afterMove, HttpStatus.OK);
            }

            return new ResponseEntity<>(afterMove, HttpStatus.OK);

            // When human1 is first in the game and opponent human2
        } *//*else if(game.getPlayerList().get(PlayerConst.ZERO).getType().equals(PlayerConst.HUMAN1)
                && game.getPlayerList().get(PlayerConst.ONE).getType().equals(PlayerConst.HUMAN2)) {

            // When human2 is first in the game and opponent human1
        } else if(game.getPlayerList().get(PlayerConst.ZERO).getType().equals(PlayerConst.HUMAN2)
                && game.getPlayerList().get(PlayerConst.ONE).getType().equals(PlayerConst.COMPUTER)) {

        }*//*
        return new ResponseEntity<>(game, HttpStatus.OK);
    }*/
}
