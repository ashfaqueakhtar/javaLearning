package com.learning.springboot.learning.repository;

import com.learning.springboot.learning.data.entities.student.StudentEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ListCrudRepository<StudentEntity, Long> {
}
