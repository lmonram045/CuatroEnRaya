package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;

public class Casilla {
	private Ficha ficha;
	
	public Casilla() {
		ficha = null;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) throws OperationNotSupportedException {
		if (ficha == null) {
			throw new NullPointerException("ERROR: No se puede poner una ficha nula.");
		}
		if (estaOcupada()) {
			throw new OperationNotSupportedException("ERROR: Ya contengo una ficha.");
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

	@Override
	public String toString() {		
		return String.format("%.1s", (ficha == null) ? " " : ficha);
	}
	//comentario para hacer prueba de commit
	
}
