package com.dinesh.graphql.employeegraphql.repository;

import com.dinesh.graphql.employeegraphql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
