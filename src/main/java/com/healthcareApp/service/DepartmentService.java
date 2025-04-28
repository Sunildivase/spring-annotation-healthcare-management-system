package com.healthcareApp.service;

import com.healthcareApp.model.Department;
import com.healthcareApp.model.Hospital;
import com.healthcareApp.repository.DepartmentRepository;
import com.healthcareApp.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
@Data
public class DepartmentService {
    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private DepartmentRepository departmentRepository;

    void printDepartment(Department department){
        System.out.println(department);
    }

    public boolean createDepartment() throws SQLException {

        System.out.println("please enter departmentId");
        int deptId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter department Name");
        String deptName = scanner.nextLine();

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter hospitalId");
        int hospitalId= Integer.parseInt(scanner.nextLine());

        Department department = new Department(deptId,deptName,doctorId,hospitalId);

        System.out.println("Department created successfully !!");
        return departmentRepository.createDepartment(department);
    }

    public List<Department> displayDepartment() throws SQLException {

        Department department = new Department();

        List<Department> departmentList = new ArrayList<>();

        System.out.println("department list: "+ departmentRepository.displayDepartment());

        return departmentList;
    }

    public boolean updateDepartment(int deptId,String deptName) throws SQLException {

        if (departmentRepository.updateDepartment(deptId, deptName)) {
            System.out.println("department updated successfully ");
        } else {
            System.out.println("Failed to update department");
        }
        return false;
    }

    public boolean deleteDepartment(int deptId) throws SQLException {
        boolean deletedDept = departmentRepository.deleteDepartment(deptId);
        System.out.println("deleted department: "+deletedDept);

        return deletedDept;

    }
}
