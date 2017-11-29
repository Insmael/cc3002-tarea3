package view.messageWindow;

import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextMessageWindow {
	protected Stage stage = new Stage();
	protected Group root = new Group();
	
	public void defineTitle(String title) {
		stage.setTitle(title);
	}
	
	public void definePrincipal(String text) {
		Text textMessage = new Text();
		textMessage.setText(text);
		textMessage.setX(50);
		textMessage.setY(40);
		textMessage.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		root.getChildren().add(textMessage);
	}
	
	public void defineSecondary(String text) {
		Text textMessage = new Text();
		textMessage.setText(text);
		textMessage.setX(50);
		textMessage.setY(90);
		textMessage.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.ITALIC, 15));
		root.getChildren().add(textMessage);
	}
	
	public void generateOkBotton() {
		//Creating play button 
	      Button okButton = new Button("Ok"); 
	      okButton.setLayoutX(235); 
	      okButton.setLayoutY(105); 
	      okButton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	          public void handle(MouseEvent event) {   
	             stage.close();
	          } 
	       }));
	      root.getChildren().add(okButton);
	}
	
	public void generateLine() {
		//Creating a line object 
	      Line line = new Line(); 
	         
	      //Setting the properties to a line 
	      line.setStartX(50.0); 
	      line.setStartY(70.0); 
	      line.setEndX(250.0); 
	      line.setEndY(70.0);
	
	      root.getChildren().add(line);
	}
	
	public void create() {
		generateOkBotton();
		generateLine();
		Scene scene = new Scene(root, 400, 200);
		stage.setScene(scene);
	}
	
	public void show() {
		stage.showAndWait();
	}

}
