package com.ExpenseTrackerApp.ExpenseTracker.service;

import com.ExpenseTrackerApp.ExpenseTracker.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseService {

    Page<Expense> getAllExpenses(Pageable pageable);

    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id,Expense expense);

    List<Expense> readByCategory(String category,Pageable pageable);

    List<Expense> readByName(String name,Pageable pageable);
}
