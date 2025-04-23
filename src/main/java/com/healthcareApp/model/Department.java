package com.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    private int deptId;
    private String deptName;
    private int doctorId;
    private int hospitalId;
}
