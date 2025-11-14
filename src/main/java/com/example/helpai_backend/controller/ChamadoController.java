// Em src/main/java/com/example/helpai_backend/controller/ChamadoController.java
package com.example.helpai_backend.controller;

import com.example.helpai_backend.entity.Chamado;
import com.example.helpai_backend.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chamados") 
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    /**
     * Endpoint: GET /chamados
     * Permite a filtragem por status e perfil (chamado pela TicketsActivity).
     * Nota: O back-end agora retorna dados não filtrados para o app filtrar localmente,
     * mas está pronto para a lógica de filtragem SQL avançada.
     */
    @GetMapping
    public ResponseEntity<List<Chamado>> getAllChamados(
            @RequestParam(required = false, name = "status") String status,
            @RequestParam(required = false, name = "perfil") Integer perfil,
            @RequestParam(required = false, name = "solicitanteId") Integer solicitanteId) {

        // O Service retorna a lista completa (ou com filtros simples)
        List<Chamado> chamados = chamadoService.findAll(); 

        // Retorna HTTP 200 OK com os dados
        return ResponseEntity.ok(chamados);
    }

    /**
     * Endpoint: POST /chamados
     * Chamado pela NewTicketActivity. Cria e salva um novo chamado.
     */
    @PostMapping
    public ResponseEntity<Chamado> createChamado(@RequestBody Chamado chamado) {
        Chamado novoChamado = chamadoService.createChamado(chamado);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoChamado);
    }
}