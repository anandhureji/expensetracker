package com.ExpenseTrackerApp.ExpenseTracker.controller;

import com.ExpenseTrackerApp.ExpenseTracker.entity.User;
import com.ExpenseTrackerApp.ExpenseTracker.entity.UserModel;
import com.ExpenseTrackerApp.ExpenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("User is logged in", HttpStatus.OK);
    }

    @PostMapping("/registernew")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel userModel){
        return new ResponseEntity<User>(userService.createUser(userModel),HttpStatus.CREATED);
    }


}
