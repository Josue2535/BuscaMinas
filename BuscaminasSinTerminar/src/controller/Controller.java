package controller;

import javax.swing.JOptionPane;

import com.sun.scenario.effect.impl.state.HVSeparableKernel;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
	private Label canMinas;

	public void level(Button b) {
		
		if (b.getText().equalsIgnoreCase("PRINCIPIANTE")) {
			b.setOnAction(e -> {
				bu = new Buscaminas(1);
				canMinas = new Label(" MINAS = 10 ");
				createLevel(bu.COLUMNAS_PRINCIPIANTE, bu.FILAS_PRINCIPIANTE);
			});
		} else if (b.getText().equalsIgnoreCase("INTERMEDIO")) {
			b.setOnAction(e -> {
				bu = new Buscaminas(2);
				canMinas = new Label(" MINAS = 40 ");
				createLevel(bu.FILAS_INTERMEDIO, bu.COLUMNAS_INTERMEDIO);
				
			});
		} else if (b.getText().equalsIgnoreCase("EXPERTO")) {
			b.setOnAction(e -> {
				bu = new Buscaminas(3);
				canMinas = new Label(" MINAS = 99 ");
				createLevel(bu.FILAS_EXPERTO, bu.COLUMNAS_EXPERTO);
			});
		}

	}

	public void createLevel(int i, int j) {
		Pane root = new Pane();
		VBox vbox = new VBox();
		gp = new GridPane();
		HBox gp1 = new HBox();
		for (int k = 0; k < i; k++) {
			for (int k2 = 0; k2 < j; k2++) {
				Button b1 = new Button(bu.darCasillas()[k][k2].mostrarValorCasilla());
				b1.setId(k + "," + k2);
				b1.setOnMouseClicked(new EventHandler<MouseEvent>(){

		            @Override
		            public void handle(MouseEvent event) {
		                MouseButton button = event.getButton();
		                if(button==MouseButton.PRIMARY){
		                    destapar(b1);
		                }else if(button==MouseButton.SECONDARY){
		                   marcar(b1);
		                }
		            }
		        });
				gp.add(b1, k2, k);
				;
			}
		}
		Button b2 = new Button("Destapar todo");
		b2.setOnAction(e -> {
			solucionar();
		});
		Button b3 = new Button("Dar Pista");
		b3.setOnAction(e -> {
			darPista();
		});
		
		gp1.getChildren().add(b2);
		gp1.getChildren().add(b3);
		gp1.getChildren().add(canMinas);
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
		bu.abrirCasilla(i, j);
		b1.setText(bu.darCasillas()[i][j].mostrarValorCasilla());
		b1.setOnAction(e -> {
		});
		if (bu.darPerdio()) {
			JOptionPane.showMessageDialog(null, "Perdiste");
			solucionar();
		} else if (bu.gano()) {
			JOptionPane.showMessageDialog(null, "ganaste");
			solucionar();
		}

	}

	public void solucionar() {
		bu.resolver();
		gp.getChildren().clear();
		for (int i = 0; i < bu.darCasillas().length; i++) {
			for (int j = 0; j < bu.darCasillas()[0].length; j++) {
				Button b1 = new Button(bu.darCasillas()[i][j].mostrarValorCasilla());

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
				b1.setId(i + "," + j);
				if (!bu.darCasillas()[i][j].darSeleccionada()) {
					b1.setOnMouseClicked(new EventHandler<MouseEvent>(){

			            @Override
			            public void handle(MouseEvent event) {
			                MouseButton button = event.getButton();
			                if(button==MouseButton.PRIMARY){
			                    destapar(b1);
			                }else if(button==MouseButton.SECONDARY){
			                   marcar(b1);
			                }
			            }
			        });
				}
				gp.add(b1, j, i);
			}
		}
	}
	
	public void marcar(Button b1) {
		String text = b1.getId();
		String parts[] = text.split(",");
		int i = Integer.parseInt(parts[0]);
		int j = Integer.parseInt(parts[1]);
		if(bu.darCasillas()[i][j].darSeCreeMina()) {
			bu.darCasillas()[i][j].yaNoSeCreeMina();
		}else {
			bu.darCasillas()[i][j].creeMina();
		}
		b1.setText(bu.darCasillas()[i][j].mostrarValorCasilla());
		b1.setOnAction(e -> {
		});
		
	}

}
