package com.ExpenseTrackerApp.ExpenseTracker.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

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
