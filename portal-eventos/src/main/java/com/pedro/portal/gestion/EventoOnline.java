package com.pedro.portal.gestion;

import java.time.LocalDateTime;

public class EventoOnline extends Evento{
    private String enlace;

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public EventoOnline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventoOnline(String nombre, LocalDateTime fecha, Categoria categoria, Organizador creador,
			Participante[] inscritos) {
		super(nombre, fecha, categoria, creador, inscritos);
		// TODO Auto-generated constructor stub
	}

	public EventoOnline(String nombre, LocalDateTime fecha, Categoria categoria, Organizador creador, String enlace) {
		super(nombre, fecha, categoria, creador);
		this.enlace = enlace;
		// TODO Auto-generated constructor stub
	}

	public EventoOnline(String nombre, LocalDateTime fecha) {
		super(nombre, fecha);
		// TODO Auto-generated constructor stub
	}

	public EventoOnline(String nombre, LocalDateTime fecha, String enlace) {
		super(nombre, fecha);
		this.enlace = enlace;
	}
}
