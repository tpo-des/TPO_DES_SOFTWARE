package tpo.jugar.mapper;

import tpo.jugar.dto.UsuarioDto;
import tpo.jugar.model.usuario.Usuario;

public class UsuarioMapper {

    public static UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getPassword()
        );
    }
}
