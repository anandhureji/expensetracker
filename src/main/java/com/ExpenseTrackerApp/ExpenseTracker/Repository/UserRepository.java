package com.ExpenseTrackerApp.ExpenseTracker.Repository;

import com.ExpenseTrackerApp.ExpenseTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);

    Boolean existsByMobile(Long mobile);


}
