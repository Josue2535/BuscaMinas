package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Buscaminas;
import modelo.Casilla;

class BuscaminasTest {

	private Buscaminas searchMines;

	private void setupEscenario1() {

		try {
		searchMines = new Buscaminas(Buscaminas.PRINCIPIANTE);

		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	private void setupEscenario2() {

		try {
		searchMines = new Buscaminas(Buscaminas.INTERMEDIO);
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

	private void setupEscenario3() {
		try {
			searchMines = new Buscaminas(Buscaminas.EXPERTO);
		}catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	private void setupEscenario111() {
			
 			Casilla t[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
 			
 			for(int i = 0; i < t.length; i++) {
				for(int j = 0; j < t[0].length;j++) {
					t[i][j] = new Casilla(Casilla.LIBRE);
				}
			}
 			searchMines = new Buscaminas(Buscaminas.PRINCIPIANTE, t);
 			searchMines.generarMinas();
 			searchMines.inicializarCasillasLibres();
 			
 			
 			
	}
	
	private void setupEscenario222() {
		
			Casilla t[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
 			
			for(int i = 0; i < t.length; i++) {
			for(int j = 0; j < t[0].length;j++) {
				t[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
			
			searchMines = new Buscaminas(Buscaminas.INTERMEDIO, t);
			searchMines.generarMinas();
			searchMines.inicializarCasillasLibres();
		
	}
	
	private void setupEscenario333() {
		Casilla t[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
			
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		searchMines = new Buscaminas(Buscaminas.EXPERTO, t);
		searchMines.generarMinas();
		searchMines.inicializarCasillasLibres();
		
	}

	//----------------------------------------------------------------------------------------------------------------------------------------------------------
	//Para las pruebas de contar Minas en nivel principiante
	private void setupEscenario4() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
			
			for(int i = 0; i < t.length; i++) {
			for(int j = 0; j < t[0].length;j++) {
				t[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		t[0][0].modificarTipo(Casilla.MINA);
		t[0][1].modificarTipo(Casilla.MINA);
		t[1][1].modificarTipo(Casilla.MINA);
		t[1][0].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.PRINCIPIANTE, t);
	}
	
	private void setupEscenario5() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		t[0][7].modificarTipo(Casilla.MINA);
		t[1][7].modificarTipo(Casilla.MINA);
		t[1][6].modificarTipo(Casilla.MINA);
		t[0][6].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.PRINCIPIANTE,t);
		
	}
	
	private void setupEscenario6() {
		Casilla t[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		
		t[7][0].modificarTipo(Casilla.MINA);
		t[6][1].modificarTipo(Casilla.MINA);
		t[7][1].modificarTipo(Casilla.MINA);
		t[6][0].modificarTipo(Casilla.MINA);
		searchMines = new Buscaminas(Buscaminas.PRINCIPIANTE,t);
		
	}
	
	private void setupEscenario7() {
		Casilla t[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		t[7][7].modificarTipo(Casilla.MINA);
		t[7][6].modificarTipo(Casilla.MINA);
		t[6][6].modificarTipo(Casilla.MINA);
		t[6][7].modificarTipo(Casilla.MINA);
		searchMines = new Buscaminas(Buscaminas.PRINCIPIANTE,t);
	}
	
	private void setupEscenario8() {
		Casilla t[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		t[3][3].modificarTipo(Casilla.MINA);
		t[3][2].modificarTipo(Casilla.MINA);
		t[4][2].modificarTipo(Casilla.MINA);
		t[2][2].modificarTipo(Casilla.MINA);
		t[2][3].modificarTipo(Casilla.MINA);
		t[2][4].modificarTipo(Casilla.MINA);
		t[3][4].modificarTipo(Casilla.MINA);
		t[4][4].modificarTipo(Casilla.MINA);
		t[4][3].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.PRINCIPIANTE,t);
	}
	//----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Para las pruebas de contar minas alrededor nivel Intermedio
	
	private void setupEscenario9() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		t[0][0].modificarTipo(Casilla.MINA);
		t[0][1].modificarTipo(Casilla.MINA);
	    t[1][1].modificarTipo(Casilla.MINA);
		t[1][0].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.INTERMEDIO,t);
	}
		
	public void setupEscenario10() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[0][15].modificarTipo(Casilla.MINA);
		t[1][14].modificarTipo(Casilla.MINA);
		t[0][14].modificarTipo(Casilla.MINA);
		t[1][15].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.INTERMEDIO,t);
	}
	
	public void setupEscenario11() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[15][0].modificarTipo(Casilla.MINA);
		t[15][1].modificarTipo(Casilla.MINA);
		t[14][0].modificarTipo(Casilla.MINA);
		t[14][1].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.INTERMEDIO,t);
	}
	
	public void setupEscenario12() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[15][15].modificarTipo(Casilla.MINA);
		t[15][14].modificarTipo(Casilla.MINA);
		t[14][14].modificarTipo(Casilla.MINA);
		t[14][15].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.INTERMEDIO,t);
	}
	
	public void setupEscenario13() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[8][8].modificarTipo(Casilla.MINA);
		t[8][7].modificarTipo(Casilla.MINA);
		t[7][7].modificarTipo(Casilla.MINA);
		t[9][7].modificarTipo(Casilla.MINA);
		t[9][8].modificarTipo(Casilla.MINA);
		t[9][9].modificarTipo(Casilla.MINA);
		t[8][9].modificarTipo(Casilla.MINA);
		t[7][9].modificarTipo(Casilla.MINA);
		t[7][8].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.INTERMEDIO,t);
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Para las pruebas de contar minas alrededor de nivel Experto
	private void setupEscenario14() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[0][0].modificarTipo(Casilla.MINA);
		t[0][1].modificarTipo(Casilla.MINA);
		t[1][1].modificarTipo(Casilla.MINA);
		t[1][0].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.EXPERTO,t);
	}
	
	private void setupEscenario15() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
			
			t[15][0].modificarTipo(Casilla.MINA);
			t[14][0].modificarTipo(Casilla.MINA);
			t[14][1].modificarTipo(Casilla.MINA);
			t[15][1].modificarTipo(Casilla.MINA);
			
			searchMines = new Buscaminas(Buscaminas.EXPERTO,t);
	}
	
	private void setupEscenario16() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[0][29].modificarTipo(Casilla.MINA);
		t[0][28].modificarTipo(Casilla.MINA);
		t[1][28].modificarTipo(Casilla.MINA);
		t[1][29].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.EXPERTO,t);
		
	}
	
	private void setupEscenario17() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[15][29].modificarTipo(Casilla.MINA);
		t[14][29].modificarTipo(Casilla.MINA);
		t[14][28].modificarTipo(Casilla.MINA);
		t[15][28].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.EXPERTO,t);
	}
	
	private void setupEscenario18() {
		
		Casilla t[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		
		for(int i = 0; i < t.length; i++) {
		for(int j = 0; j < t[0].length;j++) {
			t[i][j] = new Casilla(Casilla.LIBRE);
		}
	}
		
		t[6][22].modificarTipo(Casilla.MINA);
		t[6][21].modificarTipo(Casilla.MINA);
		t[5][21].modificarTipo(Casilla.MINA);
		t[7][21].modificarTipo(Casilla.MINA);
		t[5][22].modificarTipo(Casilla.MINA);
		t[5][23].modificarTipo(Casilla.MINA);
		t[6][23].modificarTipo(Casilla.MINA);
		t[7][23].modificarTipo(Casilla.MINA);
		t[7][22].modificarTipo(Casilla.MINA);
		
		searchMines = new Buscaminas(Buscaminas.EXPERTO,t);
		
	}
	
	
	
	//-------------------------------------------------------Empiezan los test--------------------------------------------------------------------------------

	@Test
	void testGenerarMinaAleatoria1() {
		setupEscenario1();
		int minas = 0;

	try {
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for (int j = 0; j < searchMines.darCasillas()[0].length; j++) {

				if(searchMines.darCasillas()[i][j].esMina()) {

				 minas++;

				}

			}
		}
	}catch(ArrayIndexOutOfBoundsException e) {
			e.getClass();
		}
		assertTrue(minas == 10, "No hay diez minas");
	}

	@Test
	void testGenerarMinaAleatoria2() {
		setupEscenario2();
		int minas = 0;

		try {
			for(int i = 0; i < searchMines.darCasillas().length;i++) {
				for (int j = 0; j < searchMines.darCasillas()[0].length; j++) {

					if(searchMines.darCasillas()[i][j].esMina()) {

					 minas++;

					}

				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
				e.getClass();
			}
			assertTrue(minas == 40, "No hay cuarenta minas");
	}

	@Test
	void testGenerarMinaAleatoria3() {
		setupEscenario3();
		int minas = 0;

		try {
			for(int i = 0; i < searchMines.darCasillas().length;i++) {
				for (int j = 0; j < searchMines.darCasillas()[0].length; j++) {

					if(searchMines.darCasillas()[i][j].esMina()) {

					 minas++;

					}

				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
				e.getClass();
			}
			assertTrue(minas == 99, "No hay noventa y nueve minas");

	}
	

	@Test
	void contarCasillasLibres() {
		setupEscenario111();
		int min = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length; i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j].esMina() == false){
					if(searchMines.darCasillas()[i][j].darValor() != -1) {
					min++;
					}
				}
			}
		}
		
		
		assertTrue(min == 54, "No se contaron todas las minas");
		
		
	}
	
	@Test
	void contarCasillasLibre1() {
		setupEscenario222();
		int min = 0; 
		for(int i = 0; i < searchMines.darCasillas().length; i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j].esMina() == false){
					if(searchMines.darCasillas()[i][j].darValor() != -1) {
					min++;
					}
				}
			}
		}
		
		System.out.println(min);
		assertTrue(min == 216, "No se contaron todas las minas");
		
	}
	
	@Test
	void contarCasillasLibre2() {
		setupEscenario333();
		int min = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length; i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j].esMina() == false){
					if(searchMines.darCasillas()[i][j].darValor() != -1) {
					min++;
					}
				}
			}
		}
		
		System.out.println(min);
		assertTrue(min == 381, "No se contaron todas las minas");
	}
	
	@Test
	void testInicializarPartida() {
		setupEscenario1();
		int jo = 0;
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j] != null) {
					jo++;
				}
			}
		}
		
	assertEquals(64, jo);
	}
	
	@Test
	void testInicializarPartida1() {
		setupEscenario1();
		boolean m = true;
		searchMines.darCasillas()[0][0].destapar();
		searchMines.darCasillas()[0][0].modificarValor(9);
		searchMines.darCasillas()[0][0].modificarTipo(Casilla.MINA);
		searchMines.darCasillas()[0][0].esMina();
		
		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		
		assertFalse(m == true,"No se ejecuta el metodo correctamente");
	}
	
	@Test
	void testInicializarPartida2() {
		setupEscenario2();
		int jo = 0;
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j] != null) {
					jo++;
				}
			}
		}

	assertEquals(256, jo);
	}
	
	@Test
	void testInicializarPartida22() {
		setupEscenario2();
		boolean m = false;

		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
	
		assertEquals(false,m);
	}
	
	@Test
	void testInicializarPartida3() {
		setupEscenario3();
		int jo = 0;
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j] != null) {
					jo++;
				}
			}
		}
	
	assertEquals(480, jo);
		
	}
	
	@Test
	void testInicializarPartida33() {
		setupEscenario3();
		boolean m = false;

		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		
		assertEquals(false,m);
		
	}
	
	@Test
	void testContarMinasAlrededorPrincipiante1() {
		setupEscenario5();
		int m = 0;
		int var = 0;
		int var1 = 7;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
		assertEquals(4, m);
		
	}
	
	@Test
	void testContarMinasAlrededorPrincipiante2() {
		setupEscenario6();
		int m = 0;
		int var = 7;
		int var1 = 0;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	
	}
	
	@Test
	void testcontarMinasAlrededorPrincipiantes() {
		setupEscenario4();
		int m = 0;
		int var = 0;
		int var1 = 0;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test
	void testcontarMinasAlrededorPrincipiantes3() {
		setupEscenario7();
		int m = 0;
		int var = 7;
		int var1 = 7;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test 
	void testcontarMinasAlrededorPrincipiantes4() {
		setupEscenario8();
		int m = 0;
		int var = 3;
		int var1 = 3;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(9, m);
		
	}
	
	@Test
	void testcontarMinasAlrededorIntermedio() {
		setupEscenario9();
		
		int m = 0;
		int var = 0;
		int var1 = 0;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test
	void testcontarMinasAlrededorIntermedio1() {
		setupEscenario10();
		int m = 0;
		int var = 0;
		int var1 = 15;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test
	 void testcontarMinasAlrededorIntermedio2() {
		setupEscenario11();
		int m = 0;
		int var = 15;
		int var1 = 0;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
		
	}
	
	@Test
	void testcontarMinasAlrededorIntermedio3() {
		setupEscenario12();
		
		int m = 0;
		int var = 15;
		int var1 = 15;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test
	void testcontarMinasAlrededorIntermedio4() {
		setupEscenario13();
		int m = 0;
		int var = 8;
		int var1 = 8;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(9, m);
	}
	
	@Test
	void testcontarMinasAlrededorExperto() {
		setupEscenario14();
		
		int m = 0;
		int var = 0;
		int var1 = 0;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test
	void testcontarMinasAlrededorExperto1() {
		setupEscenario15();
		int m = 0;
		int var = 15;
		int var1 = 0;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
		
	}
	
	@Test
	void testcontarMinasAlrededorExperto2() {
		setupEscenario16();
		int m = 0;
		int var = 0;
		int var1 = 29;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test
	void testcontarMinasAlrededorExperto3() {
		setupEscenario17();
		
		int m = 0;
		int var = 15;
		int var1 = 29;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(4, m);
	}
	
	@Test 
	void testcontarMinasAlrededorExperto4() {
		setupEscenario18();
		
		int m = 0;
		int var = 6;
		int var1 = 22;
		int b = 0;
		int v = 0;
	    
	    for (int i = var -1; v <3 && i < searchMines.darCasillas().length; i++) {
			for(int j = var1 - 1;b <3;j++){
				if((i >= 0 && j >= 0)) {
					if ((i >= 0 && j >= 0) && ( j < searchMines.darCasillas()[0].length)) {
						if (searchMines.darCasillas()[i][j].esMina()) {
							m++;
						}
					}
				}
				b++;
			}
			v++;
			b = 0;
		}
	    assertEquals(9, m);
	}
	
	@Test
	void testMostrarTableroPrincipiantes() {
		setupEscenario111();
		int m = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j].darSeleccionada() == false) {
				m++;
				}
			}
		}
		assertEquals(64,m);
	}
	
	@Test
	void testMostrarTableroPrincipiantes1() {
		setupEscenario111();
		String msj = " ";
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				msj += searchMines.darCasillas()[i][j].mostrarValorCasilla();
			}
		}
		
		setupEscenario1();
		String msj1 = " ";
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				msj += searchMines.darCasillas()[i][j].mostrarValorCasilla();
			}
		}
		
		assertFalse(msj == msj1, "Son iguales");
		
	}
	
	@Test
	void testMostrarTableroPrincipiantes2(){
		setupEscenario111();
		searchMines.resolver();
		int m = 0;
	
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
						
				if(searchMines.darCasillas()[i][j].darTipo() == Casilla.LIBRE && searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
	}
		assertEquals(54,m);
		
	}
	
	@Test
	void testMostrarTableroIntermedio() {
		setupEscenario222();
		
		int m = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j].darSeleccionada() == false) {
				m++;
				}
			}
		}
		assertEquals(256,m);
	}
	
	@Test
	void testMostrarTableroIntermedio1() {
		setupEscenario222();
		searchMines.resolver();
		int m = 0;

		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				
				if(searchMines.darCasillas()[i][j].esMina() && searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
	}
		assertEquals(40,m);
	}
	
	@Test
	void testMostrarTableroIntermedio2() {
		setupEscenario222();
		searchMines.resolver();
		int m = 0;
	
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
						
				if(searchMines.darCasillas()[i][j].darTipo() == Casilla.LIBRE && searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
	}
		assertEquals(216,m);
	}
	
	@Test 
	void testMostrarTableroExperto() {
		setupEscenario333();
		
		int m = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				if(searchMines.darCasillas()[i][j].darSeleccionada() == false) {
				m++;
				}
			}
		}
		assertEquals(480,m);
		
	}
	
	@Test
	void testMostrarTableroExperto1() {
		setupEscenario333();
		searchMines.resolver();
		int m = 0;

		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
				
				if(searchMines.darCasillas()[i][j].esMina() && searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
	}
		assertEquals(99,m);
		
	}
	
	@Test
	void testMostrarTableroExpero2() {
		setupEscenario333();
		
		searchMines.resolver();
		int m = 0;
	
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++) {
						
				if(searchMines.darCasillas()[i][j].darTipo() == Casilla.LIBRE && searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
	}
		assertEquals(381,m);
		
		
	}
	
	@Test
	void testResolver() {
		setupEscenario1();
		searchMines.resolver();
		int m = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++){
				if(searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
		}
		assertEquals(64,m);
	}
	
	@Test
	void testResolver1() {
		setupEscenario2();
		searchMines.resolver();
		int m = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++){
				if(searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
		}
		assertEquals(256,m);
		
	}
	
	@Test
	void testResolver3() {
		setupEscenario3();
		searchMines.resolver();
		
		int m = 0;
		
		for(int i = 0; i < searchMines.darCasillas().length;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length;j++){
				if(searchMines.darCasillas()[i][j].darSeleccionada() == true) {
				m++;
				}
			}
		}
		assertEquals(480,m);
		
	}
	
	@Test
	void testAbrirCasillaPrincipiante() {
		setupEscenario111();
		
		assertTrue(searchMines.abrirCasilla(1,1) == true, "No se ha podido abrir");
		
	}
	
	@Test
	void testAbrirCasillaPrincipiante1() {
		setupEscenario111();
		searchMines.abrirCasilla(1,1);
		
		assertFalse(searchMines.abrirCasilla(1,1) == true, "se ha podido abrir");
		
	}
	
	@Test
	void testAbrirCasillaIntermedio() {
		setupEscenario222();
		
		assertTrue(searchMines.abrirCasilla(1,1) == true, "No se ha podido abrir");
	}
	
	@Test
	void testAbrirCasillaIntermedio1() {
		setupEscenario222();
		searchMines.abrirCasilla(1,1);
		
		assertFalse(searchMines.abrirCasilla(1,1) == true, "se ha podido abrir");
		
	}
	
	@Test
	void testAbrirCasillaExperto() {
		setupEscenario333();
		
		assertTrue(searchMines.abrirCasilla(1,1) == true, "No se ha podido abrir");
		
	}
	
	@Test
	void testAbrirCasillaExperto1() {
		setupEscenario333();
		searchMines.abrirCasilla(1,1);
		
		assertFalse(searchMines.abrirCasilla(1,1) == true, "se ha podido abrir");
		
	}
	
	@Test
	void testGanoPrincipiante() {
		setupEscenario1();
		
		boolean m = true;
		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		
		assertFalse(m == true,"No se ejecuta el metodo correctamente");
		}
	
	
	@Test
	void testGanoPrincipiante1() {
		setupEscenario1();
		searchMines.darCasillas()[0][0].modificarValor(9);
		searchMines.darCasillas()[0][0].modificarTipo(Casilla.MINA);
		searchMines.darCasillas()[0][0].destapar();
		searchMines.darCasillas()[0][0].esMina();
		boolean m = true;
		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		
		assertFalse(m == true, "No se ejecuto correctamente");
		
	}
	
	@Test
	void testGanoIntermedio() {
		setupEscenario2();
		
		boolean m = true;
		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		
		assertTrue(m == false, "No se ha ejecutado correctamente");
		
	}
	
	@Test
	void testGanoIntermedio1() {
		
		setupEscenario3();
		
		searchMines.darCasillas()[0][0].modificarValor(9);
		searchMines.darCasillas()[0][0].modificarTipo(Casilla.MINA);
		searchMines.darCasillas()[0][0].destapar();
		searchMines.darCasillas()[0][0].esMina();
		
		boolean m = true;
		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		assertFalse(m == true, "No se ejecuto correctamente");
		
	}
	
	@Test
	void testGanoExperto() {
		setupEscenario3();
		
		boolean m = true;
		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		
		assertTrue(m == false, "No se ha ejecutado correctamente");
		
	}
	
	@Test
	void testGanoExperto1() {
		setupEscenario3();
		
		searchMines.darCasillas()[0][0].modificarValor(9);
		searchMines.darCasillas()[0][0].modificarTipo(Casilla.MINA);
		searchMines.darCasillas()[0][0].destapar();
		searchMines.darCasillas()[0][0].esMina();
		
		boolean m = true;
		
		for(int i = 0; i < searchMines.darCasillas().length && m == true;i++) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && m == true;j++){
				if(!searchMines.darCasillas()[i][j].esMina() && !searchMines.darCasillas()[i][j].darSeleccionada()) {
					m = false;
				}
			}
		}
		assertFalse(m == true, "No se ejecuto correctamente");
	}
	
	@Test
	void testdarPista1() {
		setupEscenario1();
		boolean t = true;
		boolean m = false;
		for(int i = 0; i < searchMines.darCasillas().length && t;i++ ) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && t;j++) {
				if((searchMines.darCasillas()[i][j].esMina() == false) && (searchMines.darCasillas()[i][j].darValor() > 0) && (searchMines.darCasillas()[i][j].darSeleccionada() == false)){
					t = false;
					m = true;
				}
			}
		}
		
		assertTrue(m == true, "No se ejecuta bien el metodo");
		
	}
	
	@Test
	void testdarPista2() {
		setupEscenario2();
		boolean t = true;
		boolean m = false;
		for(int i = 0; i < searchMines.darCasillas().length && t;i++ ) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && t;j++) {
				if((searchMines.darCasillas()[i][j].esMina() == false) && (searchMines.darCasillas()[i][j].darValor() > 0) && (searchMines.darCasillas()[i][j].darSeleccionada() == false)){
					t = false;
					m = true;
				}
			}
		}
		
		assertTrue(m == true, "No se ejecuta bien el metodo");
		
	}
	
	@Test
	void testdarPista3() {
		setupEscenario3();
		boolean t = true;
		boolean m = false;
		for(int i = 0; i < searchMines.darCasillas().length && t;i++ ) {
			for(int j = 0; j < searchMines.darCasillas()[0].length && t;j++) {
				if((searchMines.darCasillas()[i][j].esMina() == false) && (searchMines.darCasillas()[i][j].darValor() > 0) && (searchMines.darCasillas()[i][j].darSeleccionada() == false)){
					t = false;
					m = true;
				}
			}
		}
		
		assertTrue(m == true, "No se ejecuta bien el metodo");
		
		
	}
	
}

