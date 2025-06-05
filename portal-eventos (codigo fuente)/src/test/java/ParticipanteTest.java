import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pedro.portal.gestion.Categoria;
import com.pedro.portal.gestion.Evento;
import com.pedro.portal.gestion.EventoOnline;
import com.pedro.portal.gestion.EventoPresencial;
import com.pedro.portal.gestion.Organizador;
import com.pedro.portal.gestion.Participante;

public class ParticipanteTest {
    private Participante participante;
    private EventoOnline eventoOnline;
    private EventoPresencial eventoPresencial;
    private Categoria categoria;
    private Organizador organizador;

    @BeforeEach
    void setUp() {
        categoria = new Categoria("Conferencia");
        organizador = new Organizador("Pedro", "pedro@email.com");

        eventoOnline = new EventoOnline("Evento Virtual", LocalDateTime.now(), categoria, organizador, "https://evento.com");
        eventoPresencial = new EventoPresencial("Evento Presencial", LocalDateTime.now(), categoria, organizador, "Madrid");

        participante = new Participante("Juan", "juan@email.com");
    }

     @Test
    void testGetEventos() {
        assertNotNull(participante.getEventos());
        assertEquals(0, participante.getEventos().length); // Inicialmente vacío
    }

     @Test
    void testSetEventos() {
        Evento[] eventos = { eventoOnline, eventoPresencial };
        participante.setEventos(eventos);
        assertEquals(2, participante.getEventos().length);
    }

     @Test
    void testInscribirseEnEvento() {
        participante.inscribirseEnEvento(eventoOnline);
        assertEquals(1, participante.getEventos().length);
        assertEquals(eventoOnline, participante.getEventos()[0]);
    }

      @Test
    void testMostrarEventosInscritos() {
        participante.inscribirseEnEvento(eventoPresencial);
        participante.inscribirseEnEvento(eventoOnline);

        assertEquals(2, participante.getEventos().length);
    }
}
