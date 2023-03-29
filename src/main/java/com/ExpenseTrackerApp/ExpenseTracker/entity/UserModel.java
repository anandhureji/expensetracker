package com.ExpenseTrackerApp.ExpenseTracker.entity;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {

    @NotBlank(message = "Please enter the name")
    private String name;

    @NotBlank(message = "Please enter the email")
    @Email
    private String email;

    @NotNull(message = "Please enter the password")
    @Size(min = 5,message = "Please enter atleast 5 characters")
    private String password;


    private Long mobile;

    private Long age = 0L;
}
