package com.example.demo.controller;

import com.example.demo.service.DashboardService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;


    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


    @GetMapping("/summary")
    @PreAuthorize("hasAnyRole('VIEWER','ANALYST','ADMIN')")
    public ResponseEntity<Map<String, Double>> getSummary() {

        return ResponseEntity.ok(
                dashboardService.getSummary()
        );
    }


    @GetMapping("/category-summary")
    @PreAuthorize("hasAnyRole('VIEWER','ANALYST','ADMIN')")
    public ResponseEntity<Map<String, Double>> getCategorySummary() {

        return ResponseEntity.ok(
                dashboardService.getCategorySummary()
        );
    }


    @GetMapping("/monthly-trends")
    @PreAuthorize("hasAnyRole('VIEWER','ANALYST','ADMIN')")
    public ResponseEntity<Map<String, Double>> getMonthlyTrends() {

        return ResponseEntity.ok(
                dashboardService.getMonthlyTrends()
        );
    }


    @GetMapping("/recent-activity")
    @PreAuthorize("hasAnyRole('VIEWER','ANALYST','ADMIN')")
    public ResponseEntity<List<?>> getRecentActivity() {

        return ResponseEntity.ok(
                dashboardService.getRecentActivity()
        );
    }
}