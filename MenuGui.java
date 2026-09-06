import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuGui extends Application{
  @Override
  // launch the application
    public void start(Stage primaryStage){
      primaryStage.setTitle("MENU GUI");
      // Main layout
      BorderPane pane = new BorderPane();
      // Text box
      TextArea textBox = new TextArea();
      textBox.setPromptText("Menu results."); 
      // create a menu
      Menu menu = new Menu("Menu");

      // create menuitems
      MenuItem date = new MenuItem("Display Date & Time");
      MenuItem file = new MenuItem("Save text file");
      MenuItem color = new MenuItem("Change color");
      MenuItem exit = new MenuItem("Exit");

      // add menu items to menu
      menu.getItems().add(date);
      menu.getItems().add(file);
      menu.getItems().add(color);
      menu.getItems().add(exit);

      // Create menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

      // menu on top
      pane.setTop(menuBar);
        
      // Put text box in the center
      pane.setCenter(textBox);

      Color greenHue = Color.rgb(0, 167, 0);
        // create events for menu items
        // action event
        //Display date and time
      date.setOnAction(event -> {
            LocalDateTime currentDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

            textBox.setText(currentDateTime.format(formatter));
        });

        // add event
        /*
        file.setOnAction(event);
        color.setOnAction(event);
        exit.setOnAction(event); */
     
      
        
       // Create scene
      Scene scene = new Scene(pane, 600, 400);

      primaryStage.setScene(scene);
      primaryStage.show();
    }

    public static void main(String[] args){
        // launch the application
        launch(args);
    }
}

