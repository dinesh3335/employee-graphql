package com.dinesh.graphql.employeegraphql.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EmployeeInput(

        @NotBlank(message = "Name is required")
        String name,

        @Email(message = "Invalid email")
        String email,

        @Positive(message = "Salary must be positive")
        Double salary

) {
}