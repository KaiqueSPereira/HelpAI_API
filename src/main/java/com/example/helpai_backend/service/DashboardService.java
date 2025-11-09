// Em src/main/java/com/example/helpai-backend/service/DashboardService.java
package com.example.helpai_backend.service;

import com.example.helpai_backend.dto.DashboardStatsDTO;
import com.example.helpai_backend.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public DashboardStatsDTO getGlobalDashboardStats() {
        // 1. Busca os dados brutos no banco de dados
        Integer openCount = chamadoRepository.countOpenTickets();
        Integer priorityCount = chamadoRepository.countPriorityTickets();
        Integer inProgressCount = chamadoRepository.countInProgressTickets();
        Integer totalCount = chamadoRepository.countTotalTickets();

        // Garante que não há nulos
        if (openCount == null) openCount = 0;
        if (priorityCount == null) priorityCount = 0;
        if (inProgressCount == null) inProgressCount = 0;
        if (totalCount == null) totalCount = 0;

        // 2. Lógica de Negócio (cálculo de porcentagem)
        int progressPercentage = 0;
        if (totalCount > 0) {
            // A porcentagem de progresso será 'Chamados em Atendimento' / 'Total'
            progressPercentage = (inProgressCount * 100) / totalCount;
        }

        // 3. Retorna o DTO com os resultados
        return new DashboardStatsDTO(
                openCount,
                priorityCount,
                progressPercentage
        );
    }
}