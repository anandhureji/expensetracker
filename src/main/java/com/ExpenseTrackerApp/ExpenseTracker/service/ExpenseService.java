package com.ExpenseTrackerApp.ExpenseTracker.service;

import com.ExpenseTrackerApp.ExpenseTracker.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseService {

    List<Expense> ListgetAllExpenses();
}
