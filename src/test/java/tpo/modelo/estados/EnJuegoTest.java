package tpo.modelo.estados;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnJuegoTest {


    @Test
    void getNameTest() {

        EnJuego enJuego = new EnJuego();

        String resultado = enJuego.getNombre();

        assertEquals("En juego", resultado);
    }
}