package com.example.helpai_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.helpai_backend.entity.Usuario;
import com.example.helpai_backend.repository.UsuarioRepository;

import java.util.Map;
import java.util.Optional;

@RestController // 1. Diz ao Spring que esta classe define URLs de API
public class UsuarioController {

 @Autowired
 private UsuarioRepository usuarioRepository;

 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
     String email = loginData.get("email");
     String senha = loginData.get("senha");

     Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

     if (usuarioOptional.isPresent()) {
         Usuario usuario = usuarioOptional.get();
         if (usuario.getSenha().equals(senha)) {
             return ResponseEntity.ok(usuario);
         } else {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
         }
     } else {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
     }
 }
 
 /**
  * Endpoint Bônus: GET /usuarios
  * (Apenas para testar se a conexão com o banco está funcionando)
  */
 @GetMapping("/usuarios")
 public ResponseEntity<?> getAllUsuarios() {
     // Usa o método pronto "findAll()" do repositório
     return ResponseEntity.ok(usuarioRepository.findAll());
 }
}
