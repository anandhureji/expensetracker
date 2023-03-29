package com.ExpenseTrackerApp.ExpenseTracker.controller;

import com.ExpenseTrackerApp.ExpenseTracker.Exception.ExpenseNotFoundException;
import com.ExpenseTrackerApp.ExpenseTracker.entity.User;
import com.ExpenseTrackerApp.ExpenseTracker.entity.UserModel;
import com.ExpenseTrackerApp.ExpenseTracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService  userService;

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel userModel){
        return new ResponseEntity<User>(userService.createUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> read(@PathVariable Long id){
        return new ResponseEntity<User>(userService.read(id),HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable Long id){
        User user1 = userService.update(user,id);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) throws ExpenseNotFoundException{
        userService.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
