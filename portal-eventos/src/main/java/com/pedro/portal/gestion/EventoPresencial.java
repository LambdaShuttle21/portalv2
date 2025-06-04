package com.pedro.portal.gestion;

import java.time.LocalDateTime;

public class EventoPresencial extends Evento{
    private String direccion;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// constructores
	public EventoPresencial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventoPresencial(String nombre, LocalDateTime fecha, Categoria categoria, Organizador creador,
			Participante[] inscritos) {
		super(nombre, fecha, categoria, creador, inscritos);
		// TODO Auto-generated constructor stub
	}

	public EventoPresencial(String nombre, LocalDateTime fecha, Categoria categoria, Organizador creador,
			String direccion) {
		super(nombre, fecha, categoria, creador);
		// TODO Auto-generated constructor stub
		this.direccion = direccion;
	}

	public EventoPresencial(String nombre, LocalDateTime fecha) {
		super(nombre, fecha);
		// TODO Auto-generated constructor stub
	}

	public EventoPresencial(String nombre, LocalDateTime fecha, String direccion) {
		super(nombre, fecha);
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "EventoPresencial [direccion=" + direccion + "]";
	}
}
