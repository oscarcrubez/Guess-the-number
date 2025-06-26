package com.game.backend.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {

    Random r = new Random();
    private int secretNumber;

    public void startNewGame() {
        secretNumber = r.nextInt(101);
    }

    public String checkGuess(int guessNumber) {
        if (guessNumber < secretNumber) {
            return "too low";
        } else if (guessNumber > secretNumber) {
            return "too high";
        } else {
            return "correct";
        }
    }

}