package com.ExpenseTrackerApp.ExpenseTracker.service;


import com.ExpenseTrackerApp.ExpenseTracker.Exception.ExpenseNotFoundException;
import com.ExpenseTrackerApp.ExpenseTracker.Repository.ExpenseRepository;
import com.ExpenseTrackerApp.ExpenseTracker.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Page<Expense> getAllExpenses(Pageable pageable) {
        return expenseRepository.findAll(pageable);
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> byId = expenseRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        throw  new ExpenseNotFoundException("Expense is not found with id ,"+id);

    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName()!=null?expense.getName():existingExpense.getName());
        existingExpense.setCategory(expense.getCategory()!=null?expense.getCategory():existingExpense.getCategory());
        existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
        existingExpense.setDescription(expense.getDescription()!=null?expense.getDescription():existingExpense.getDescription());
        existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
        return expenseRepository.save(existingExpense);
    }

    @Override
    public List<Expense> readByCategory(String category, Pageable pageable) {
        return expenseRepository.findByCategory(category,pageable).toList();
    }
}
