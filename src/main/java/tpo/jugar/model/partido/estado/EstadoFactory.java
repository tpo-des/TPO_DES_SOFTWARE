package tpo.jugar.model.partido.estado;

public class EstadoFactory {

    public static EstadoPartido crear(TipoEstadoPartido tipo) {
        return switch (tipo) {
            case NECESITAMOS_JUGADORES -> new EstadoNecesitamosJugadores();
            case PARTIDO_ARMADO -> new EstadoPartidoArmado();
            case CONFIRMADO -> new EstadoConfirmado();
            case EN_JUEGO -> new EstadoEnJuego();
            case FINALIZADO -> new EstadoFinalizado();
            case CANCELADO -> new EstadoCancelado();
        };
    }

    public static TipoEstadoPartido crear(EstadoPartido estado) {
        if (estado instanceof EstadoNecesitamosJugadores) return TipoEstadoPartido.NECESITAMOS_JUGADORES;
        if (estado instanceof EstadoPartidoArmado) return TipoEstadoPartido.PARTIDO_ARMADO;
        if (estado instanceof EstadoConfirmado) return TipoEstadoPartido.CONFIRMADO;
        if (estado instanceof EstadoEnJuego) return TipoEstadoPartido.EN_JUEGO;
        if (estado instanceof EstadoFinalizado) return TipoEstadoPartido.FINALIZADO;
        if (estado instanceof EstadoCancelado) return TipoEstadoPartido.CANCELADO;
        throw new IllegalArgumentException("Tipo de estado desconocido");
    }
}
