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

        System.out.println("please enter address");
        String address = scanner.nextLine();

        System.out.println("please enter emailId");
        String emailId = scanner.nextLine();

        System.out.println("please enter contactNo");
        String contactNo = scanner.nextLine();

        Hospital hospital = new Hospital(hospitalId,hospitalName,address,emailId,contactNo);

        System.out.println("Doctor created successfully !!");
        return hospitalRepository.createHospital(hospital);
    }

    public List<Hospital> displayHospital() throws SQLException {

        Hospital hospital = new Hospital();

        List<Hospital> hospitalList = new ArrayList<>();

        System.out.println("hospital list: "+ hospitalRepository.displayHospital());

        return hospitalList;
    }

    public boolean updateHospital(int hospitalId,String hospitalName) throws SQLException {

        if (hospitalRepository.updateHospital(hospitalId, hospitalName)) {
            System.out.println("hospital updated successfully ");
        } else {
            System.out.println("Failed to update hospital");
        }
        return false;
    }

    public boolean deleteHospital(int hospitalId) throws SQLException {
        boolean deletedHospital = hospitalRepository.deleteHospital(hospitalId);
        System.out.println("deleted hospital: "+deletedHospital);

        return deletedHospital;

    }
}
