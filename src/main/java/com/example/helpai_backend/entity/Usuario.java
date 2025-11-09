package com.example.helpai_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 1. Diz ao Spring que esta classe é uma tabela do banco
@Table(name = "Usuario") // 2. O nome exato da tabela que criamos no SQL
public class Usuario {

 @Id // 3. Marca qual é a Chave Primária (PK)
 private Integer id_usuario;

 private String nome;
 private String email;
 private String senha;
 private Integer perfil; // 0=Comum, 1=Tecnico, 2=Gerente/Admin
 private String especialidade;
 private String nivel;

 // Métodos "Getters" e "Setters"
 // (O Spring usa isso para ler e escrever os dados)

 public Integer getId_usuario() {
     return id_usuario;
 }

 public void setId_usuario(Integer id_usuario) {
     this.id_usuario = id_usuario;
 }

 public String getNome() {
     return nome;
 }

 public void setNome(String nome) {
     this.nome = nome;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getSenha() {
     return senha;
 }

 public void setSenha(String senha) {
     this.senha = senha;
 }

 public Integer getPerfil() {
     return perfil;
 }

 public void setPerfil(Integer perfil) {
     this.perfil = perfil;
 }

 public String getEspecialidade() {
     return especialidade;
 }

 public void setEspecialidade(String especialidade) {
     this.especialidade = especialidade;
 }

 public String getNivel() {
     return nivel;
 }

 public void setNivel(String nivel) {
     this.nivel = nivel;
 }
}