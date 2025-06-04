package com.pedro.portal.gestion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Organizador extends Usuario{
    private Evento evento;// crear nuevos eventos y si es necesario, modificarlos
	private List<Evento> eventosCreados;// Eventos creados

	// getters y setters

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getEventosCreados() {
		return eventosCreados;
	}

	public void setEventosCreados(List<Evento> eventosCreados) {
		if (eventosCreados == null) {
			this.eventosCreados = new ArrayList<>(); // Previene NullPointerException
		} else {
			this.eventosCreados = eventosCreados;
		}
	}

	// constructores
	public Organizador(String nombre, String correo, Evento evento, Evento[] eventos) {
		super(nombre, correo);
		this.evento = evento;
		this.eventosCreados = new ArrayList<>();
	}

	public Organizador(String nombre, String correo, List<Evento> eventosCreados) {
		super(nombre, correo);
		setEventosCreados(eventosCreados);
	}

	public Organizador() {
		super();
		this.eventosCreados = new ArrayList<>();
	}

	public Organizador(String nombre, String correo) {
		super(nombre, correo);
		this.eventosCreados = new ArrayList<>();
	}

	// metodos
	// edita el nombre del evento
	// Aunque no puedes instanciar Evento directamente, puedes modificar cualquier
	// objeto que pertenezca a una subclase de Evento.
	public void editarEvento(Evento evento, String nuevoNombre, LocalDateTime nuevaFecha, Categoria nuevaCategoria) {
		if (evento != null) {
			evento.setNombre(nuevoNombre);
			evento.setFecha(nuevaFecha);
			evento.setCategoria(nuevaCategoria);
			System.out.println("Evento editado por " + nombre + ": " + nuevoNombre + ", Fecha: " + nuevaFecha
					+ ", Categoria: " + nuevaCategoria.getNombre());
		} else {
			System.out.println("No se puede editar un evento nulo.");
		}
	}

	/*
	 * ejemplo, los eventos deben estar clasificados por categorías, como le
	 * mencioné antes, y esa clasificación debería ser parte del sistema también. Es
	 * decir, cuando alguien cree un evento, el sistema debería preguntarle a qué
	 * categoría pertenece ese evento, si es una conferencia, un taller o lo que
	 * sea.
	 */
	public void crearEventoOnline(String nombre, LocalDateTime fecha, Categoria categoria, String enlace) {
		EventoOnline online = new EventoOnline(nombre, fecha, categoria, this, enlace);
		if (eventosCreados == null) {
			eventosCreados = new ArrayList<>();
		}
		eventosCreados.add(online);
	}

	public void crearEventoPresencial(String titulo, LocalDateTime fecha, Categoria categoria, String ubicacion) {
		EventoPresencial presencial = new EventoPresencial(titulo, fecha, categoria, this, ubicacion);
		if (eventosCreados == null) {
			eventosCreados = new ArrayList<>(); // Evita NullPointerException
		}
		eventosCreados.add(presencial);
	}
}
