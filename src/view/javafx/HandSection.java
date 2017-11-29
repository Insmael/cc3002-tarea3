package view.javafx;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.IGameLogic;
import model.card.type.ICard;
import model.player.type.IPlayer;
import view.FXView;
import view.card.CardImages;

/**
 * @author ismael
 * a class that handle the work of showing the hand of the player in the fxview
 *  of the game, showing seven cards at a time, and with two buttons to move
 *  and see the other cards in the hand.
 */
public class HandSection {
	private HBox data;
	private CardImages images;
	private IGameLogic game;
	private FXView view;
	
	/**
	 * the constructor of the class, it has as a parameter a cardImage class,
	 * from where it takes the differents images to make the imageview of 
	 * each card of the hand.
	 * @param game 
	 * @param fxView 
	 * @param cardImages a CardImages object
	 */
	public HandSection(IGameLogic game, FXView fxView, CardImages cardImages) {
		this.view = fxView;
		this.game = game;
		data = new HBox();
		images = cardImages;
	}
	
	public void showPlayerHand(IPlayer player) {
		// vaciar el nodo HBox para guardar la nueva mano.
		data.getChildren().clear();
		// para cada carta.
		
		ArrayList<ICard> hand = player.getHand();
		for (int i = 0; i < hand.size(); i++) {
			int j = i;
			ICard card = hand.get(i);
			// conseguir la imageview de la carta.
			ImageView cardView = images.getView(card.toString());
			//ajustar la imageview.
			cardView.setFitHeight(100);
			cardView.setPreserveRatio(true);
			cardView.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					if (!game.hasEnded()) {
							System.out.println(j);
						}
						view.updateAll();
					
				}
				
			});
			// agregarla al HBox data para su posterior uso.
			data.getChildren().add(cardView);
		}
	}
	
	/**
	 * a method that, given a player, it generate the view of his hand, showing
	 * seven cards at a time, and saving the view internaly, overwriting any 
	 * other view saved before. To get the view, use getData() method.
	 * @param player the player from wich the hand is rendered.
	 */
	public void updatePlayerHand(IPlayer player) {
		showPlayerHand(player);
	}
	
	/**
	 * gives the view of the hand of the player that is stored internaly.
	 * @return the representation of the hand that is saved internaly.
	 */
	public HBox getData() {
		return data;
	}
}
