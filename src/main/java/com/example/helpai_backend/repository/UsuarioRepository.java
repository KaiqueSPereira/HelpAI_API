// Em src/main/java/com/example/helpai_backend/repository/UsuarioRepository.java
package com.example.helpai_backend.repository;

import com.example.helpai_backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// 1. "Estendemos" o JpaRepository, dizendo que ele gerencia a entidade 'Usuario'
//    e que a chave primária 'id_usuario' é um 'Integer'.
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // 2. Mágica do Spring Boot:
    Optional<Usuario> findByEmail(String email);
}