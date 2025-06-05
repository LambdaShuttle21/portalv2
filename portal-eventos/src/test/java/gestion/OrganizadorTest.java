package gestion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pedro.portal.gestion.Categoria;
import com.pedro.portal.gestion.Evento;
import com.pedro.portal.gestion.EventoOnline;
import com.pedro.portal.gestion.EventoPresencial;
import com.pedro.portal.gestion.Organizador;

public class OrganizadorTest {
    private Organizador organizador;
    private Categoria categoria;
    private EventoOnline eventoOnline;
    private EventoPresencial eventoPresencial;

    @BeforeEach
    void setUp() {
        categoria = new Categoria("Conferencia");
        organizador = new Organizador("Pedro", "pedro@email.com");

        eventoOnline = new EventoOnline("Evento Virtual", LocalDateTime.now(), categoria, organizador, "https://evento.com");
        eventoPresencial = new EventoPresencial("Evento Presencial", LocalDateTime.now(), categoria, organizador, "Madrid");
    }

     @Test
    void testGetters() {
        assertEquals("Pedro", organizador.getNombre());
        assertEquals("pedro@email.com", organizador.getCorreo());
        assertNotNull(organizador.getEventosCreados());
    }

    @Test
    void testSetEventosCreados() {
        List<Evento> eventos = new ArrayList<>();
        eventos.add(eventoOnline);
        eventos.add(eventoPresencial);

        organizador.setEventosCreados(eventos);
        assertEquals(2, organizador.getEventosCreados().size());
    }

     @Test
    void testEditarEvento() {
        organizador.editarEvento(eventoOnline, "Nuevo Nombre", LocalDateTime.now().plusDays(5), categoria);
        assertEquals("Nuevo Nombre", eventoOnline.getNombre());
        assertEquals(categoria, eventoOnline.getCategoria());
    }

    @Test
    void testCrearEventoOnline() {
        organizador.crearEventoOnline("Evento Stream", LocalDateTime.now(), categoria, "https://link.com");
        assertEquals(1, organizador.getEventosCreados().size());
        assertTrue(organizador.getEventosCreados().get(0) instanceof EventoOnline);//verificamos
        //que el evento creado por organizador sea de la clase EventoOnline con instanceof
    }

    @Test
    void testCrearEventoPresencial() {
        organizador.crearEventoPresencial("Charla en Madrid", LocalDateTime.now(), categoria, "Madrid");
        assertEquals(1, organizador.getEventosCreados().size());
        assertTrue(organizador.getEventosCreados().get(0) instanceof EventoPresencial);
    }
}
