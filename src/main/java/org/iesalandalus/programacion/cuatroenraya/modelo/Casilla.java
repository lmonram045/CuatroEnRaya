package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Casilla {
	private Ficha ficha;
	
	public Casilla() {
		ficha = null;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		if (ficha == null) {
			throw new NullPointerException("ERROR: No se puede poner una ficha nula.");
		}
		
		this.ficha = ficha;
	}
	
	public boolean estaOcupada() {
		if (ficha == null) {
			return false;
		} else {
			return true;
		}
	}
}
