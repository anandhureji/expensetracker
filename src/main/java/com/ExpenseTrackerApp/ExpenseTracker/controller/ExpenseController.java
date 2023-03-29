package com.ExpenseTrackerApp.ExpenseTracker.controller;

import com.ExpenseTrackerApp.ExpenseTracker.entity.Expense;
import com.ExpenseTrackerApp.ExpenseTracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable pageable){
        return expenseService.getAllExpenses(pageable).toList();

    }

    @GetMapping("/expenses/{id}")
    public Expense getExpensById(@PathVariable Long id){
        return expenseService.getExpenseById(id);

    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpenseById(@PathVariable Long id){
        expenseService.deleteExpenseById(id);

    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses/add")
    public Expense saveExpenses(@Valid @RequestBody Expense expense){
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("/expenses/update/{id}")
    public Expense updateExpense(@PathVariable Long id,@RequestBody Expense expense){
        return expenseService.updateExpenseDetails(id,expense);
    }

    @GetMapping("/expenses/category")
    public List<Expense> getExpenseByCategory(@RequestParam String category,Pageable pageable) {
        return expenseService.readByCategory(category,pageable);
    }

    @GetMapping("/expenses/name")
    public List<Expense> getAllExpensesByName(@RequestParam String name,Pageable pageable){
        return expenseService.readByName(name,pageable);
    }
}
