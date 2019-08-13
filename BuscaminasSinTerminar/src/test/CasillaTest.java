package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;

class CasillaTest {

private Casilla casilla1;
	
	private void setupEscenario1() {
		
		casilla1 = new Casilla(Casilla.MINA);
		
	}
	
	private void setupEscenario2() {
		
		casilla1 = new Casilla(Casilla.LIBRE);
		
	}
	
	private void setupEscenario3() {
		
		casilla1 = new Casilla(Casilla.MINA);
		casilla1.modificarValor(0);
		
	}
	
	private void setupEscenario4() {
		
		casilla1 = new Casilla(Casilla.LIBRE);
		casilla1.modificarValor(1);
		
	}
	
	private void setupEscenario5() {
		casilla1 = new Casilla(Casilla.MINA);
		casilla1.modificarValor(3);
		
	}
	
	private void setupEscenario6() {
		casilla1 = new Casilla(Casilla.LIBRE);
		
	}
	
	private void setupEscenario7() {
		casilla1 = new Casilla(Casilla.MINA);
		casilla1.esMina();
		casilla1.destapar();
		
	}
	
	@Test
	void testMina() {
		setupEscenario1();
		assertTrue(casilla1.esMina(), "No es de tipo mina");
	}
	
	@Test 
	void testMina1() {
		setupEscenario2();
		assertFalse(casilla1.esMina(), "Es de tipo libre");
		
	}
	
	@Test
	void testDestapar1() {
		setupEscenario3();
		casilla1.destapar();
		assertTrue(casilla1.darSeleccionada() == true,"No se ha destapado la casilla");
		
	}
	
	@Test
	void testDestapar2() {
		setupEscenario4();
		casilla1.destapar();
		assertTrue(casilla1.darSeleccionada() == true, "No se ha destapado la casilla");
	}
	
	@Test
	void testModificarValor() {
		setupEscenario5();
		int value = casilla1.darValor();
		
		assertEquals(3,value);
		
	}
	
	@Test
	void testMostrarCasillaValor() {
		setupEscenario6();
		String msj = casilla1.mostrarValorCasilla();
		
		assertTrue(msj.equals("-"), "No es mina");
	
	}
	
	@Test
	void testMostrarCasillaValor1() {
		setupEscenario7();
		String msj = casilla1.mostrarValorCasilla();
		
		assertEquals("*", msj);
		
	}
	
	@Test
	
	void testdarSeleccionada() {
		setupEscenario1();
		assertFalse(casilla1.darSeleccionada(),"Esta seleccionada" );
		
	}
	
	@Test
	
	void testdarSeleccionada1() {
		setupEscenario2();
		casilla1.destapar();
		assertTrue(casilla1.darSeleccionada(), "No esta seleccionada");
		
	}
	
	@Test
	void testdarSeleccionada2() {
		setupEscenario1();
		casilla1.destapar();
		assertTrue(casilla1.darSeleccionada(), "No esta seleccionada");
		
	}
	
	@Test
void testModificarValor1() {
		setupEscenario1();
		casilla1.modificarValor(0);
		
		assertEquals(0,casilla1.darValor());
	}
	
	
	@Test
	void testModificarValor2() {
		setupEscenario2();
		casilla1.modificarValor(1);
		assertNotEquals(0,casilla1.darValor());
	}
	
	@Test
	void testModificarTipo() {
		setupEscenario1();
		casilla1.modificarTipo(Casilla.LIBRE);
		assertFalse(casilla1.darTipo() == Casilla.MINA, "No se pudo encontrar el tipo");
	}
	
	/**
	 * 
	 */
	@Test
	void testModificarTipo2() {
	setupEscenario1();
	casilla1.modificarTipo(Casilla.LIBRE);
	assertTrue(casilla1.darTipo() == Casilla.LIBRE, "No se pudo encontrar el tipo");
		
	}
	
	//@Test
	
}
