package view.card;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author ismael
 * clase que mantiene la relación entre carta y la imagen de aquella carta
 * la implementación consiste en un diccionario que tiene por llave la  
 * representación de string de la carta, y por valor tiene la imagen como
 * ImageView, clase de javafx.
 */
public class CardImages {
	//diccionario con los pares color+tipoCarta y imagenCarta.
	private HashMap<String,Image> dictionary;
	
	//inicializador del diccionario.
	/**
	 * Constructor de la clase, lee todos los archivos de imagenes de cartas
	 * que van a ser usadas durante un juego, almacenandolas en el dictionary.
	 */
	public CardImages() {
		//inicializar el diccionario.
		dictionary = new HashMap<String,Image>();
		
		//declarar el inputstream
		FileInputStream inputStream;
		
		//declarar e inicializar las representaciones en string de las cartas,
		//los colores y los tipoes de carta.
		ArrayList<String> colors = new ArrayList<String>();
		ArrayList<String> numbersAndSpecials = new ArrayList<String>();
		ArrayList<String> comodins = new ArrayList<String>();
		
		//llenar los colores y los tipos de carta.
		colors.add("blue");
		colors.add("green");
		colors.add("red");
		colors.add("yellow");
		
		numbersAndSpecials.add("0");
		numbersAndSpecials.add("1");
		numbersAndSpecials.add("2");
		numbersAndSpecials.add("3");
		numbersAndSpecials.add("4");
		numbersAndSpecials.add("5");
		numbersAndSpecials.add("6");
		numbersAndSpecials.add("7");
		numbersAndSpecials.add("8");
		numbersAndSpecials.add("9");
		numbersAndSpecials.add("block");
		numbersAndSpecials.add("draw_2");
		numbersAndSpecials.add("reverse");
		numbersAndSpecials.add("star");
		
		comodins.add("wild_draw_4");
		comodins.add("wild_star");
		comodins.add("wild");
		
		//para cada color.
		for (String color : colors) {
			//para cada tipo de carta.
			for (String type: numbersAndSpecials) {
				//armar el nombre
				String name = type +" "+ color;
				try {
					//enlazar el archivo correspondiente con el inputStream.
					inputStream = open("assets/UnoCards/"+ color +"/"+type+".png");
					//agregar el par nombre - vista de imagen al diccionario.
					dictionary.put(name, new Image(inputStream));
					//cerrar el enlace.
					inputStream.close();
				} catch (FileNotFoundException e) {
					System.out.println("no se pudo abrir la imagen de la carta "+color+" "+type);
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("no se pudo cerrar la imagen de la carta "+color+" "+type);
					e.printStackTrace();
				}
				
			}
		}
		//para los comodines
		for (String type: comodins) {
			try {
				//enlazar el archivo correspondiente con el inputStream.
				inputStream = open("assets/UnoCards/none/"+type+".png");
				//agregar el par nombre - vista de imagen al diccionario.
				dictionary.put(type+" none", new Image(inputStream));
				//cerrar el enlace.
				inputStream.close();
			} catch (FileNotFoundException e) {
				System.out.println("no se pudo abrir la imagen de la carta "+type);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("no se pudo cerrar la imagen de la carta "+type);
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * @param card la representación en string de la carta a la cual se le 
	 * busca su ImageView
	 * @return la ImageView de la carta
	 */
	public ImageView getView(String card){
		return new ImageView(dictionary.get(convertToKey(card)));
	}
	
	private FileInputStream open(String path) throws FileNotFoundException {
		return new FileInputStream(path);
	}
	
	private String convertToKey(String card) {
		String key = card;
		key = key.replace("Sin Color", "none");
		key = key.replace("Azul", "blue");
		key = key.replace("Verde", "green");
		key = key.replace("Rojo", "red");
		key = key.replace("Amarillo","yellow");
		key = key.replace("Saltar", "block");
		key = key.replace("Robar 2", "draw_2");
		key = key.replace("Invertir Dirección", "reverse");
		key = key.replace("Comodín + Roba 4", "wild_draw_4");
		key = key.replace("Comodín", "wild");
		//TODO darle una buena representación a los comodines usados.
		key = key.replace("Comodín usado", "wild");
		return key;
	}
}
