package view.messageWindow;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SelectColorMessageWindow extends TextMessageWindow {
	public void makeColorChoiceBox() {
		//Choice box for color 
	    ChoiceBox<String> colorChoiceBox = new ChoiceBox<String>(); 
	    
	    colorChoiceBox.getItems().addAll("Rojo","Azul","Verde","Amarillo");
	    
	    Text colorLabel = new Text("Color");
	    
	    HBox hBox = new HBox();
	    hBox.getChildren().addAll(colorLabel, colorChoiceBox);
	    hBox.setSpacing(10);
	    hBox.setLayoutX(70);
	    hBox.setLayoutY(105);
	    root.getChildren().add(hBox);
	}
}
