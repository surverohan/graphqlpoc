package com.spike.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spike.graphql.model.Employee;

/**
 * Created by Rohan Surve on 01/31/2020.
 *This class is represents Employee Respository for CRUD
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
