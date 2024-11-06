package guessgame.demo.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List; 
import guessgame.demo.model.Color;
import guessgame.demo.model.Guess;
import guessgame.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameService GameService;
    private Color randomColor;

    @CrossOrigin
    @GetMapping("/getColors") 
    public List<Color> getColors() {
        return GameService.getColors();
    }
    
    @CrossOrigin
    @GetMapping("/start")
    public Color startGame() {
        randomColor = GameService.getRandomColor();
        GameService.resetCount();
        return randomColor;
    }

    @CrossOrigin
    @PostMapping("/guess")
    public ResponseEntity<String> guessColor(@RequestBody Guess guess) {
        System.out.println("Answer: " + guess);
        if (randomColor == null) {
            randomColor = GameService.getRandomColor();
        }
        return ResponseEntity.ok(GameService.checkGuess(guess.getGuess(), randomColor));
    }
}
