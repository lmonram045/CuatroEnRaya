package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Jugador {
	private String nombre;
	private Ficha ficha;
	public Jugador(String nombre, Ficha ficha) throws NullPointerException{
		setNombre(nombre);
		setFicha(ficha);
	}
	
	public String getNombre() {
		return nombre;
	}
	public Ficha getColorFichas() {
		return ficha;
	}
	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
		
		if (nombre.trim() == "") {
			throw new IllegalArgumentException("ERROR: El nombre no puede estar vacío.");
		}
		this.nombre = nombre;
	}
	private void setFicha(Ficha ficha) {
		if (ficha == null) {
			throw new NullPointerException("ERROR: El color de las fichas no puede ser nulo.");
		}
		this.ficha = ficha;
	}
	
}
