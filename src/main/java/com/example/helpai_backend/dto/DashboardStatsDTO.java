// Em src/main/java/com/example/helpai_backend/dto/DashboardStatsDTO.java
package com.example.helpai_backend.dto;

public class DashboardStatsDTO {
    private Integer abertas;
    private Integer prioritarias;
    private Integer progresso;

    public DashboardStatsDTO(Integer abertas, Integer prioritarias, Integer progresso) {
        this.abertas = abertas;
        this.prioritarias = prioritarias;
        this.progresso = progresso;
    }

    public DashboardStatsDTO(Integer openCount, Integer priorityCount, int progressPercentage) {
		// TODO Auto-generated constructor stub
	}

	// Getters
    public Integer getAbertas() { return abertas; }
    public Integer getPrioritarias() { return prioritarias; }
    public Integer getProgresso() { return progresso; }

    // Setters
    public void setAbertas(Integer abertas) { this.abertas = abertas; }
    public void setPrioritarias(Integer prioritarias) { this.prioritarias = prioritarias; }
    public void setProgresso(Integer progresso) { this.progresso = progresso; }
}