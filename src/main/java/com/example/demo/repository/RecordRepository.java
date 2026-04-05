package com.example.demo.repository;

import com.example.demo.model.FinancialRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecordRepository
        extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByType(String type);

    List<FinancialRecord> findByDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );
}