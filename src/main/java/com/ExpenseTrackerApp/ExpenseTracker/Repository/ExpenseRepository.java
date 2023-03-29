package com.ExpenseTrackerApp.ExpenseTracker.Repository;


import com.ExpenseTrackerApp.ExpenseTracker.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    Page<Expense> findByCategory(String category, Pageable pageable);

    Page<Expense> findByNameContaining(String keyword,Pageable pageable);

}
