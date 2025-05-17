package tpo.modelo.estados;

import org.junit.jupiter.api.Test;
import tpo.modelo.Partido;
import tpo.modelo.Usuario;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NecesitamosJugadoresTest {

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
                "tu vieja",
                Usuario.Nivel.PRINCIPIANTE,
                "caba"
        );

        Usuario otroJugador = new Usuario(
                "Juan2",
                "juan2@juan.com",
                "flalsgha",
                "tu vieja",
                Usuario.Nivel.PRINCIPIANTE,
                "caba"
        );

        // valido que el partido esta en estado de que necesita jugadores
        assertInstanceOf(NecesitamosJugadores.class, unPartidoDe2Jugador.getEstado());

        // agrego jugador
        String resultadoDeAgregarUnJugador = unPartidoDe2Jugador.agregarJugador(unJugador);

        // valido que el partido cambio la cantidad de jugadores
        assertEquals("Faltan 1 Jugadores para Armar el Doparti!!", resultadoDeAgregarUnJugador);
        assertInstanceOf(NecesitamosJugadores.class, unPartidoDe2Jugador.getEstado());

        // agrego otro jugador
        String resultadoAgregarOtroJugador = unPartidoDe2Jugador.agregarJugador(otroJugador);

        // valido que el partido cambio de estado
        assertEquals("El partido esta Armado!!", resultadoAgregarOtroJugador);
        assertInstanceOf(PartidoArmado.class, unPartidoDe2Jugador.getEstado());
    }
}