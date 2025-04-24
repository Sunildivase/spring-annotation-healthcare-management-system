package com.healthcareApp.controller;

import com.healthcareApp.model.Doctor;
import com.healthcareApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class DoctorController {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private DoctorService doctorService;

    public void run() throws SQLException {

        Doctor doctor = new Doctor();

        int option;
        do {
            System.out.println("1. Create Doctor");
            System.out.println("2. Display Doctor");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("0. Return to main Menu");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    doctorService.createDoctor();
                    break;

                case 2:
                    doctorService.displayDoctor();
                    break;

                case 3:
                    doctorService.updateDoctor(doctor.getDoctorId(),doctor.getFirstName());
                    break;

                case 4:
                    doctorService.deleteDoctor(doctor.getDoctorId());
                    break;

                default:
                    System.out.println("please enter valid input");
            }

        }while(option!=0);{
            System.out.println("please enter valid input");
        }

    }
}
