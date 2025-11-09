// Em src/main/java/com/example/helpai-backend/controller/DashboardController.java
package com.example.helpai_backend.controller;

import com.example.helpai_backend.dto.DashboardStatsDTO;
import com.example.helpai_backend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    /**
     * Endpoint: GET /dashboard
     * Retorna estatísticas globais para a MainActivity.
     */
    @GetMapping("/dashboard")
    public ResponseEntity<DashboardStatsDTO> getDashboardStats() {
        DashboardStatsDTO stats = dashboardService.getGlobalDashboardStats();
        // Retorna HTTP 200 OK com os dados
        return ResponseEntity.ok(stats);
    }
}