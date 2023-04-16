package guessBean;

import java.util.ArrayList;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "guessBean")
@SessionScoped
/**
 * Backing-Bean of session for each user, for  "guess the number" game
 * @author Santiago Arévalo y Juan Sánchez
 *
 */
public class BackingBean {
	private int numberToGuess;
	private int attempts;
	private int currentPrize;
	private String gameState;
	private Random randomNumber;
	private ArrayList<Integer> lastAttempts;
	
	public BackingBean () {
		randomNumber = new Random();
		setNumberToGuess();
		attempts = 0;
		currentPrize = 100000;
		gameState = "No";
		lastAttempts = new ArrayList<Integer>();
	}

	/**
	 * Checks if user guesses the number
	 * @param numberAttempt the number attempted by user
	 */
	public void guess (int numberAttempt) {
		attempts++;
		if (numberToGuess == numberAttempt) {
			gameState = "Si, su premio es: " + String.valueOf(currentPrize);
		} else {
			currentPrize -= 10000;
			lastAttempts.add(numberAttempt);
		}
	}
	
	/**
	 * Restarts the game
	 */
	public void restart() {
		setNumberToGuess();
		attempts = 0;
		currentPrize = 100000;
		gameState = "No";
		lastAttempts.clear();
	}
	
	/**
	 * Sets the random number for the game
	 */
	private void setNumberToGuess() {
		numberToGuess = randomNumber.nextInt();
	}
	
	public int getNumberToGuess() {
		return numberToGuess;
	}
	
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getCurrentPrize() {
		return currentPrize;
	}

	public void setCurrentPrize(int currentPrize) {
		this.currentPrize = currentPrize;
	}

	public String getGameState() {
		return gameState;
	}

	public void setGameState(String gameState) {
		this.gameState = gameState;
	}

	public ArrayList<Integer> getLastAttempts() {
		return lastAttempts;
	}
	
}
