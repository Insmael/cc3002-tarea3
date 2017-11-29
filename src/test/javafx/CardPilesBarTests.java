package test.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.IGameLogic;
import model.UnoLogic;
import model.card.deck.NormalUnoDeck;
import model.card.type.ICard;
import model.player.IPlayerListBuilder;
import model.player.UnoPlayerListBuilder;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import model.player.type.RandomPlayer;
import view.card.CardImages;
import view.javafx.CardPilesBar;
import view.javafx.ICardPilesBar;

public class CardPilesBarTests extends Application {
	
	@Override     
	public void start(Stage primaryStage) throws Exception {            
		
		
		// creación de las clases que se testean
		
		
		// creación de los jugadores
		IPlayerListBuilder playerBuilder = new UnoPlayerListBuilder();
	    IPlayer p1 = new HumanPlayer("Jugador 1");
	    IPlayer p2 = new RandomPlayer("CPU 1");
	    IPlayer p3 = new RandomPlayer("CPU 2");
	    IPlayer p4 = new RandomPlayer("CPU 3");
	    playerBuilder.addPlayer(p1);
	    playerBuilder.addPlayer(p2);
	    playerBuilder.addPlayer(p3);
	    playerBuilder.addPlayer(p4);
	    IGameLogic game = new UnoLogic(playerBuilder, new NormalUnoDeck());
		
		//crear la barra de status de los jugadores
	    CardImages cardViews = new CardImages();
		ICardPilesBar cardPilesBar = new CardPilesBar(game, null, cardViews);
		
		//create 
	    BorderPane root = new BorderPane();
	    Button playcard = new Button("play a card");
	    Button drawCard= new Button("draw a card");
	    
	    
	    drawCard.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {   
	           game.drawOneCard(p1);
	           cardPilesBar.update();
	        } 
	    });
	    
	    playcard.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		for (ICard card: p1.getHand()) {
		           if (card.isPlayableOver(game.getCurrentPlayedCard())){
		        	   game.playCard(card, null);
		           }
	    		}
	    		cardPilesBar.update();
	        } 
	    });
	    root.setTop(cardPilesBar.getData());
	    root.setLeft(playcard);
	    root.setRight(drawCard);
	    
	    //Creating a Scene by passing the group object, height and width   
	    Scene scene = new Scene(root ,600, 300);
		

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
