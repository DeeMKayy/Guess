package guessgame.demo.controller;

import guessgame.demo.model.Color;
import guessgame.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService GameService;
    private Color randomColor;

    @GetMapping("/getColors") 
    public List<Color> getColors() {
        return GameService.getColors();
    }
    
    @GetMapping("/start")
    public Color startGame() {
        randomColor = GameService.getRandomColor();
        GameService.resetCount();
        return randomColor;
    }

    @PostMapping("/guess")
    public String guessColor(@RequestParam String userGuess) {
        if (randomColor == null) {
            randomColor = GameService.getRandomColor();
        }
        return GameService.checkGuess(userGuess, randomColor);
    }
}
