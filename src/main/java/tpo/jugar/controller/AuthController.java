package tpo.jugar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpo.jugar.dto.AuthRequest;
import tpo.jugar.dto.AuthResponse;
import tpo.jugar.dto.UsuarioDto;
import tpo.jugar.mapper.UsuarioMapper;
import tpo.jugar.model.usuario.Usuario;
import tpo.jugar.service.UsuarioService;
import tpo.jugar.service.imp.JwtService;
import tpo.jugar.service.imp.UserDetailsServiceImp;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserDetailsServiceImp userDetailsService;
    private final BCryptPasswordEncoder encoder;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authManager, JwtService jwtService,
                          UserDetailsServiceImp userDetailsService, BCryptPasswordEncoder encoder, UsuarioService usuarioService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDto> register(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDto);
        return ResponseEntity.ok(UsuarioMapper.toDto(usuarioService.create(usuario)));
    }
}
