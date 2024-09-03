package com.learning.springboot.learning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.learning.data.dto.EmployeeDTO;
import com.learning.springboot.learning.services.EmployeeService;

/**
 * Presentation is all controllers
 * EmployeeController
 */
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // @GetMapping(path = "/employees")
    // public EmployeeDTO getEmployess() {
    // return new EmployeeDTO(1, "", LocalDate.of(2024, 1, 2), true);
    // }

    // @GetMapping(path = "/test")
    // public String getEmployess(@PathParam("sortBy") String sortBy) {
    // if (sortBy != null) {
    // return "Sorted by " + sortBy;
    // }
    // return "Hello Word";
    // }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployessById(@PathVariable("id") Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping()
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}