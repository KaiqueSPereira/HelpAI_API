// Em src/main/java/com/example/helpai-backend/controller/ChamadoController.java
package com.example.helpai_backend.controller;

import com.example.helpai_backend.entity.Chamado;
import com.example.helpai_backend.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados") // Mapeia todas as URLs com /chamados
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    /**
     * Endpoint: GET /chamados
     * Chamado pela TicketsActivity. Retorna todos os chamados.
     */
    @GetMapping
    public ResponseEntity<List<Chamado>> getFilteredChamados(
            @RequestParam(required = false, name = "status") String status,
            @RequestParam(required = false, name = "perfil") Integer perfil,
            @RequestParam(required = false, name = "solicitanteId") Integer solicitanteId) {

        // 1. Lógica para buscar dados (por enquanto retorna todos, mas o Service está pronto)
        List<Chamado> chamados = chamadoService.findFiltered(
                perfil != null ? perfil : -1, // -1 se for nulo
                status != null ? status : "ALL",
                solicitanteId
        );

        // 2. Retorna HTTP 200 OK
        return ResponseEntity.ok(chamados);
    }

    /**
     * Endpoint: POST /chamados
     * Chamado pela NewTicketActivity. Cria e salva um novo chamado.
     */
    @PostMapping
    public ResponseEntity<Chamado> createChamado(@RequestBody Chamado chamado) {
        // O Service adiciona o ID, a prioridade (IA), o status e o solicitante
        Chamado novoChamado = chamadoService.createChamado(chamado);
        // Retorna HTTP 201 CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(novoChamado);
    }
}