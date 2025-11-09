package com.example.helpai_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Chamado") 
public class Chamado {

 @Id 
 private Integer id_chamado;

 private String titulo;
 private String descricao;
 private String categoria;
 private String prioridade;
 private String status_chamado;
 
 // Foreign Keys
 private Integer id_usuario_solicitante;
 private Integer id_tecnico_responsavel;
 private Integer id_gerente_supervisor;

 public Chamado() {}

 // Você deve adicionar todos os Getters e Setters para todos os campos.
 // Exemplo:
 public Integer getId_chamado() { return id_chamado; }
 public void setId_chamado(Integer id_chamado) { this.id_chamado = id_chamado; }

 public String getTitulo() { return titulo; }
 public void setTitulo(String titulo) { this.titulo = titulo; }
 
 public String getDescricao() {return descricao; }
 public void setDescricao(String descricao) {this.descricao = descricao;}
 
 public String getCategoria() {return categoria; }
 public void setCategoria(String categoria) {this.categoria= categoria;}
 
 public String getPrioridade() {return prioridade; }
 public void setPrioridade(String prioridade) {this.prioridade = prioridade;}
 
 public String getStatatus_Chamado() {return status_chamado; }
 public void setStatus_Chamado(String status_chamado) {this.status_chamado= status_chamado;}
 
 public Integer getId_usuario_solicitante() { return id_usuario_solicitante; }
 public void setId_usuario_solicitante(Integer id_usuario_solicitante) { this.id_usuario_solicitante = id_usuario_solicitante; }

 public Integer getId_tecnico_responsavel() {
	return id_tecnico_responsavel;
 }

 public void setId_tecnico_responsavel(Integer id_tecnico_responsavel) {
	this.id_tecnico_responsavel = id_tecnico_responsavel;
 }

 public Integer getId_gerente_supervisor() {
	return id_gerente_supervisor;
 }

 public void setId_gerente_supervisor(Integer id_gerente_supervisor) {
	this.id_gerente_supervisor = id_gerente_supervisor;
 }
 

 
}