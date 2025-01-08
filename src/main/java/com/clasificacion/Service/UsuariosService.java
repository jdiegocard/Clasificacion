package com.clasificacion.Service;

import com.clasificacion.Entity.UsuariosEntity;
import com.clasificacion.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Método para listar todos los usuarios
    public List<UsuariosEntity> listarTodos() {
        return usuariosRepository.findAll();
    }

    // Método para validar el login
    public UsuariosEntity validarLogin(String identificacion, String password) {
        UsuariosEntity usuario = usuariosRepository.findByIdentificacion(identificacion)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Generar el hash SHA-256 de la contraseña proporcionada
        String hashedPassword = hashPasswordSHA256(password);

        // Comparar la contraseña encriptada con la almacenada
        if (!hashedPassword.equals(usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario; // Retornar el usuario si las credenciales son correctas
    }

    // Método para generar el hash SHA-256 de una contraseña
    private String hashPasswordSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());

            // Convertir el hash a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar el hash de la contraseña", e);
        }
    }
}
