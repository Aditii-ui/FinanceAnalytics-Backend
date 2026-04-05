package com.example.demo.service;

import com.example.demo.model.FinancialRecord;
import com.example.demo.repository.RecordRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private RecordRepository recordRepository = null;
    public DashboardService(RecordRepository recordRepository) {
    	this.recordRepository = recordRepository;
    }

    // SUMMARY API
    
    public Map<String, Double> getSummary() {

        List<FinancialRecord> records =
                recordRepository.findAll();

        double income = 0;
        double expense = 0;

        for (FinancialRecord record : records) {

            if (record.getType().equalsIgnoreCase("income")) {
                income += record.getAmount();
            }

            else if (record.getType().equalsIgnoreCase("expense")) {
                expense += record.getAmount();
            }
        }

        Map<String, Double> summary =
                new HashMap<>();

        summary.put("income", income);
        summary.put("expense", expense);
        summary.put("balance", income - expense);

        return summary;
    }



    // CATEGORY SUMMARY API
    public Map<String, Double> getCategorySummary() {

        List<FinancialRecord> records =
                recordRepository.findAll();

        Map<String, Double> categorySummary =
                new HashMap<>();

        for (FinancialRecord record : records) {

            String category = record.getCategory();

            categorySummary.put(
                    category,
                    categorySummary.getOrDefault(category, 0.0)
                            + record.getAmount()
            );
        }

        return categorySummary;
    }



    // MONTHLY TRENDS API
    public Map<String, Double> getMonthlyTrends() {

        List<FinancialRecord> records =
                recordRepository.findAll();

        Map<String, Double> monthlySummary =
                new HashMap<>();

        for (FinancialRecord record : records) {

            String month =
                    record.getDate()
                            .getMonth()
                            .toString();

            monthlySummary.put(
                    month,
                    monthlySummary.getOrDefault(month, 0.0)
                            + record.getAmount()
            );
        }

        return monthlySummary;
    }



    // RECENT ACTIVITY API
    public List<FinancialRecord> getRecentActivity() {

        return recordRepository.findAll();
    }
}