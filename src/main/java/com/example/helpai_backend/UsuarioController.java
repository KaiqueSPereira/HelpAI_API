package com.example.helpai_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.helpai_backend.entity.Usuario;

import java.util.Map;
import java.util.Optional;

@RestController // 1. Diz ao Spring que esta classe define URLs de API
public class UsuarioController {

 // 2. "Injeção de Dependência": Pede ao Spring para nos dar
 //    uma instância daquele Repositório que acabamos de criar.
 @Autowired
 private UsuarioRepository usuarioRepository;

 /**
  * Endpoint 1: POST /login
  * Recebe um JSON com "email" e "senha"
  */
 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
     String email = loginData.get("email");
     String senha = loginData.get("senha");

     // 3. Usa o Repositório para buscar o usuário no banco pelo email
     Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

     // 4. Verifica se o usuário existe e se a senha bate
     if (usuarioOptional.isPresent()) {
         Usuario usuario = usuarioOptional.get();
         if (usuario.getSenha().equals(senha)) {
             // Sucesso! Retorna os dados do usuário
             return ResponseEntity.ok(usuario);
         } else {
             // Senha errada
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
         }
     } else {
         // Usuário não encontrado
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
