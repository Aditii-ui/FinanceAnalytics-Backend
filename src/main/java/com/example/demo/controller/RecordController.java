package com.example.demo.controller;

import com.example.demo.model.FinancialRecord;
import com.example.demo.service.RecordService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;


    // Manual constructor injection
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FinancialRecord> createRecord(
            @RequestBody FinancialRecord record) {

        return ResponseEntity.ok(
                recordService.createRecord(record)
        );
    }


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public ResponseEntity<List<FinancialRecord>> getAllRecords() {

        return ResponseEntity.ok(
                recordService.getAllRecords()
        );
    }


    @GetMapping("/filter")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public ResponseEntity<List<FinancialRecord>> filterRecords(

            @RequestParam(required = false) String category,

            @RequestParam(required = false) String type,

            @RequestParam(required = false) LocalDate startDate,

            @RequestParam(required = false) LocalDate endDate) {

        return ResponseEntity.ok(
                recordService.filterRecords(
                        category,
                        type,
                        startDate,
                        endDate
                )
        );
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteRecord(
            @PathVariable Long id) {

        recordService.deleteRecord(id);

        return ResponseEntity.ok("Record deleted successfully");
    }
}