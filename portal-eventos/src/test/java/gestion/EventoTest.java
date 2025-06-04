package gestion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pedro.portal.gestion.Evento;
import com.pedro.portal.gestion.Participante;

public class EventoTest {
    
    private Evento evento;
    private Participante participante1;
    private Participante participante2;
    
    @BeforeEach
    public void setUp() {
        evento = new Evento("Conferencia Java", LocalDateTime.now()) {
            // Implementación mínima para poder instanciar `Evento` (porque es abstracta)
        };
        participante1 = new Participante("Pedro", "pedrocazot@gmail.com");
        participante2 = new Participante("Ana", "anamena@gmail.com");
    }
    
    @Test
    public void testInscripcionUsuarioNuevo() {
        evento.inscribirUsuario(participante1);
        assertEquals(1, evento.getInscritos().length, "El usuario debería estar inscrito.");
    }

    
}
