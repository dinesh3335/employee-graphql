package com.dinesh.graphql.employeegraphql.dto;

public record UpdateEmployeeInput(

        String name,

        String email,

        Double salary

) {
}
