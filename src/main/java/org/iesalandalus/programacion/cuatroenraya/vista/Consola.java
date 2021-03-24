package org.iesalandalus.programacion.cuatroenraya.vista;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.cuatroenraya.modelo.*;

public class Consola {
	private Consola() {
		
	}
	
	public static String leerNombre() {
		String nombre = new String();
		do {
			System.out.print("Introduzca el nombre de el jugador: ");
			nombre = Entrada.cadena();
		} while (nombre == null || nombre.trim() == "");
				
		return nombre;
	}
	
	public static Ficha elegirColorFichas() {
		char ficha = ' ';
		
		do {
			System.out.print("Introduzca el color de la ficha, azul o verde (A/V)");
			ficha = Entrada.caracter();
		} while (ficha != 'A' && ficha != 'V');
		
		return (ficha == 'A') ? Ficha.AZUL : Ficha.VERDE;
	}
	
	public static Jugador leerJugador() {
		Jugador jugador = new Jugador(leerNombre(), elegirColorFichas());
		return jugador;
	}
	
	public static Jugador leerJugador(Ficha ficha) {
		Jugador jugador = new Jugador(leerNombre(), ficha);
		return jugador;
	}
	
	
}
