package com.learning.springboot.learning.services;


import com.learning.springboot.learning.data.dto.student.StudentDTO;
import com.learning.springboot.learning.data.entities.student.StudentEntity;
import com.learning.springboot.learning.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {
    final StudentRepository studentRepository;
    final ModelMapper modelMapper;

    public List<StudentDTO> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(mapEntity -> modelMapper.map(mapEntity, StudentDTO.class))
                .collect(Collectors.toList());
    }

    public Boolean deleteStudentById(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = modelMapper.map(studentDTO, StudentEntity.class);
        return modelMapper.map(studentRepository.save(studentEntity), StudentDTO.class);
    }


}
