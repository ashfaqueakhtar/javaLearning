package com.learning.springboot.learning.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboot.learning.data.entities.EmployeeEntity;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends ListCrudRepository<EmployeeEntity,Long> {

}