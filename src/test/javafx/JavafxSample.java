package test.javafx;


import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;
import view.messageWindow.TextMessageWindow;  

public class JavafxSample extends Application { 
   @Override     
   public void start(Stage primaryStage) throws Exception {            
      //creating a Group object 
      Group group = new Group(); 
       
      //Creating a Scene by passing the group object, height and width   
      Scene scene = new Scene(group ,600, 300); 
      
      //setting color to the scene 
      scene.setFill(Color.BROWN);  
      
      //Setting the title to Stage. 
      primaryStage.setTitle("Sample Application"); 
   
      //Adding the scene to Stage 
      primaryStage.setScene(scene); 
      
      TextMessageWindow popUp = new TextMessageWindow();
      popUp.defineTitle("popUp window");
      popUp.definePrincipal("mensaje principal");
      popUp.defineSecondary("el mensaje secundario");
      popUp.create();
      //Displaying the contents of the stage 
      primaryStage.show();
      popUp.show();
   }    
   public static void main(String args[]){          
      launch(args);     
   }         
} 