package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Tablero {
	//Constantes
	static final int FILAS = 6;
	static final int COLUMNAS = 7;
	static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
	
	//Declaración de array bidimensional
	Casilla[][] casilla = new Casilla[FILAS][COLUMNAS];
}
