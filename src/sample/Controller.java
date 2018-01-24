package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Random;


public class Controller {

    int GAME_LOW = 1;
    int GAME_HIGH = 10;

    int low = GAME_LOW;
    int high = GAME_HIGH;

    Random diceRoll = new Random();

    int randomlyPickedNumber = diceRoll.nextInt(high);
    int numOfTimesGuessed = 0;



    @FXML
    private Text greetingText;
    @FXML
    private Text askingForNumber;
    @FXML
    private Button enterNumber;
    @FXML
    private TextField userInput;
    @FXML
    private Text numberOfGuesses;
    @FXML
    private Button restartGame;


    public void numberEntered(ActionEvent actionEvent) {


        String userEntry = userInput.getText();
        int userIntEntry = Integer.parseInt(userEntry);
        numOfTimesGuessed++;


        askingForNumber.setText("Please guess a number between " + low + " and " + high);
        userInput.clear();


        if (userIntEntry > randomlyPickedNumber) {
            askingForNumber.setText("TOO HIGH.");
            high = userIntEntry;
            greetingText.setText(low + " and " + high);
            numberOfGuesses.setText("Guess: " + numOfTimesGuessed);

        }

        if (userIntEntry < randomlyPickedNumber) {
            askingForNumber.setText("TOO LOW.");
            low = userIntEntry;
            greetingText.setText(low + " and " + high);
            numberOfGuesses.setText("Guess: " + numOfTimesGuessed);
        }

        if (userIntEntry == randomlyPickedNumber) {
            askingForNumber.setText("MATCH!!!");
            numberOfGuesses.setText("It took " + numOfTimesGuessed + " guesses to find the correct number.");
            greetingText.setText("Click 'Restart' to play again?");

        }

    }

    public void restartedGame(ActionEvent actionEvent) {
        randomlyPickedNumber = diceRoll.nextInt(10);
        numOfTimesGuessed = 0;
        askingForNumber.setText("Please guess a number between " + 1 + " and " + 10);
        greetingText.setText("New Game");
    }
}