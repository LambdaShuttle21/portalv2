package com.pedro.portal.gestion;

import java.time.LocalDateTime;

public class Inscripcion {
    private Participante usuario;
    private Evento evento;
    private LocalDateTime fechaInscripcion;
    private EstadoInscripcion estado;//Enum de estado de inscripcion 

    //getters y setters

    public Participante getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }
    
    //constructores
    public Inscripcion(Participante usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
        this.fechaInscripcion = LocalDateTime.now(); // Se registra la fecha actual de la inscripcion
        this.estado = EstadoInscripcion.CONFIRMADA; // Estado por defecto
    }

    
    public Inscripcion(Participante usuario, Evento evento, LocalDateTime fechaInscripcion, EstadoInscripcion estado) {
		super();
		this.usuario = usuario;
		this.evento = evento;
		this.fechaInscripcion = fechaInscripcion;
		this.estado = estado;
	}

    
	public Inscripcion() {
		super();
	}

	@Override
    public String toString() {
        return "Inscripción de " + usuario.getNombre() + " en " + evento.getNombre() + " el " + fechaInscripcion +
               " [Estado: " + estado + "]";
    }
}
