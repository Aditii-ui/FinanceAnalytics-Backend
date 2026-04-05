package com.example.demo.service;

import com.example.demo.model.FinancialRecord;
import com.example.demo.repository.RecordRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;


    // Constructor injection (manual replacement for Lombok)
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    // CREATE RECORD
    public FinancialRecord createRecord(FinancialRecord record) {

        return recordRepository.save(record);
    }


    // GET ALL RECORDS
    public List<FinancialRecord> getAllRecords() {

        return recordRepository.findAll();
    }


    // FILTER RECORDS
    public List<FinancialRecord> filterRecords(
            String category,
            String type,
            LocalDate startDate,
            LocalDate endDate) {

        if (category != null) {
            return recordRepository.findByCategory(category);
        }

        if (type != null) {
            return recordRepository.findByType(type);
        }

        if (startDate != null && endDate != null) {
            return recordRepository.findByDateBetween(startDate, endDate);
        }

        return recordRepository.findAll();
    }


    // DELETE RECORD
    public void deleteRecord(Long id) {

        recordRepository.deleteById(id);
    }
}