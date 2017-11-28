package view.javafx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.IGameLogic;
import veiw.javafx.ICardPilesBar;
import view.card.CardImages;

public class CardPilesBar implements ICardPilesBar {
	private GridPane grid;
	private IGameLogic game;
	private CardImages views;
	private ImageView mazo;
	
	public CardPilesBar(IGameLogic game, CardImages cardViews) {
		grid = new GridPane();
		grid.setMaxSize(40, 40);
		this.game = game;
		this.views = cardViews;
		
		FileInputStream inputStream;
		try {
			//enlazar el archivo correspondiente con el inputStream.
			inputStream = new FileInputStream("assets/UnoCards/blue/0.png");
			mazo = new ImageView(new Image(inputStream));

			mazo.setFitHeight(100);
			mazo.setPreserveRatio(true);
			mazo.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					game.drawOneCard(game.getCurrentPlayer());
					update();
					
				}
				
			});
			//cerrar el enlace.
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("no se pudo abrir la imagen de la carta ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("no se pudo cerrar la imagen de la carta ");
			e.printStackTrace();
		}
		update();
		
		
	}

	@Override
	public void update() {
		grid.getChildren().clear();
		ImageView discardPile = views.getView(game.getCurrentPlayedCard().toString());
		discardPile.setFitHeight(100);
		discardPile.setPreserveRatio(true);
		grid.add(discardPile, 0, 0);
		grid.add(new Text(""+game.getDiscardPileSize()), 0, 1);
		grid.add(mazo, 1, 0);
		grid.add(new Text(""+game.getActualDeckSize()), 1, 1);
		
		
	}

	@Override
	public Node getData() {
		return grid;
	}

}
