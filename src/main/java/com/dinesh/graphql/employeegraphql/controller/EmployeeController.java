package com.dinesh.graphql.employeegraphql.controller;

import com.dinesh.graphql.employeegraphql.dto.EmployeeInput;
import com.dinesh.graphql.employeegraphql.dto.UpdateEmployeeInput;
import com.dinesh.graphql.employeegraphql.entity.Employee;
import com.dinesh.graphql.employeegraphql.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @QueryMapping
    public List<Employee> employees() {

        return service.getAllEmployees();

    }

    @MutationMapping
    public Employee createEmployee(@Argument @Valid  EmployeeInput input) {

        return service.createEmployee(input);

    }

    @QueryMapping
    public Employee employee(@Argument Long id){

        return service.getEmployee(id);

    }

    @MutationMapping
    public Employee updateEmployee(

            @Argument Long id,

            @Argument UpdateEmployeeInput input){

        return service.updateEmployee(id,input);

    }

    @MutationMapping
    public Boolean deleteEmployee(
            @Argument Long id){

        return service.deleteEmployee(id);

    }

}
