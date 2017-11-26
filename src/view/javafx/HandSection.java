package view.javafx;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.card.type.ICard;
import model.player.type.IPlayer;
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
	
	/**
	 * the constructor of the class, it has as a parameter a cardImage class,
	 * from where it takes the differents images to make the imageview of 
	 * each card of the hand.
	 * @param cardImages a CardImages object
	 */
	public HandSection(CardImages cardImages) {
		data = new HBox();
		images = cardImages;
	}
	
	public void showPlayerHand(IPlayer player) {
		// vaciar el nodo HBox para guardar la nueva mano.
		data.getChildren().clear();
		// para cada carta.
		for (ICard card : player.getHand()) {
			// conseguir la imageview de la carta.
			ImageView cardView = images.getView(card.toString());
			//ajustar la imageview.
			cardView.setFitHeight(100);
			cardView.setPreserveRatio(true);
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
