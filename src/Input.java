import java.util.Scanner; 

public class Input {
    private Scanner scanner;
    private int count; 

    public Input() {
        scanner = new Scanner(System.in);
        this.count = 1;
    }

    public String getGuess() {
        System.out.print("Guess a color: ");
        return scanner.nextLine();
    }

    public int getCount() {
        return this.count;
    }

    public int incCount() {
       return this.count++;
    }

    public void closeScanner() {
        scanner.close();
    }
}
