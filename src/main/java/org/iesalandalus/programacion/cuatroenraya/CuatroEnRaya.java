package org.iesalandalus.programacion.cuatroenraya;

import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.modelo.Tablero;

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
	
	private boolean tirar(Jugador jugador) {
		
	}
}

