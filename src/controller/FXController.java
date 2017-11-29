package controller;

import java.util.Scanner;

import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.player.type.IPlayer;
import view.FXView;

public class FXController implements IController {

	IGameLogic game;
	FXView view;
	Scanner in;

	/**
	 * Controller constructor. Initializes model, view, and input method. Also, it
	 * plays the card in discard pile.
	 * 
	 * @param game
	 * @param viewand
	 */
	public FXController(IGameLogic game, FXView view) {
		this.view = view;
		this.game = game;
		showMessage("¡Bienvenido a JavaUNO!");
		game.getCurrentPlayedCard().executeAction(game, this);
	}

	@Override
	public Color askForColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int AskForCardFromHand(IPlayer player) {
	    int num = -1;
	    view.updateAll();
	    while(num < 0 || num > player.getHandSize()) {
	    	num = in.nextInt();
	    }
	    num = view.getCardNum();
	    view.setWaitingForCard();
	    return num;
	  }

	@Override
	public void showMessage(String message) {
		view.showMessage(message);
		

	}

	@Override
	public void playTurn() {
		game.startTurn(this);
		view.updateAll();
		IPlayer currentPlayer = game.getCurrentPlayer();
		boolean cardPlayed = false;
		while (!cardPlayed) {
			ICard card = currentPlayer.getCardToPlay(game, this);
			cardPlayed = game.playCard(card, this);
		}
	}

	@Override
	public void updatePlayedCard() {
		view.updateAll();

	}

}
