package com.pedro.portal.gestion;

public class Categoria {
    private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Categoria() {
		super();
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + "]";
	}

}
