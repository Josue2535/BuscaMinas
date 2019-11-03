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
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Controller c1 = new Controller();
			VBox root = new VBox();
			Button b1 = new Button("PRINCIPIANTE");
			Button b2 = new Button("INTERMEDIO");
			Button b3 = new Button("EXPERTO");
			Font value = new Font(25);
			b1.setFont(value);
//			b1.setOnAction(e->{
				c1.level(b1);
//			});
			b2.setFont(value);
//			b2.setOnAction(e->{
				c1.level(b2);
//			});
			b3.setFont(value);
//			b3.setOnAction(e->{
				c1.level(b3);
//			});
			root.getChildren().add(b1);
			root.getChildren().add(b2);
			root.getChildren().add(b3);
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
