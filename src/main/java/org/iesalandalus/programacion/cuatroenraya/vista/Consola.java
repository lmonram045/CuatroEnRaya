package org.iesalandalus.programacion.cuatroenraya.vista;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;

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
		int ficha = 0;
		
		do {
			System.out.print("Introduzca el color de la ficha, azul o verde (0 - AZUL / 1 - VERDE: ");
			ficha = Entrada.entero();
		} while (ficha != 0 && ficha != 1);
		
		return (ficha == 0) ? Ficha.AZUL : Ficha.VERDE;
	}
	
	public static Jugador leerJugador() {
		Jugador jugador = new Jugador(leerNombre(), elegirColorFichas());
		return jugador;
	}
	
	public static Jugador leerJugador(Ficha ficha) {
		Jugador jugador = new Jugador(leerNombre(), ficha);
		return jugador;
	}
	
	public static int leerColumna(Jugador jugador) {
		int columna;
		do {
			System.out.print(jugador.getNombre() + " introduzca la columna en la que desea realizar la tirada (0/6): ");
			columna = Entrada.entero();
			
			if (columna < 0 || columna > 6) {
				System.out.println("La columna no existe, repita la tirada.");
			}
		} while (columna < 0 || columna > 6);
		
		return columna;
	}
	
}
