// Em src/main/java/com/example/helpai-backend/repository/ChamadoRepository.java
package com.example.helpai_backend.repository;

import com.example.helpai_backend.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    // 1. Conta todos os chamados com status 'Aberto'
    @Query(value = "SELECT COUNT(id_chamado) FROM Chamado WHERE status_chamado = 'Aberto'", nativeQuery = true)
    Integer countOpenTickets();

    // 2. Conta todos os chamados Abertos E de Prioridade Alta/Crítica (para o card vermelho)
    @Query(value = "SELECT COUNT(id_chamado) FROM Chamado WHERE status_chamado = 'Aberto' AND (prioridade = 'Alta' OR prioridade = 'Crítica')", nativeQuery = true)
    Integer countPriorityTickets();

    // 3. Conta todos os chamados com status 'Em Atendimento'
    @Query(value = "SELECT COUNT(id_chamado) FROM Chamado WHERE status_chamado = 'Em Atendimento'", nativeQuery = true)
    Integer countInProgressTickets();

    // 4. Conta o total de chamados para calcular o progresso
    @Query(value = "SELECT COUNT(id_chamado) FROM Chamado", nativeQuery = true)
    Integer countTotalTickets();
}