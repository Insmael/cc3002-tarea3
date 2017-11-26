package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import view.card.CardImages;
import view.javafx.HandSection;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text; 
import javafx.scene.layout.VBox; 

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			CardImages cardViews = new CardImages();
			HandSection handSection = new HandSection(cardViews);
			//---Creando los objetos de texto que representan cada parte de la interfaz gráfica.---
			//Creando los objetos de texto de la primera sección.
			Text currentPlayer = new Text();
			Text player1 = new Text();
			Text player2 = new Text();
			Text player3 = new Text();
			Text player4 = new Text();
			Text xCardsOfP1 = new Text();
			Text xCardsOfP2 = new Text();
			Text xCardsOfP3 = new Text();
			Text xCardsOfP4 = new Text();
			Text secuenciaTurnos1 = new Text();
			Text secuenciaTurnos2 = new Text();
			Text secuenciaTurnos3 = new Text();
			
			//Creando los objetos de texto de la segunda sección.
			Text pilaDescarte = new Text();
			Text mazo = new Text();
			Text xCardsInPilaDescarte = new Text();
			Text xCardsInMazo = new Text();
			
			//Creando los objetos de texto de la tercera y última sección.
			Text boton1 = new Text();
			Text boton2 = new Text();
			Text carta1 = new Text();
			Text carta2 = new Text();
			Text carta3 = new Text();
			Text carta4 = new Text();
			Text carta5 = new Text();
			Text carta6 = new Text();
			Text carta7 = new Text();
			
			
			//---Estableciendo los textos en los objetos de textos.---
			//Ajustando los textos de la primera seccion.
			currentPlayer.setText("jugador Actual");
			player1.setText("jugador 1");
			player2.setText("jugador 2");
			player3.setText("jugador 3");
			player4.setText("jugador 4");
			xCardsOfP1.setText("x cartas de P1");
			xCardsOfP2.setText("x cartas de P2");
			xCardsOfP3.setText("x cartas de P3");
			xCardsOfP4.setText("x cartas de P4");
			secuenciaTurnos1.setText("secuencia de turnos");
			secuenciaTurnos2.setText("secuencia de turnos");
			secuenciaTurnos3.setText("secuencia de turnos");
			
			//Ajustando los textos de la segundoa sección.
			pilaDescarte.setText("pila de descarte");
			mazo.setText("mazo");
			xCardsInPilaDescarte.setText("x cartas en PD");
			xCardsInMazo.setText("x cartas en M");
			
			//Ajustando los textos de la tercera sección.
			boton1.setText("boton1");
			boton2.setText("boton2");
			carta1.setText("carta 1");
			carta2.setText("carta 2");
			carta3.setText("carta 3");
			carta4.setText("carta 4");
			carta5.setText("carta 5");
			carta6.setText("carta 6");
			carta7.setText("carta 7");
			
			
			//---Creado y llenado de los contenedores de las secciónes.
			
			//Creando los contenedores de las secciones.
			GridPane seccion1 = new GridPane();
			seccion1.setAlignment(Pos.CENTER);
			GridPane seccion2 = new GridPane();
			seccion2.setAlignment(Pos.CENTER);
			GridPane seccion3 = new GridPane();
			seccion3.setAlignment(Pos.CENTER);
			
			
			//Llenando el contenedor de la seccion 1.
			seccion1.add(currentPlayer, 0, 0);
			seccion1.add(player1, 0, 1);
			seccion1.add(xCardsOfP1, 0, 2);
			seccion1.add(secuenciaTurnos1, 1, 1);
			seccion1.add(player2, 2, 1);
			seccion1.add(xCardsOfP2, 2, 2);
			seccion1.add(secuenciaTurnos2, 3, 1);
			seccion1.add(player3, 4, 1);
			seccion1.add(xCardsOfP3, 4, 2);
			seccion1.add(secuenciaTurnos3, 5, 1);
			seccion1.add(player4, 6, 1);
			seccion1.add(xCardsOfP4, 6, 2);
			
			//Llenando el contenedor de la seccion 2.
			seccion2.add(pilaDescarte, 0, 0);
			seccion2.add(xCardsInPilaDescarte, 0, 1);
			seccion2.add(mazo, 1, 0);
			seccion2.add(xCardsInMazo, 1, 1);
			
			//Llenando el contenedor de la seccion 3.
			seccion3.add(boton1, 0, 0);
			seccion3.add(carta1, 1, 0);
			seccion3.add(carta2, 2, 0);
			seccion3.add(carta3, 3, 0);
			seccion3.add(carta4, 4, 0);
			seccion3.add(carta5, 5, 0);
			seccion3.add(carta6, 6, 0);
			seccion3.add(carta7, 7, 0);
			seccion3.add(boton2, 8, 0);
			ImageView card8 = cardViews.getView("0 Rojo");
			card8.setX(25);
			card8.setY(500);
			card8.setFitHeight(100); 
			card8.setPreserveRatio(true);
			seccion3.add(card8, 9, 0);
			
					    
		    
			
			VBox root = new VBox();
			root.setSpacing(10);
			root.setFillWidth(true);
			//Setting the margin to the nodes 
			root.setMargin(seccion1, new Insets(30, 30, 30, 30));  
		    root.setMargin(seccion2, new Insets(20, 20, 20, 20)); 
		    root.setMargin(seccion3, new Insets(20, 20, 20, 20));
			
		    root.setAlignment(Pos.CENTER);
		    root.getChildren().addAll(seccion1,seccion2,handSection.getData());
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
