package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Buscaminas;
import modelo.Casilla;


class BuscaminasTest {

Buscaminas buscaminas;
	
	
	
	
	
	public void setupStage() {
		buscaminas= new Buscaminas(Buscaminas.PRINCIPIANTE);	
	}
	
	
	
	public void setupStage1() {
		buscaminas= new Buscaminas(Buscaminas.INTERMEDIO);	
	}
	
	
	
	public void setupStage2() {
		buscaminas= new Buscaminas(Buscaminas.EXPERTO);	
	}
		
	
	
	

	
	@Test
	void testCreateBuscaminas() {
		setupStage();
		assertNotNull(buscaminas.darCasillas());
	}
	
	
	
	@Test
	void testSolve() {
		setupStage();
		int many =0;
		Casilla[][] position=	buscaminas.darCasillas();
		buscaminas.resolver();
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].darSeleccionada()) {
					++many;
				}
			
				
			}
		}
		
		assertTrue(many == (position.length*position[0].length));
	}

	
	
	
	@Test
	void testCreateBuscaminas1() {
		setupStage1();
		assertNotNull(buscaminas.darCasillas());
	}
	
	
	
	@Test
	void testCountMines1() {
		setupStage1();
		int mines = 0;
		Casilla[][] position=	buscaminas.darCasillas();
		
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].esMina()) {
					++mines;
				}
			
				
			}
		}
		System.out.println(mines);
		System.out.println(Buscaminas.CANTIDAD_MINAS_INTERMEDIO);
		
		System.out.println("------");
		
		assertTrue(mines == Buscaminas.CANTIDAD_MINAS_INTERMEDIO);
	}
	
	@Test
	void testSolve1() {
		setupStage1();
		int many =0;
		Casilla[][] position=	buscaminas.darCasillas();
		buscaminas.resolver();
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].darSeleccionada()) {
					++many;
				}
			
				
			}
		}
		
		assertTrue(many == (position.length*position[0].length));
	}

	

	@Test
	void testCreateBuscaminas2() {
		setupStage2();
		assertNotNull(buscaminas.darCasillas());
	}
	
	

	
	
	@Test
	void testCountMines2() {
		setupStage2();
		int mines = 0;
		Casilla[][] position=	buscaminas.darCasillas();
		
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].esMina()) {
					++mines;
				}
			
				
			}
		}
		System.out.println(mines);
		System.out.println(Buscaminas.CANTIDAD_MINAS_EXPERTO);
		
		assertTrue(mines == Buscaminas.CANTIDAD_MINAS_EXPERTO);
	}
	
	
}
