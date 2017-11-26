package view.javafx;

import model.IGameLogic;
import model.card.type.ICard;
import model.player.type.IPlayer;

public class JavaFXView {
	IGameLogic game;

	  /**
	   * Constructor of the view. Associates a game to it.
	   * 
	   * @param game
	   */
	  public JavaFXView(IGameLogic game) {
	    this.game = game;
	  }

	  /**
	   * Updates the current status of the game.
	   */
	  public void updateCurrentStatus() {
	    System.out.println("[Turno Actual]: " + game.getCurrentPlayer());
	  }

	  /**
	   * Shows a player's hand.
	   * 
	   * @param player player with the hand you need to show.
	   */
	  public void showPlayerHand(IPlayer player) {
	    System.out.println("[Mano]:");
	    int i = 0;
	    for (ICard card : player.getHand()) {
	      System.out.println(i + ") " + card);
	      i++;
	    }
	  }
	  
	  /**
	   * Shows a custom message in a pop up window.
	   * 
	   * @param message custom message
	   */
	  public void showMessage(String message) {
	  }

	  /**
	   * Shows the last card played.
	   * 
	   * @param player
	   * @param card
	   */
	  public void updatePlayedCard() {
	    System.out.println("[Carta Descartada]: " + game.getCurrentPlayedCard());
	  }
}
