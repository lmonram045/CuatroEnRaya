package org.iesalandalus.programacion.cuatroenraya;
import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

public class MainApp {

	public static void main(String[] args) throws OperationNotSupportedException {
		
		Jugador jugador1 = Consola.leerJugador();
		Jugador jugador2;
		if (jugador1.getColorFichas() == Ficha.AZUL) {
			jugador2 = Consola.leerJugador(Ficha.VERDE);
		} else {
			jugador2 = Consola.leerJugador(Ficha.AZUL);
		}
		
		
		CuatroEnRaya partida = new CuatroEnRaya(jugador1, jugador2);
		partida.jugar();
		
	}

}
