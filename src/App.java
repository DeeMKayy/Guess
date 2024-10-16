import java.util.ArrayList;
public class App {
    public static void main(String[] args) {
        ArrayList<Color> colors = new ArrayList<>();

        colors.add(new Color("Pink", "I'm just a girl \u1F97A"));
        colors.add(new Color("Blue", "Bro, the sky? \u1F644"));
        colors.add(new Color("Purple", "Prince advices you on an umbrella \\u2614"));
        colors.add(new Color("Yellow", "Patrick loves him, Squidward can't stand him \\U0001F9FD"));
        colors.add(new Color("Green", "It can be money, it can be food, it can be on every tree you see \\U0001F440"));
        
        for (Color color : colors) {
            System.out.println(color.getName());
        }

        int randomIndex = (int)(Math.random() * colors.size());
        Color randomColor = colors.get(randomIndex);
        System.out.println("Random Color Name: " + randomColor.getName());

        Input input = new Input();
        String guess = input.getGuess().toLowerCase();
        String hint = randomColor.getHint();
        String color = randomColor.getName().toLowerCase();
        for (int i = 0; i < input.getCount(); i++) {
            if (!guess.equals(color)) {
                System.out.println("Try Again! \\U+1F61D");
                input.incCount();
                //input.getGuess();
                guess = input.getGuess().toLowerCase();
                System.out.println(input.getCount());

                if (input.getCount() > 2) {
                    System.out.println(hint);
                    input.incCount();
                    //input.getGuess(); 
                    guess = input.getGuess().toLowerCase();
                }
            } else {
                System.out.println("Congrats! You Guessed Right! \\U+1F389 \\U+1F973");
                System.out.println(input.getCount());

            } 
        }


    }
}

