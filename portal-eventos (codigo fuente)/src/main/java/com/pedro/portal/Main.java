package com.pedro.portal;

import java.time.LocalDateTime;
import java.util.List;

import com.pedro.portal.gestion.Categoria;
import com.pedro.portal.gestion.Evento;
import com.pedro.portal.gestion.EventoOnline;
import com.pedro.portal.gestion.EventoPresencial;
import com.pedro.portal.gestion.Organizador;
import com.pedro.portal.gestion.Participante;

public class Main {
    public static void main(String[] args) {
        //creamos 2 categorias
        Categoria categoriaConferencia = new Categoria("Conferencia");
        Categoria categoriaTaller = new Categoria("Taller");

        //1 organizador para los constructores de los 2 eventos
        Organizador organizadorPedro = new Organizador("Pedro Organizador", "organizador@email.com");

        //2 eventos, 1 presencial y 1 online
        EventoPresencial eventoPresencial = new EventoPresencial("Conferencia IA", LocalDateTime.of(2025, 6, 20, 15, 0), categoriaConferencia, organizadorPedro, "Madrid");
        EventoOnline eventoOnline = new EventoOnline("Taller de Programación en Java", LocalDateTime.of(2025, 7, 10, 18, 0), categoriaTaller, organizadorPedro, "https://link-webinar.com");

        //Agregamos los eventos creados a organizador
        organizadorPedro.crearEventoPresencial("Conferencia IA", LocalDateTime.of(2025, 6, 20, 15, 0), categoriaConferencia, "Madrid");
        organizadorPedro.crearEventoOnline("Taller de Programación en Java", LocalDateTime.of(2025, 7, 10, 18, 0), categoriaTaller, "https://link-webinar.com");

        //2 participantes
        Participante participanteJuan = new Participante("Juan", "juan@email.com");
        Participante participanteMaria = new Participante("Maria", "maria@email.com");

        //Inscribimos a los participantes a los 2 eventos creados
        participanteJuan.inscribirseEnEvento(eventoPresencial);
        participanteMaria.inscribirseEnEvento(eventoOnline);

        //Con el metodo de mostrarEventosInscritos podemos ver nuestro Array de Evento[]
        participanteJuan.mostrarEventosInscritos();
        participanteMaria.mostrarEventosInscritos();

        //El organizador edita un evento, se le pasa como parametro una instancia de Evento, en este caso
        //le pasmos el eventoPresencial que creamos arriba
        organizadorPedro.editarEvento(eventoPresencial, "Conferencia Avanzada IA", LocalDateTime.of(2025, 6, 25, 16, 0), categoriaConferencia);

        //Recorremos con un for normal los eventos creados por el organizador, getEventosCreados nos devuelve el 
        //ArrayList<Evento> eventosCreados, de los eventos que se guardaron alli con el metodo de crearEventoPresencial
        //o crearEventoOnline de la clase Organizador
        
        System.out.println("Eventos creados por " + organizadorPedro.getNombre() + ":");
        List<Evento> eventos = organizadorPedro.getEventosCreados();
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println("- " + eventos.get(i).getNombre() + " Fecha: " + eventos.get(i).getFecha());
        }
    }
}