package view;

import javafx.scene.layout.BorderPane;
import model.IGameLogic;
import model.card.type.ICard;
import view.card.CardImages;
import view.javafx.CardPilesBar;
import view.javafx.HandSection;
import view.javafx.ICardPilesBar;
import view.javafx.IPlayersBar;
import view.javafx.PlayersBar;
import view.messageWindow.TextMessageWindow;

public class FXView {
	IGameLogic game;
	CardImages cardViews;
	ICardPilesBar cardPilesBar;
	HandSection handSection;
	IPlayersBar playersBar;
	BorderPane root;
	boolean waiting;
	private int cardNum;

	public FXView(IGameLogic game) {
		this.game = game; 
		cardViews = new CardImages();
		cardPilesBar = new CardPilesBar(game, this, cardViews);
		handSection = new HandSection(game, this, cardViews);
		playersBar = new PlayersBar(game);
		waiting = true;
		cardNum = -1;
		
		root = new BorderPane();
	    	    
	    root.setTop(playersBar.getData());
	    root.setCenter(cardPilesBar.getData());
	    root.setBottom(handSection.getData());
	    updateAll();
	}



	public void showMessage(String message) {
		TextMessageWindow popUp = new TextMessageWindow();
		popUp.defineTitle("popUp window");
		popUp.definePrincipal(message);
		popUp.defineSecondary("el mensaje secundario");
		popUp.create();
		popUp.show();
	}
	
	public BorderPane getData() {
		return root;
	}
	
	public void updateAll() {
		cardPilesBar.update();
		playersBar.update();
		handSection.updatePlayerHand(game.getCurrentPlayer());
	}



	public boolean isWaitingForCard() {
		return waiting;
	}



	public int getCardNum() {
		return cardNum;
	}



	public void setWaitingForCard() {
		waiting = true;
		
	}
	
	public void setCardNum(int num) {
		cardNum = num;
	}



	public void notWaitingForCard() {
		waiting = false;
		
	}

}
