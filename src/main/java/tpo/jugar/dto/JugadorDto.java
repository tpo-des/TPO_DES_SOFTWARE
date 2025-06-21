package tpo.jugar.dto;

public class JugadorDto {
    private Long partidoId;
    private Long usuarioId;
    private Boolean confirmado;

    public JugadorDto(Long partidoId, Long usuarioId, Boolean confirmado) {
        this.partidoId = partidoId;
        this.usuarioId = usuarioId;
        this.confirmado = confirmado;
    }

    public Long getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(Long partidoId) {
        this.partidoId = partidoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }
}
