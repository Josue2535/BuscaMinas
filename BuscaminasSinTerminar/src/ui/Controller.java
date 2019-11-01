package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Buscaminas;

public class Controller {
	private Buscaminas bu;
	public void level(Button b) {
		if(b.getText().equalsIgnoreCase("PRINCIPIANTE")) {
			b.setOnAction(e->{bu = new Buscaminas(1);
			createLevel(bu.COLUMNAS_PRINCIPIANTE, bu.FILAS_PRINCIPIANTE);});
		}
		else if(b.getText().equalsIgnoreCase("INTERMEDIO")) {
			b.setOnAction(e->{bu = new Buscaminas(2);
			createLevel( bu.FILAS_INTERMEDIO, bu.COLUMNAS_INTERMEDIO);});
		}
		else if(b.getText().equalsIgnoreCase("EXPERTO")) {
			b.setOnAction(e->{bu = new Buscaminas(3);createLevel(bu.FILAS_EXPERTO, bu.COLUMNAS_EXPERTO);});
		}
		
	}
	
	public void createLevel( int i, int j) {
		Pane root = new Pane();
		VBox vbox = new VBox();
		GridPane gp = new GridPane();
		GridPane gp1 = new GridPane();
		for (int k = 0; k < i; k++) {
			for (int k2 = 0; k2 < j; k2++) {
				Button b1 = new Button(bu.darCasillas()[k][k2].mostrarValorCasilla());
				b1.setId("k,k2");
				b1.setOnAction(e->{destapar(b1);});
				gp.add(b1, k2, k);;
			}
		}
		Button b2 = new Button("Destapar todo");
		Button b3 = new Button("Dar Pista");
		gp1.getChildren().add(b2);
		gp1.getChildren().add(b3);
		vbox.getChildren().add(gp);
		vbox.getChildren().add(gp1);
		root.getChildren().add(vbox);
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
		
	}
	
	public void destapar(Button b1) {
		
	}
	
}
