/**
 * ~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de solución laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~
 */

package modelo;

//import java.util.*;

public class Buscaminas {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * principiante
	 */
	public static final int FILAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * intermedio
	 */
	public static final int FILAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * experto
	 */
	public static final int FILAS_EXPERTO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * principiante
	 */
	public static final int COLUMNAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * intermedio
	 */
	public static final int COLUMNAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * experto
	 */
	public static final int COLUMNAS_EXPERTO = 30;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel principiante
	 */
	public static final int PRINCIPIANTE = 1;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel intermedio
	 */
	public static final int INTERMEDIO = 2;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel experto
	 */
	public static final int EXPERTO = 3;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel
	 * principiante
	 */
	public static final int CANTIDAD_MINAS_PRINCIPIANTE = 10;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel
	 * intermedio
	 */
	public static final int CANTIDAD_MINAS_INTERMEDIO = 40;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel experto
	 */
	public static final int CANTIDAD_MINAS_EXPERTO = 99;

	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------

	/**
	 * Relacion que tiene la matriz de casillas
	 */
	private Casilla[][] casillas;

	/**
	 * Atributo que representa el nivel del juego <Solo puede tomar valores
	 * PRINCIPIANTE, INTERMEDIO, EXPERTO>
	 */
	private int nivel;

	/**
	 * Atributo que tiene la cantidad de minas en el tablero
	 */
	private int cantidadMinas;

	/**
	 * Atributo que representa si el usuario perdio al abrir una mina
	 */
	private boolean perdio;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructo de la clase Buscaminas
	 * 
	 * @param nivel - el nivel seleccionado por el usuario
	 */
	public Buscaminas(int nivel) {
		this.nivel = nivel;
		perdio = false;
		inicializarPartida();

	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Se encarga de inicializar los atributos y relaciones de la clase buscaminas a
	 * partir del nivel elegido por el usuario
	 */
	private void inicializarPartida() {

		if (nivel == PRINCIPIANTE) {
			casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
			cantidadMinas = CANTIDAD_MINAS_PRINCIPIANTE;
			generarMinas();
			inicializarCasillasLibres();
		} else if (nivel == INTERMEDIO) {
			casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
			cantidadMinas = CANTIDAD_MINAS_INTERMEDIO;
			generarMinas();
			inicializarCasillasLibres();
		} else {
			casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO];
			cantidadMinas = CANTIDAD_MINAS_EXPERTO;
			generarMinas();
			inicializarCasillasLibres();
		}
//		inicializarCasillasLibres();
//		generarMinas();

	}

	/**
	 * Metodo que se encarga de inicializar todas las casillas que no son minas
	 */
	public void inicializarCasillasLibres() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j] == null) {
					casillas[i][j] = new Casilla(Casilla.LIBRE);
					// casillas[i][j].modificarValor(cantidadMinasAlrededor(i,j));
				}
			}
		}
		for (int k = 0; k < casillas.length; k++) {
			for (int l = 0; l < casillas[0].length; l++) {
				casillas[k][l].modificarValor(cantidadMinasAlrededor(k, l));
//				if (!casillas[k][l].esMina()) {
//					casillas[k][l].modificarValor(cantidadMinasAlrededor(k, l));
//				}
			}
		}
	}

	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una
	 * casillas
	 * 
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */
	public int cantidadMinasAlrededor(int i, int j) {

		int contador = 0;
		int v = 0;
		int h = 0;

		for (int a = i - 1; v < 3 && a < casillas.length; a++) {
			for (int b = j - 1; h < 3; b++) {
				if ((a >= 0 && b >= 0) && (b < casillas[a].length)) {
					if (casillas[a][b].esMina()) {
						contador++;
					}
				}
				h++;
			}
			v++;
			h = 0;
		}
		return contador;
	}

	/**
	 * Método que se encarga de generar aleatoriomente las minas
	 */
	public void generarMinas() {

		int i = casillas.length;
		int j = casillas[0].length;

		for (int k = 0; k < cantidadMinas; k++) {

			int a = (int) Math.floor(Math.random() * (0 - i) + i);

			int b = (int) Math.floor(Math.random() * (0 - j) + j);

			boolean es = true;

			for (int l = 0; l < cantidadMinas && es; l++) {
				try {
				if (casillas[a][b] == null) {

					casillas[a][b] = new Casilla(Casilla.MINA);
					es = false;
				} else {

					throw new errorMinaCreada("La casilla ya es mina");
				}
				}catch(errorMinaCreada e){
					int c = (int) Math.floor(Math.random() * (0 - i) + i);

					int d = (int) Math.floor(Math.random() * (0 - j) + j);

					casillas[c][d] = new Casilla(Casilla.MINA);
					es = false;
				}
			}
		}

	}

	/**
	 * Metodo que se encarga de convertir el tablero a un String para poder verlo en
	 * pantalla
	 * 
	 * @return String - El tablero en formato String
	 */
	public String mostrarTablero() {

		String ms = "";
		if (nivel == PRINCIPIANTE) {
			ms += "  0 1 2 3 4 5 6 7 8 \n";
			int f = 1;
			for (int i = 0; i < FILAS_PRINCIPIANTE; i++) {
				ms += f + " |";
				for (int j = 0; j < COLUMNAS_PRINCIPIANTE; j++) {
					ms += " " + casillas[i][j].mostrarValorCasilla();
				}
				ms += "  | " + "\n";
				f++;
			}
		} else if (nivel == INTERMEDIO) {
			ms += " 0    1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16 \n";
			int f = 1;
			for (int i = 0; i < FILAS_INTERMEDIO; i++) {
				if (f <= 9) {
					ms += " " + f + "|";
				} else {
					ms += f + "|";
				}

				for (int j = 0; j < COLUMNAS_INTERMEDIO; j++) {
					ms += "   " + casillas[i][j].mostrarValorCasilla();
				}

				ms += " | " + "\n";
				f++;
			}
		} else {
			ms += " 0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30\n";
			int f = 1;
			for (int i = 0; i < FILAS_EXPERTO; i++) {
				if (f <= 9) {
					ms += " " + f + "|";
				} else {
					ms += f + "|";
				}

				for (int j = 0; j < COLUMNAS_EXPERTO; j++) {
					ms += "   " + casillas[i][j].mostrarValorCasilla();
				}
				ms += "| " + "\n";
				f++;
			}
		}
		return ms;
	}

	/**
	 * Metodo que se encarga de marcar todas las casillas como destapadas
	 */
	public void resolver() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j].destapar();
			}
		}
	}

	/**
	 * Metodo dar del atributo casillas
	 * 
	 * @return la relacion casillas
	 */
	public Casilla[][] darCasillas() {
		return casillas;
	}

	/**
	 * Este metodo se encargaa de abrir una casilla Si se abre una casilla de tipo
	 * Mina, se marca que el jugador perdio el juego.
	 * 
	 * @param i - la fila donde esta la casilla
	 * @param j - la columna donde esta la casilla
	 * @return boolean - true si fue posible destaparla, false en caso contrario
	 */
	public boolean abrirCasilla(int i, int j) {
		boolean abrir = false;
		if (!casillas[i][j].darSeleccionada()) {
			casillas[i][j].destapar();
			if (casillas[i][j].esMina()) {
				perdio = true;
			}
			abrir = true;
		}
		return abrir;
	}

	/**
	 * Metodo que se encarga de revisar si el jugador gano el juego
	 * 
	 * @return boolean - true si gano el juego, false en caso contrario
	 */
	public boolean gano() {
		boolean gano = true;
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (!casillas[i][j].esMina() && !casillas[i][j].darSeleccionada()) {
					gano = false;
				}
			}
		}
		return gano;
	}

	/**
	 * Metodo que se encarga de abrir la primera casilla que no sea una Mina y cuyo
	 * valor sea Mayor que 0
	 * 
	 * @return String, Mensaje de la Casilla que marco abierta, En caso de no haber
	 *         casillas posibles para dar una pista, retorna el mensaje no hay
	 *         pistas para dar
	 */
	public String darPista() {

		String ms = "";
		boolean ya = false;
		for (int i = 0; i < casillas.length && !ya; i++) {
			for (int j = 0; j < casillas[0].length && !ya; j++) {
				if (casillas[i][j].darSeleccionada() == false) {
					if (casillas[i][j].esMina() == false) {
						if (casillas[i][j].darValor() > 0) {
							casillas[i][j].destapar();
							ya = true;
						}

						ms += "la casilla [" + (i + 1) + "," + (j + 1) + "] se destapo \n";
					}
				}
			}
		}
//		if (ms.equals("")) {
//			ms += "no hay pistas";
//		}
		return ms;
	}

	/*
	 * Metodo dar del atributo perdio
	 * 
	 * @return boolean el atributo
	 */
	public boolean darPerdio() {
		return perdio;
	}

}