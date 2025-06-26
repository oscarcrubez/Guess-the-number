package com.game.backend.controller;

import com.game.backend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public Map<String, String> startGame() {
        gameService.startNewGame();
        return Map.of("message", "New game started!");
    }

    @PostMapping("/guess")
    public Map<String, String> guess(@RequestBody Map<String, Integer> payload) {
        int guess = payload.get("guess");
        String result = gameService.checkGuess(guess);
        return Map.of("result", result);
    }

}