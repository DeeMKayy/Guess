package guessgame.demo.service;

import guessgame.demo.Color;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    private List<Color> colors;
    private int count;

    public GameService() {
        colors = new ArrayList<>();
        colors.add(new Color("Pink", "I'm just a girl 🥺"));
        colors.add(new Color("Blue", "Bro, the sky? 🙄"));
        colors.add(new Color("Purple", "Prince advises you on an umbrella ☂️"));
        colors.add(new Color("Yellow", "Patrick loves him, Squidward can't stand him 🧽"));
        colors.add(new Color("Green", "It can be money, it can be food, it can be on every tree you see 👀"));
        this.count = 0;
    }

    public List<Color> getColors() {
        return colors;
    }

    public Color getRandomColor() {
        Random random = new Random();
        return colors.get(random.nextInt(colors.size()));
    }

    public String checkGuess(String guess, Color color) {
        if (guess.equalsIgnoreCase(color.getName())) {
            return "Congrats! You guessed right! 🎉🥳";
        } else {
            count++;
            if (count > 2) {
                return "Try Again! 😝 Hint: " + color.getHint();
            }
            return "Try Again! 😝";
        }
    }

    public void resetCount() {
        this.count = 0;
    }
}