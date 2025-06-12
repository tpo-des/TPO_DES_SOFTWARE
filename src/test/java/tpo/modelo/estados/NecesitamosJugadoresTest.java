package tpo.modelo.estados;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import tpo.modelo.Partido;
import tpo.modelo.Usuario;
import tpo.modelo.estados.NecesitamosJugadores;
import tpo.modelo.estados.PartidoArmado;


public class NecesitamosJugadoresTest {

    @Test
    void unPartidoNecesitamosJugadoresPuedeAgregarMasJugadoresTest() {
        Partido unPartidoDe2Jugador = new Partido(
                "fulbo",
                2,
                "caba",
                LocalDateTime.now().plusDays(10),
                90
        );

        Usuario unJugador = new Usuario(
                "Juan",
                "juan@juan.com",
                "flalsgha",
                "fútbol",
                Usuario.Nivel.PRINCIPIANTE,
                "caba",
                List.of() // deportes
        );

        Usuario otroJugador = new Usuario(
                "Juan2",
                "juan2@juan.com",
                "flalsgha",
                "fútbol",
                Usuario.Nivel.PRINCIPIANTE,
                "caba",
                List.of() // deportes
        );

        assertInstanceOf(NecesitamosJugadores.class, unPartidoDe2Jugador.getEstado());

        String resultadoDeAgregarUnJugador = unPartidoDe2Jugador.agregarJugador(unJugador);
        assertEquals("Faltan 1 Jugadores para Armar el Partido!!", resultadoDeAgregarUnJugador);
        assertInstanceOf(NecesitamosJugadores.class, unPartidoDe2Jugador.getEstado());

        String resultadoAgregarOtroJugador = unPartidoDe2Jugador.agregarJugador(otroJugador);
        assertEquals("El partido esta Armado!!", resultadoAgregarOtroJugador);
        assertInstanceOf(PartidoArmado.class, unPartidoDe2Jugador.getEstado());
    }

}
