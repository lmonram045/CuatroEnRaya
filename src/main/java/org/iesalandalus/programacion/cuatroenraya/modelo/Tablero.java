package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Tablero {
	//Constantes, toma la FILA 0 como la de abajo y la FILA 5 como la de arriba,
	//toma la COLUMNA 0 como la de la izquierda
	static final int FILAS = 5;
	static final int COLUMNAS = 6;
	static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
	
	//Declaración de array bidimensional
	Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];
	
	//Constructor por defecto, recorro array e inicializo
	public Tablero() {
		for (int i=0; i<= FILAS; i++) {
			for (int j=0;j <= COLUMNAS; j++) {
	    		 casillas[i][j] = new Casilla();
	        }
	    }
	}
	
	//Método para saber si una columna esta vacía
	private boolean columnaVacia(int columna) {
		for (int i=0; i <= FILAS; i++) {
			if (casillas[i][columna].estaOcupada()) {
				return false;
			}
		}
		return true;
	}
	
	//Método para saber si el tablero está vacío.
	public boolean estaVacio() {
		for (int i = 0; i <= COLUMNAS; i++) {
			if (!columnaVacia(i)) {
				return false;
			}
		}
		return true;
	}
	
	//Método para saber si una columna está llena
	private boolean columnaLlena(int columna) {
		for (int i = 0; i <= FILAS; i++) {
			if (!casillas[i][columna].estaOcupada()) {
				return false;
			}
		}
		return true;
	}
	
	//Método para saber si el tablero está lleno.
	public boolean estaLleno() {
		for (int i = 0; i <= COLUMNAS; i++) {
			if (!columnaLlena(i)) {
				return false;
			}
		}
		return true;
	}
	
	//Método para comprobar si una ficha pasada por parámetro es correcta.
	private void comprobarFicha(Ficha ficha) {
		if (ficha == null) {
			throw new NullPointerException("ERROR: La ficha no puede ser nula.");
		}
	}
	
	//Método para comprobar que una columna es correcta
	private void comprobarColumna(int columna) {
		if (columna < 1 || columna > COLUMNAS) {
			throw new IllegalArgumentException("ERROR: Columna incorrecta.");
		}
	}
	
	//Método para saber la primera fila vacía de una columna.
	private int getPrimeraFilaVacia(int columna) {
		for (int i = 0; i <= FILAS; i++) {
			if (!casillas[i][columna].estaOcupada()) {
				return i;
			}
		}
		return -1; //Retorno -1 si la columna estuviera llena.
	}
	
	//Método para comprobar si el objetivo ha sido alcanzado.
	private boolean objetivoAlcanzado(int fichasConsecutivas) {
		if (fichasConsecutivas >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {
			return true;
		}
		return false;
	}
	
}
