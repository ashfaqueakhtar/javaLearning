package com.learning.springboot.learning.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.learning.springboot.learning.data.dto.EmployeeDTO;
import com.learning.springboot.learning.data.entities.EmployeeEntity;
import com.learning.springboot.learning.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * EmployeeService
 */
@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(long id) {
        // EmployeeEntity entity = employeeRepository.getById(id);
        // return modelMapper.map(entity, EmployeeDTO.class);

        Optional<EmployeeEntity> entityOptional = employeeRepository.findById(id);
        if (entityOptional.isPresent()) {
            EmployeeEntity entity = entityOptional.get();
            return modelMapper.map(entity, EmployeeDTO.class);
        } else {
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(empEntity -> modelMapper.map(empEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}