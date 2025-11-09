// Em src/main/java/com/example/helpai-backend/service/ChamadoService.java
package com.example.helpai_backend.service;

import com.example.helpai_backend.entity.Chamado;
import com.example.helpai_backend.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;



@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    /**
     * Retorna todos os chamados para a TicketsActivity.
     */
    public List<Chamado> findFiltered(int perfil, String status, Integer solicitanteId) {
        // No mundo real, esta lógica seria traduzida em uma query SQL dinâmica.
        // Por enquanto, vamos retornar todos os chamados e deixar o app filtrar, mas o endpoint
        // está pronto para a regra de negócio correta ser implementada aqui.
        return chamadoRepository.findAll();
    }

    /**
     * Recebe um chamado novo do app e aplica a lógica de triagem e IA (simulada).
     */
    public Chamado createChamado(Chamado novoChamado) {
        // 1. Geração de ID (Chave Primária) - (No mundo real, o banco faria isso)
        novoChamado.setId_chamado(new Random().nextInt(1000000));
        
        // 2. Classificação de Prioridade pela IA 
        //    (Aqui o Spring faria uma chamada para o Gemini para classificar)
        if (novoChamado.getTitulo().toLowerCase().contains("erro")) {
            novoChamado.setPrioridade("Alta"); // Simulação
            novoChamado.setId_tecnico_responsavel(12); // Atribui um técnico (hardware)
        } else {
            novoChamado.setPrioridade("Média");
            novoChamado.setId_tecnico_responsavel(10); // Atribui outro técnico (redes)
        }
        
        // 3. Define Status Inicial e Solicitante (Simulação)
        novoChamado.setStatus_Chamado("Aberto");
        novoChamado.setId_usuario_solicitante(1); // Simula que o usuário logado é o ID 1
        
        // 4. Salva no banco de dados Azure
        return chamadoRepository.save(novoChamado);
    }
}