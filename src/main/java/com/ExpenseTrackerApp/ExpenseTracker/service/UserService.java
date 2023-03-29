package com.ExpenseTrackerApp.ExpenseTracker.service;

import com.ExpenseTrackerApp.ExpenseTracker.entity.User;
import com.ExpenseTrackerApp.ExpenseTracker.entity.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(UserModel userModel);

    User read(Long id);

    User update(User user,Long id);

    void delete(Long id);

}
