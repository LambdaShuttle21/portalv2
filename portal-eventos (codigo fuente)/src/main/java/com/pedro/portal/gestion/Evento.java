package com.pedro.portal.gestion;

import java.time.LocalDateTime;
import java.util.Arrays;

public abstract class Evento {
    protected String nombre;
    protected LocalDateTime fecha;
    protected Categoria categoria;
    protected Organizador creador;
    protected Inscripcion[] inscritos;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Organizador getCreador() {
        return creador;
    }

    public void setCreador(Organizador creador) {
        this.creador = creador;
    }

    public Inscripcion[] getInscritos() {
        return inscritos;
    }

    public void setInscritos(Inscripcion[] inscritos) {
        if (inscritos == null) {
            this.inscritos = new Inscripcion[0];
        } else {
            this.inscritos = inscritos;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    // Constructores corregidos
    public Evento(String nombre, LocalDateTime fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.inscritos = new Inscripcion[0];
    }

    public Evento(String nombre, LocalDateTime fecha, Categoria categoria, Organizador creador,
                  Participante[] inscritos) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.categoria = categoria;
        this.creador = creador;
        this.inscritos = new Inscripcion[0]; 
    }

    public Evento(String nombre, LocalDateTime fecha, Categoria categoria, Organizador creador) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.categoria = categoria;
        this.creador = creador;
        this.inscritos = new Inscripcion[0];
    }

    public Evento() {
        this.inscritos = new Inscripcion[0]; 
    }

    //metodos
    
    public void inscribirUsuario(Participante participante) {
        if (inscritos == null) {
            inscritos = new Inscripcion[0];//correccion de bug al no inicializar el array
        }

        // Validamos que el usuario no se encuentre en el array con nuestro booleano
        boolean inscrito = false;
        for (int i = 0; i < inscritos.length; i++) {
        Inscripcion inscripcion = inscritos[i];
        if (inscripcion.getUsuario().equals(participante)) {
        System.out.println(participante.getNombre() + " ya está inscrito en: " + nombre);
        inscrito = true;
        break;
    }
}

        //Si no, lo aniadimos
        if (!inscrito) {
            System.out.println("Usuario no encontrado, se procede a inscribir a " + participante.getNombre());
            Inscripcion nuevaInscripcion = new Inscripcion(participante, this);

            //redimension manual del array
            Inscripcion[] copiaInscritos = Arrays.copyOf(inscritos, inscritos.length + 1);
            copiaInscritos[copiaInscritos.length - 1] = nuevaInscripcion;
            inscritos = copiaInscritos;

            System.out.println(participante.getNombre() + " se ha inscrito en: " + nombre);
        }
    }
}
