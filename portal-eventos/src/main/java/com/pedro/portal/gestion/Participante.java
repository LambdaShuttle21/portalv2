package com.pedro.portal.gestion;

import java.util.Arrays;

public class Participante extends Usuario{
    private Evento[] eventos; 

    // Getters y Setters
    public Evento[] getEventos() {
        return eventos;
    }

    public void setEventos(Evento[] eventos) {
        if (eventos == null) {
            this.eventos = new Evento[0];//inicializamos el array en cada constructor para evitar
            //la excepcion de NullPointerException al no inicializarlo
        } else {
            this.eventos = eventos;
        }
    }

    // Constructores corregidos
    public Participante() {
        super();
        this.eventos = new Evento[0]; 
    }

    public Participante(String nombre, String correo) {
        super(nombre, correo);
        this.eventos = new Evento[0]; 
    }

    public Participante(String nombre, String correo, Evento[] eventos) {
        super(nombre, correo);
        setEventos(eventos);
    }

    // Métodos
    public void inscribirseEnEvento(Evento evento) {
        if (eventos == null) {
            eventos = new Evento[0]; 
        }

        evento.inscribirUsuario(this);//utiliza la funcion de Evento para inscribir a un participante en un evento
        //this hace referencia a una instancia de Participante

        // Agregar el evento al array de eventos inscritos
        Evento[] copiaEventos = Arrays.copyOf(eventos, eventos.length + 1);
        copiaEventos[copiaEventos.length - 1] = evento;
        eventos = copiaEventos;
    }

    public void mostrarEventosInscritos() {
        if (eventos == null || eventos.length == 0) {
            System.out.println(nombre + " no está inscrito en ningún evento.");
            return;
        }

        System.out.println("Eventos en los que está inscrito " + nombre + ":");
        for (int i = 0; i < eventos.length; i++) { // Usando un for normal
            System.out.println("- " + eventos[i].getNombre() + " | Fecha: " + eventos[i].getFecha());
        }
    }
}
