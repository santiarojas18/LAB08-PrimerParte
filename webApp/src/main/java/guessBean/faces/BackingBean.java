package guessBean.faces;

import java.util.ArrayList;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import guessBean.data.Configuration;
import guessBean.data.ConfigurationService;


@Component
@ManagedBean
@ViewScoped
/**
 * Backing-Bean of session for each user, for  "guess the number" game
 * @author Santiago Arévalo y Juan Sánchez
 *
 */
public class BackingBean {
	@Autowired
	ConfigurationService configurationService;
	private int numberToGuess;
	private int attempts;
	private int currentPrize;
	private int dbReward;
	private String gameState;
	private Random randomNumber;
	private ArrayList<Integer> lastAttempts;
	
	public BackingBean () {
		restart();
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
	
	@Bean(name = "database")
    public CommandLineRunner run() throws Exception {
        return (args) -> {
            configurationService.addConfiguration(new Configuration("premio","200000"));
            dbReward = Integer.parseInt(configurationService.getValorOfPremio());
            setCurrentPrize(dbReward);
        };
    }

	
	/**
	 * Restarts the game
	 */
	public void restart() {
		randomNumber = new Random();
		lastAttempts = new ArrayList<Integer>();
		setNumberToGuess();
		attempts = 0;
		setCurrentPrize(dbReward);
		gameState = "No";
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
