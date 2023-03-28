package com.ExpenseTrackerApp.ExpenseTracker.service;


import com.ExpenseTrackerApp.ExpenseTracker.Repository.ExpenseRepository;
import com.ExpenseTrackerApp.ExpenseTracker.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> ListgetAllExpenses() {
        return expenseRepository.findAll();
    }
}
