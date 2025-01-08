package com.clasificacion.Controller;

import com.clasificacion.Entity.UsuariosEntity;
import com.clasificacion.Service.UsuariosService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class Login {

        @Autowired
        private UsuariosService usuariosService;

        // Genera una clave segura para HS256
        private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        @GetMapping
        public List<UsuariosEntity> getAllUsers() {
        return usuariosService.listarTodos();
        }

        @PostMapping
        public Map<String, Object> login(@RequestBody Map<String, String> datos) {
                String identificacion = datos.get("identificacion");
                String password = datos.get("password");

                // Validar el usuario con las credenciales proporcionadas
                UsuariosEntity usuario = usuariosService.validarLogin(identificacion, password);

                // Generar el token JWT
                String token = Jwts.builder()
                                .setSubject(usuario.getIdentificacion())
                                .claim("nombre", usuario.getNombre())
                                .claim("id", usuario.getId())
                                .setIssuedAt(new Date())
                                .setExpiration(new Date(System.currentTimeMillis() + 300)) // Expiración en 5 minutos
                                .signWith(SECRET_KEY)
                                .compact();

                // Crear la respuesta
                Map<String, Object> respuesta = new HashMap<>();
                respuesta.put("token", token);
                respuesta.put("usuario", usuario);
                return respuesta;
        }
}
