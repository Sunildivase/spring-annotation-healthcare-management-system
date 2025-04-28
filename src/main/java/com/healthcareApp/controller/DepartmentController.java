package com.healthcareApp.controller;

import com.healthcareApp.model.Department;
import com.healthcareApp.model.Doctor;
import com.healthcareApp.service.DepartmentService;
import com.healthcareApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class DepartmentController {
    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private DepartmentService departmentService;

    public void run() throws SQLException {

        Department department = new Department();

        int option;
        do {
            System.out.println("1. Create Department");
            System.out.println("2. Display Department");
            System.out.println("3. Update Department");
            System.out.println("4. Delete Department");
            System.out.println("0. Return to main Menu");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    departmentService.createDepartment();
                    break;

                case 2:
                    departmentService.displayDepartment();
                    break;

                case 3:
                    departmentService.updateDepartment(department.getDeptId(),department.getDeptName());
                    break;

                case 4:
                    departmentService.deleteDepartment(department.getDeptId());
                    break;

                default:
                    System.out.println("please enter valid input");
            }

        }while(option!=0);{
            System.out.println("please enter valid input");
        }

    }

}
