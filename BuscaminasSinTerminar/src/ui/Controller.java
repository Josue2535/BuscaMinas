package ui;

import javax.swing.JOptionPane;

import com.sun.scenario.effect.impl.state.HVSeparableKernel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Buscaminas;
import sun.security.util.Length;

public class Controller {
	private Buscaminas bu;
	private GridPane gp;
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
		Font f = new Font(16);
		gp = new GridPane();
		HBox gp1 = new HBox();
		for (int k = 0; k < i; k++) {
			for (int k2 = 0; k2 < j; k2++) {
				Button b1 = new Button(bu.darCasillas()[k][k2].mostrarValorCasilla());
				b1.setId(k+","+k2);
				b1.setFont(f);
				b1.setOnAction(e->{destapar(b1);});
				gp.add(b1, k2, k);;
			}
		}
		Button b2 = new Button("Destapar todo");
		b2.setOnAction(e->{
			solucionar();
		});
		Button b3 = new Button("Dar Pista");
		b3.setOnAction(e->{
			darPista();
		});
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
		String text = b1.getId();
		String parts[] = text.split(",");
		int i = Integer.parseInt(parts[0]);
		int j = Integer.parseInt(parts[1]);
		bu.abrirCasilla(i,j);
		b1.setText(bu.darCasillas()[i][j].mostrarValorCasilla());
		if(bu.darPerdio()) {
			JOptionPane.showMessageDialog(null, "Perdiste");
			solucionar();
		}else if(bu.gano()){
			JOptionPane.showMessageDialog(null, "ganaste");
			solucionar();
		}
	}
	
	public void solucionar() {
		bu.resolver();
		gp.getChildren().clear();
		Font f = new Font(16);		
		for (int i = 0; i < bu.darCasillas().length; i++) {
			for (int j = 0; j < bu.darCasillas()[0].length; j++) {
				Button b1 = new Button(bu.darCasillas()[i][j].mostrarValorCasilla());
				b1.setFont(f);
				gp.add(b1, j, i);
			}
		}
	}
	public void darPista() {
		String des = bu.darPista();
		gp.getChildren().clear();
		for (int i = 0; i < bu.darCasillas().length; i++) {
			for (int j = 0; j < bu.darCasillas()[0].length; j++) {
				Button b1 = new Button(bu.darCasillas()[i][j].mostrarValorCasilla());
				b1.setId(i+","+j);
				b1.setOnAction(e->{destapar(b1);});
				gp.add(b1, j, i);
			}
		}
	}
	
}
