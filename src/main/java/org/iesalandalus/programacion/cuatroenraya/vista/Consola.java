package org.iesalandalus.programacion.cuatroenraya.vista;

import org.iesalandalus.programacion.utilidades.Entrada;

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
}
