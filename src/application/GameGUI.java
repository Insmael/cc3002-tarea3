package application;
	
import java.util.Observable;
import java.util.Observer;

import controller.FXController;
import controller.IController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.IGameLogic;
import model.UnoLogic;
import model.card.deck.NormalUnoDeck;
import model.player.IPlayerListBuilder;
import model.player.UnoPlayerListBuilder;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import model.player.type.RandomPlayer;
import view.FXView;
import view.card.CardImages;
import view.javafx.HandSection;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text; 
import javafx.scene.layout.VBox; 

public class GameGUI extends Application implements Observer{
	@Override
	public void start(Stage primaryStage) {
		try {
			
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
			FXView fxview = new FXView(game);
			IController controler = new FXController(game, fxview);
			
			
			Scene scene = new Scene(fxview.getData(),800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			while (!game.hasEnded()) {
				controler.playTurn();
			    }
			    game.announceWinner(controler);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update(Observable arg0, Object updtMssg) {
		UpdateMessage updateMessage = (UpdateMessage) updtMssg; 
		
	}
	
}
