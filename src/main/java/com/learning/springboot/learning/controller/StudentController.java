package com.learning.springboot.learning.controller;


import com.learning.springboot.learning.data.ApiResponse;
import com.learning.springboot.learning.data.dto.student.StudentDTO;
import com.learning.springboot.learning.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController {

    final StudentService studentService;

    @GetMapping()
    public ResponseEntity<ApiResponse<List<StudentDTO>>> getAllStudents() {
        List<StudentDTO> data = studentService.getAllStudents();
        if (data != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, data.isEmpty() ? "Employees not found" : "Employees found", data));
        }
        return ResponseEntity.ok(new ApiResponse<>(false, "Employees not found", null));
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<ApiResponse<List<StudentDTO>>> getAllStudents(@RequestBody StudentDTO studentDTO) {
        Boolean isDeleted = studentService.deleteStudentById(studentDTO.getId());
        if (isDeleted) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Student removed", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(false, "Student not found", null));
    }

    @PostMapping()
    public  ResponseEntity<ApiResponse<StudentDTO>> createNewStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO data = studentService.createStudent(studentDTO);

        if (data != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Students created", data));
        }
        return ResponseEntity.ok(new ApiResponse<>(false, "Some issue with data", null));
    }

}
