package test.javafx;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.card.CompositeCardPile;
import model.card.ICardPile;
import model.card.deck.IDeckStrategy;
import model.card.deck.NormalUnoDeck;
import model.card.type.ICard;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import view.card.CardImages;
import view.javafx.HandSection;
/* clase que solo presenta la sección de la mano, de modo que aquí es donde 
 * se mantienen las pruebas para asegurar que esta sección funcione. 
 */
public class HandSectionTest extends Application {
  
	@Override     
	public void start(Stage primaryStage) throws Exception {            
		
		
		CardImages cardViews = new CardImages();
		HandSection handSection = new HandSection(cardViews);
		IPlayer player = new HumanPlayer("jugador de prueba");
		IDeckStrategy deckBuilder = new NormalUnoDeck();
		ICardPile deck = new CompositeCardPile();
		deck.pushCards(deckBuilder.createDeck());
		ArrayList<ICard> cardsToHand = new ArrayList<ICard>();
		for (int i = 0; i< 7; i++) {			
			cardsToHand.add(deck.popCard());
		}
		player.addToHand(cardsToHand);
		handSection.updatePlayerHand(player);
		
		
		Scene scene = new Scene(handSection.getData(),600, 300);
		
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent e) {
	        	player.getHand().clear();
	        	deck.pushCards(deckBuilder.createDeck());
	     		ArrayList<ICard> cardsToHand = new ArrayList<ICard>();
	     		for (int i = 0; i< 7; i++) {			
	     			cardsToHand.add(deck.popCard());
	     		}
	     		cardsToHand.removeIf(card->!card.isDiscardable());
	     		player.addToHand(cardsToHand);
	     		handSection.updatePlayerHand(player);
	         } 
	      });

		//Setting the title to Stage. 
		primaryStage.setTitle("Hand Section Test"); 
		
		//Adding the scene to Stage 
		primaryStage.setScene(scene); 
		
		//Displaying the contents of the stage 
		primaryStage.show(); 
	}    
	public static void main(String args[]){          
		launch(args);     
	}         
}
