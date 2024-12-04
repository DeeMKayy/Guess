package guessgame.demo.controller;
import java.util.HashMap;
import java.util.Map;
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

    @GetMapping("/")
    public String index() {
        return "index.html";
    }


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
    public ResponseEntity<Map<String, Object>> guessColor(@RequestBody Guess guess) {
        System.out.println("Answer: " + guess);
        /*if (randomColor == null) {
            randomColor = GameService.getRandomColor();
        }*/
        String result = GameService.checkGuess(guess.getGuess(), randomColor);
        boolean isCorrect = GameService.isCorrectGuess();
        System.out.println("Correct boolean: " + isCorrect);

        Map<String, Object> response = new HashMap<>();
        response.put("message", result);
        response.put("boolean", isCorrect);
        
        return ResponseEntity.ok(response);
    }
    @CrossOrigin
    @GetMapping("/reset")
    public Color resetGame() {
        GameService.resetGame();
        randomColor = GameService.getRandomColor();
        return randomColor;
    }
}
