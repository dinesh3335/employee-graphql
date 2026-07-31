package com.dinesh.graphql.employeegraphql.service;

import com.dinesh.graphql.employeegraphql.dto.EmployeeInput;
import com.dinesh.graphql.employeegraphql.dto.UpdateEmployeeInput;
import com.dinesh.graphql.employeegraphql.entity.Employee;
import com.dinesh.graphql.employeegraphql.exception.EmployeeNotFoundException;
import com.dinesh.graphql.employeegraphql.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee createEmployee(EmployeeInput input) {

        Employee employee = Employee.builder()
                .name(input.name())
                .email(input.email())
                .salary(input.salary())
                .build();

        return repository.save(employee);

    }

    public Employee getEmployee(Long id){

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

    }

    public Employee updateEmployee(Long id,
                                   UpdateEmployeeInput input){

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        if(input.name()!=null){
            employee.setName(input.name());
        }

        if(input.email()!=null){
            employee.setEmail(input.email());
        }

        if(input.salary()!=null){
            employee.setSalary(input.salary());
        }

        return repository.save(employee);

    }

    public boolean deleteEmployee(Long id){

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        repository.delete(employee);

        return true;

    }

}
