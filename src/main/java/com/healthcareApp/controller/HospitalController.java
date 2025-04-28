package com.healthcareApp.controller;

import com.healthcareApp.model.Doctor;
import com.healthcareApp.model.Hospital;
import com.healthcareApp.service.DoctorService;
import com.healthcareApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class HospitalController {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private HospitalService hospitalService;

    public void run() throws SQLException {

        Hospital hospital = new Hospital();

        int option;
        do {
            System.out.println("1. Create Hospital");
            System.out.println("2. Display Hospital");
            System.out.println("3. Update Hospital");
            System.out.println("4. Delete Hospital");
            System.out.println("0. Return to main Menu");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    hospitalService.createHospital();
                    break;

                case 2:
                    hospitalService.displayHospital();
                    break;

                case 3:
                    hospitalService.updateHospital(hospital.getHospitalId(),hospital.getHospitalName());
                    break;

                case 4:
                    hospitalService.deleteHospital(hospital.getHospitalId());
                    break;

                default:
                    System.out.println("please enter valid input");
            }

        }while(option!=0);{
            System.out.println("please enter valid input");
        }

    }
}
