package org.iesalandalus.programacion.cuatroenraya;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.modelo.Tablero;
import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

public class CuatroEnRaya {
	static final int NUMERO_JUGADORES = 2;
	Jugador[] jugadores = new Jugador[NUMERO_JUGADORES];
	Tablero tablero;
	
	public CuatroEnRaya(Jugador jugador1, Jugador jugador2) {
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
		tablero = new Tablero();
		//no se si tengo que hacer algo mas para comprobar según el enunciado
	}
	
	private boolean tirar(Jugador jugador) throws OperationNotSupportedException {
		int columna = Consola.leerColumna(jugador);
		do {
			tablero.introducirFicha(columna, jugador.getColorFichas());
			//me falta que capture la excepcion de introducirFicha, y que cuando salte esa excepcion repita el proceso
			//mirar en los test para intentar sacar de ahí como lo hace el profesor.
		} while (!tablero.introducirFicha(columna, jugador.getColorFichas()));
		
	}
}

