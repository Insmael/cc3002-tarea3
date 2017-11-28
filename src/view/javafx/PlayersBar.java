package view.javafx;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.IGameLogic;
import model.player.Direction;
import model.player.type.IPlayer;

public class PlayersBar implements IPlayersBar {
	private GridPane grid;
	private ArrayList<IPlayer> players;
	private ArrayList<Text> playerNodes;
	private ArrayList<Text> handSizes;
	private ArrayList<Text> directions;
	private IGameLogic game;
	
	public PlayersBar(IGameLogic game) {
		grid = new GridPane();
		this.game = game;
		players = game.getPlayers();
		playerNodes = new ArrayList<Text>();
		handSizes = new ArrayList<Text>();
		directions = new ArrayList<Text>();
		makePlayerNodes();
		update();
		
	}
	
	private void fillgrid() {
		grid.getChildren().clear();
		grid.add(playerNodes.get(0), 0, 1);
		grid.add(handSizes.get(0), 0, 2);
		int j = 1;
		for (int i = 1; i < playerNodes.size(); i++) {
			
			grid.add(directions.get(i), j++, 1);
			grid.add(playerNodes.get(i), j, 1);
			grid.add(handSizes.get(i), j++, 2);
		}
		int index = players.indexOf(game.getCurrentPlayer());
		grid.add(new Text("Current Player"), index*2, 0);
		
	}

	private void makePlayerNodes() {
		for (@SuppressWarnings("unused") IPlayer player : players) {
			playerNodes.add(new Text());
			handSizes.add(new Text());
			directions.add(new Text("<"));
		}
	}
	
	@Override
	public void update() {
		directions.clear();
		for (int i = 0; i < players.size(); i++) {
			playerNodes.get(i).setText(players.get(i).toString());
			handSizes.get(i).setText("" + players.get(i).getHandSize()+ " Cards");
			if (game.getDirection() == Direction.CLOCKWISE)
				directions.add(new Text("<"));
			else
				directions.add(new Text(">"));
		}
		fillgrid();
	}

	@Override
	public Node getData() {
		return grid;
	}

}
