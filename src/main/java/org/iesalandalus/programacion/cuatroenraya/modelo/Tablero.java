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
	
	//Método para comprobar si hay 4 consecutivas en una fila
	private boolean comprobarHorizontal(int fila, Ficha ficha) {
		int fichasConsecutivas = 0;
		for (int columna = 0; columna <= COLUMNAS; columna++) {
			if (casillas[fila][columna].estaOcupada() && casillas[fila][columna].getFicha() == ficha) {
				fichasConsecutivas++;
				if (objetivoAlcanzado(fichasConsecutivas)) {
					return (objetivoAlcanzado(fichasConsecutivas));
				}
			} else {
				fichasConsecutivas = 0;
			}
		}
		return (objetivoAlcanzado(fichasConsecutivas));
	}
	
	//Método para comprobar si hay 4 consecutivas en una columna.
	private boolean comprobarVertical(int columna, Ficha ficha) {
		int fichasConsecutivas = 0;
		for (int fila = 0; fila <= FILAS; fila++) {
			if (casillas[fila][columna].estaOcupada() && casillas[fila][columna].getFicha() == ficha) {
				fichasConsecutivas++;
				if (objetivoAlcanzado(fichasConsecutivas)) {
					return (objetivoAlcanzado(fichasConsecutivas));
				}
			} else {
				fichasConsecutivas = 0;
			}
		}
		return (objetivoAlcanzado(fichasConsecutivas));
	}
	
	//Método para comprobar el menor de 2 numeros
	private int menor(int primerNumero, int segundoNumero) {
		if (primerNumero <= segundoNumero) {
			return primerNumero;
		} else {
			return segundoNumero;
		}
	}
	
	//Método para comprobar si hay 4 consecutivas en la diagonal NE a partir de una fila, columna y color de ficha.
	private boolean comprobarDiagonalNE(int fila, int columna, Ficha ficha) {
		//variables
		int fichasConsecutivas = 0;
		int desplazamiento = menor(fila, columna);
		int filaInicial = fila - desplazamiento;
		int columnaInicial = columna - desplazamiento;
		//Bucle for que recorre las columnas, desde la minima posible hasta la maxima posible
		for (columnaInicial = columnaInicial; columnaInicial <= COLUMNAS; columnaInicial++) {
			//con este if, compruebo que no se ha pasado de fila
			if (filaInicial <= FILAS) {
				//if para comprobar si una casilla esta ocupada y es del mismo color que el pasado al metodo.
				if (casillas[filaInicial][columnaInicial].estaOcupada() && casillas[filaInicial][columnaInicial].getFicha() == ficha) {
					//si es correcto, aumento fichasConsecutivas, y si alcanzo 4, retorno objetivoAlcanzado
					fichasConsecutivas++;
					if (objetivoAlcanzado(fichasConsecutivas)) {
						return (objetivoAlcanzado(fichasConsecutivas));
					}
				} else {
					//si no esta ocupada una casilla vuelve a poner el contador a 0
					fichasConsecutivas = 0;
				}
				//aumento la fila para poder seguir las comprobaciones, la columna ya la aumenta el bucle for
				filaInicial++;
			//en este else le digo que si ya a alcanzado la fila tope, termine el metodo con un return
			} else {
				return (objetivoAlcanzado(fichasConsecutivas));
			}
		}
		return (objetivoAlcanzado(fichasConsecutivas));
	}
}
