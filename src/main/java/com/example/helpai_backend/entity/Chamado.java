// Em src/main/java/com/example/helpai_backend/entity/Chamado.java
package com.example.helpai_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Transient; // Import para campos virtuais

@Entity 
@Table(name = "Chamado") 
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O Banco de Dados gera o ID
    @Column(name = "id_chamado")
    private Integer idChamado;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "categoria")
    private String categoria;

    @Column(name = "prioridade")
    private String prioridade;
    
    @Column(name = "status_chamado") // Mapeia o campo Java 'statusChamado'
    private String statusChamado; 
    
    @Column(name = "id_usuario_solicitante")
    private Integer idUsuarioSolicitante; 
    
    @Column(name = "id_tecnico_responsavel")
    private Integer idTecnicoResponsavel;
    
    @Column(name = "id_gerente_supervisor")
    private Integer idGerenteSupervisor;

    // --- CAMPOS VIRTUAIS ---
    @Transient // Diz ao JPA para ignorar este campo ao salvar
    private String nomeUsuario;

    @Transient 
    private String nomeTecnico;
    
    // Construtor vazio (necessário para o Hibernate/JPA)
    public Chamado() {}

    // --- GETTERS E SETTERS COMPLETOS ---

    public Integer getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(Integer idChamado) {
        this.idChamado = idChamado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(String statusChamado) {
        this.statusChamado = statusChamado;
    }

    public Integer getIdUsuarioSolicitante() {
        return idUsuarioSolicitante;
    }

    public void setIdUsuarioSolicitante(Integer idUsuarioSolicitante) {
        this.idUsuarioSolicitante = idUsuarioSolicitante;
    }

    public Integer getIdTecnicoResponsavel() {
        return idTecnicoResponsavel;
    }

    public void setIdTecnicoResponsavel(Integer idTecnicoResponsavel) {
        this.idTecnicoResponsavel = idTecnicoResponsavel;
    }

    public Integer getIdGerenteSupervisor() {
        return idGerenteSupervisor;
    }

    public void setIdGerenteSupervisor(Integer idGerenteSupervisor) {
        this.idGerenteSupervisor = idGerenteSupervisor;
    }
    
    // Getters/Setters para os campos virtuais
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getNomeTecnico() { return nomeTecnico; }
    public void setNomeTecnico(String nomeTecnico) { this.nomeTecnico = nomeTecnico; }
}