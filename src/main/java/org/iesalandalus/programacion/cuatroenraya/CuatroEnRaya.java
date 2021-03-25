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
		if (jugador1 == null || jugador2 == null) {
			throw new IllegalArgumentException("El jugador no puede ser nulo");
		}
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
		tablero = new Tablero();
	}

	// Devuelve true si la jugada es ganadora y false si no
	private boolean tirar(Jugador jugador) {
		int columna;
		boolean finalizar = false;
		boolean resultado = false;
		do {
			columna = Consola.leerColumna(jugador);
			try {
				resultado = tablero.introducirFicha(columna, jugador.getColorFichas());
				finalizar = true;
			} catch (OperationNotSupportedException e) {
				System.out.println("La columna está llena, repita la tirada.");
			}

		} while (!finalizar);

		return resultado;
	}

	public void jugar() throws OperationNotSupportedException {
		int i = 0;// variable para controlar el array de jugadores
		boolean resultado;
		boolean finalizar = false;
		do {
			System.out.println(tablero.toString());
			resultado = tirar(jugadores[i]);

			// Si el jugador ha ganado
			if (resultado) {
				finalizar = true;
				System.out.println(tablero.toString());
				System.out.println(jugadores[i].getNombre() + " has ganado la partida");
			} else {
				if (tablero.estaLleno()) {
					finalizar = true;
					System.out.println(tablero.toString());
					System.out.println("Partida finalizada, el tablero está lleno");
				}
			}
			i = (i == 0) ? 1 : 0;
		} while (!finalizar);

	}
}
