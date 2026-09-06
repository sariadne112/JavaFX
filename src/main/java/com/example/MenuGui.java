package com.example;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.geometry.Pos;

public class MenuGui extends Application{
  @Override
  // launch the application
    public void start(Stage primaryStage){
      primaryStage.setTitle("MENU GUI");
      // Main layout
      BorderPane pane = new BorderPane();
      // Text box
      TextField textBox = new TextField();
      textBox.setPromptText("Menu results."); 
      textBox.setMaxWidth(300);
      textBox.setAlignment(Pos.CENTER);
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
        // create events for menu items
        // action event
        //Display date and time
      date.setOnAction(event -> {
            LocalDateTime currentDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

            textBox.setText(currentDateTime.format(formatter));
        });

        // OPTION 2 - Save text to log.txt
        file.setOnAction(event -> {
          try {
                FileWriter writer = new FileWriter("log.txt");

                writer.write(textBox.getText());
                writer.close();
                textBox.appendText("\nSaved to log.txt");

            } catch (IOException exception) {
                textBox.appendText("\nError writing file.");
            }
        });

        // OPTION 3 - Change background color
        color.setOnAction(event -> {
          //Color
          int green = 100 + (int)(Math.random() * 156);
          String hexColor = String.format(
        "#%02X%02X%02X", 0, green, 0);
          
          pane.setStyle("-fx-background-color: " + hexColor + ";");
          color.setText("Green: " + hexColor);
        });

        // OPTION 4 - Exit program
        exit.setOnAction(event -> {
            Platform.exit();
        });
        
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

