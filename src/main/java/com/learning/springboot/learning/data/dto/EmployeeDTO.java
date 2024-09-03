package com.learning.springboot.learning.data.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
    private String name;
    private LocalDate doj;
    @JsonProperty("isActive")
    private boolean isActive;
}
