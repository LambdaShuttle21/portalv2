package gestion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pedro.portal.gestion.Categoria;
import com.pedro.portal.gestion.Evento;
import com.pedro.portal.gestion.EventoOnline;
import com.pedro.portal.gestion.Organizador;
import com.pedro.portal.gestion.Participante;

public class EventoTest {
    
    private EventoOnline eventoOnline;
    private Organizador organizador;
    private Categoria categoria;
    private Participante participante;

    
    @BeforeEach
    public void setUp() {
    categoria = new Categoria("Conferencia");
    organizador = new Organizador("Pedro", "pedrocazot@gmail.com");
    participante = new Participante("Juan", "juanmastantuono@gmail.com");

    eventoOnline = new EventoOnline("Evento Virtual", LocalDateTime.now(), categoria, organizador, "https://mi-evento.com");
        
    }

    @Test
    void testGetters() {
        assertEquals("Evento Virtual", eventoOnline.getNombre());
        assertEquals(categoria, eventoOnline.getCategoria());
        assertEquals(organizador, eventoOnline.getCreador());
        assertEquals("https://mi-evento.com", eventoOnline.getEnlace());
        assertNotNull(eventoOnline.getInscritos());
    }

    @Test
    void testSetters() {
        Categoria nuevaCategoria = new Categoria("Workshop");
        eventoOnline.setCategoria(nuevaCategoria);
        assertEquals(nuevaCategoria, eventoOnline.getCategoria());

        Organizador nuevoOrganizador = new Organizador("Maria", "mariamelgar@gmail.com");
        eventoOnline.setCreador(nuevoOrganizador);
        assertEquals(nuevoOrganizador, eventoOnline.getCreador());

        eventoOnline.setEnlace("https://nuevo-evento.com");
        assertEquals("https://nuevo-evento.com", eventoOnline.getEnlace());
    }

     @Test
    void testInscribirUsuario() {
        eventoOnline.inscribirUsuario(participante);
        assertEquals(1, eventoOnline.getInscritos().length);//una vez inscrito, comprobamos que sea el usuario en cuestion
        assertEquals(participante, eventoOnline.getInscritos()[0].getUsuario());
    }

    @Test
    void testUsuarioYaInscrito() {
        eventoOnline.inscribirUsuario(participante);
        eventoOnline.inscribirUsuario(participante); // Intentamos inscribirlo nuevamente
        assertEquals(1, eventoOnline.getInscritos().length);
    }
    
}
