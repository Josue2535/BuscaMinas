package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;

class CasillasTest {
	private Casilla casilla;

	public void setupStage() {
		casilla = new Casilla(Casilla.MINA);
	}


	public void setupStage1() {
		casilla = new Casilla(Casilla.LIBRE);
	}

	

	@Test
	void testEsMina() {
		setupStage();
		casilla.esMina();
	}

	@Test
	void testMostrarValorCasilla() {
		setupStage();
		casilla.mostrarValorCasilla();
	}

	

	@Test
	void testEsMina1() {
		setupStage1();
		casilla.esMina();
	}

	@Test
	void testMostrarValorCasilla1() {
		setupStage1();
		casilla.mostrarValorCasilla();
	}

}
