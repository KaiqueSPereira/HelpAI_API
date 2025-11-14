// Em src/main/java/com/example/helpai-backend/service/ChamadoService.java
package com.example.helpai_backend.service;

import com.example.helpai_backend.entity.Chamado;
import com.example.helpai_backend.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    /**
     * Retorna todos os chamados.
     */
    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    /**
     * Recebe um chamado novo do app e aplica a lógica de atribuição de status.
     */
    public Chamado createChamado(Chamado novoChamado) {
        
        // 1. Lógica de Validação:
        if (novoChamado.getTitulo() == null || novoChamado.getDescricao() == null) {
            throw new IllegalArgumentException("Título e descrição são obrigatórios.");
        }
        
        // 2. ATRIBUIÇÃO INICIAL (APENAS LÓGICA)
        
        // **CORRIGIDO**
        // O status é checado usando getStatus_chamado() e definido usando setStatus_chamado()
        if (novoChamado.getstatus_chamado() == null || novoChamado.getStatus_chamado().isEmpty()) {
            novoChamado.setStatus_chamado("Aberto");
        }
        
        // **CORRIGIDO**
        // Prioridade inicial definida para pendente de IA, conforme regra 2.3.2
        if (novoChamado.getPrioridade() == null || novoChamado.getPrioridade().isEmpty()) {
             novoChamado.setPrioridade("Triagem Pendente"); 
        }

        // Técnico, Gerente e Solicitante (pendente de autenticação JWT real)
        if (novoChamado.getIdUsuarioSolicitante() == null || novoChamado.getIdUsuarioSolicitante() == 0) {
            novoChamado.setIdUsuarioSolicitante(1); 
        }
        
        novoChamado.setIdTecnicoResponsavel(null);
        novoChamado.setIdGerenteSupervisor(null);
        
        // 4. Salva no banco de dados Azure
        return chamadoRepository.save(novoChamado);
    }
}