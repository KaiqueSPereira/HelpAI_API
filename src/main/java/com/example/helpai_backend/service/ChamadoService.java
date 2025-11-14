// Em src/main/java/com/example/helpai_backend/service/ChamadoService.java
package com.example.helpai_backend.service;

import com.example.helpai_backend.entity.Chamado;
import com.example.helpai_backend.entity.Usuario;
import com.example.helpai_backend.repository.ChamadoRepository;
import com.example.helpai_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository; // Necessário para buscar nomes

    /**
     * (ATUALIZADO) Retorna todos os chamados, agora com os nomes.
     */
    public List<Chamado> findAll() {
        // 1. Busca todos os chamados
        List<Chamado> chamados = chamadoRepository.findAll();

        // 2. "Enriquece" a lista com os nomes (como fizemos antes)
        for (Chamado chamado : chamados) {
            
            // 2a. Busca o nome do Solicitante
            if (chamado.getIdUsuarioSolicitante() != null) {
                Optional<Usuario> solicitante = usuarioRepository.findById(chamado.getIdUsuarioSolicitante());
                if (solicitante.isPresent()) {
                    chamado.setNomeUsuario(solicitante.get().getNome());
                } else {
                    chamado.setNomeUsuario("Usuário (ID " + chamado.getIdUsuarioSolicitante() + ")");
                }
            } else {
                chamado.setNomeUsuario("Sistema");
            }

            // 2b. Busca o nome do Técnico (se houver)
            if (chamado.getIdTecnicoResponsavel() != null) {
                Optional<Usuario> tecnico = usuarioRepository.findById(chamado.getIdTecnicoResponsavel());
                if (tecnico.isPresent()) {
                    chamado.setNomeTecnico(tecnico.get().getNome());
                } else {
                    chamado.setNomeTecnico("Técnico (ID " + chamado.getIdTecnicoResponsavel() + ")");
                }
            } else {
                chamado.setNomeTecnico("Não Atribuído");
            }
        }
        
        return chamados;
    }

    /**
     * (ATUALIZADO) Recebe um chamado novo do app e aplica a lógica de atribuição.
     * (SEM SIMULAÇÃO)
     */
    public Chamado createChamado(Chamado novoChamado) {
        
        // 1. Lógica de Validação:
        if (novoChamado.getTitulo() == null || novoChamado.getDescricao() == null) {
            throw new IllegalArgumentException("Título e descrição são obrigatórios.");
        }
        
        // 2. ATRIBUIÇÃO INICIAL (Lógica 100% Real)
        
        // O ID é gerado automaticamente pelo DB (anotação @GeneratedValue).
        
        // Define a Prioridade (Pendente de triagem pela IA)
        novoChamado.setPrioridade("Triagem Pendente"); 
        
        // Define o Status inicial
        // !! USA O MÉTODO CORRETO (camelCase) !!
        novoChamado.setStatusChamado("Aberto");
        
        // Técnico e Gerente são NULOS no início (pendente de atribuição)
        novoChamado.setIdTecnicoResponsavel(null);
        novoChamado.setIdGerenteSupervisor(null);
        
        // Define o solicitante (Simulando ID 1, pois não temos JWT)
        if (novoChamado.getIdUsuarioSolicitante() == null) {
            novoChamado.setIdUsuarioSolicitante(1); 
        }

        // 3. Salva no banco de dados Azure
        return chamadoRepository.save(novoChamado);
    }
}