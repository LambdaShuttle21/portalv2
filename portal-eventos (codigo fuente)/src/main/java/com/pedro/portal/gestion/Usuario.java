package com.pedro.portal.gestion;

public abstract class Usuario {
    protected String nombre;
	protected String correo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	// constructores

	public Usuario(String nombre, String correo) {
		super();
		this.nombre = nombre;
		this.correo = correo;
	}

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correo=" + correo + "]";
	}
}
