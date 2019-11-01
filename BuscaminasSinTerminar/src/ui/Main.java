package ui;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	private Controller c1 = new Controller();
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			Button b1 = new Button("Principiante");
			Font value = new Font(25);
			b1.setFont(value);
			b1.setOnAction(e->{
				c1.level(b1);
			});
			
			root.getChildren().add(b1);
			Scene scene = new Scene(root,400,400);
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
