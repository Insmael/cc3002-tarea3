package view.javafx;

import javafx.scene.Node;

public interface IPlayersBar {
	
	/**
	 * gives the node of the representation of the players bars
	 * made of javafx components.
	 * 
	 * @return the javafx Node with the grafics components of the player bar
	 */
	Node getData();

	void update();
}
