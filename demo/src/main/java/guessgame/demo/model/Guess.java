package guessgame.demo.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Guess {
    private String guess;

    @JsonCreator
    public Guess(@JsonProperty("guess") String guess) {
        this.guess = guess;
    }   

    public void setGuess(String guess) {
        this.guess = guess;
    }
    public String getGuess() {
        return guess;
    }
    
}
