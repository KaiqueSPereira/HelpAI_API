package com.example.helpai_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helpai_backend.entity.Usuario;

import java.util.Optional;

@Repository
//1. Nós "estendemos" o JpaRepository
//Isso nos dá métodos prontos como: save(), findById(), findAll(), delete()
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

 // 2. Mágica do Spring:
 // Ao declarar um método com este nome, o Spring automaticamente
 // cria a query SQL: "SELECT * FROM Usuario WHERE email = ?"
 Optional<Usuario> findByEmail(String email);
}