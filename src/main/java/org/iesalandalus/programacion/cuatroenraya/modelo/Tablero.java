package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Tablero {
	//Constantes
	static final int FILAS = 6;
	static final int COLUMNAS = 7;
	static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
	
	//Declaración de array bidimensional
	Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];
	
	//Constructor por defecto, recorro array e inicializo
	public Tablero() {
		for (int i=0; i< FILAS; i++) {
			for (int j=0;j < COLUMNAS; j++) {
	    		 casillas[FILAS][COLUMNAS] = new Casilla();
	        }
	    }
	}
}
