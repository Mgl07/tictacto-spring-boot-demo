package com.project.game.tictactoe.DemoSpringBootTicTacToe.contoller;

import com.project.game.tictactoe.DemoSpringBootTicTacToe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/gametictactoe")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Inicia un nuevo juego
    @PostMapping("/start")
    public String startGame(@RequestParam int gameType, @RequestParam int size) {
        try {
            gameService.startGame(gameType, size);
            return "Game started successfully.";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    @PostMapping("/move")
    public String playerMovement(@RequestParam String row, @RequestParam String col) {
        try {

            boolean gameOver = gameService.movement(row, col);

            if (gameOver) {
                return "Game over!";
            } else {
                return "Move made. Next turn.";
            }
        } catch (IllegalStateException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/board")
    public void getBoardState() {
       gameService.getStatusBoard();
    }
}