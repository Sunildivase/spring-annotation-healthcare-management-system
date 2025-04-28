package com.healthcareApp.controller;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Prescription;
import com.healthcareApp.service.AppointmentService;
import com.healthcareApp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class PrescriptionController {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private PrescriptionService prescriptionService;

    public void run() throws SQLException {

        Prescription prescription = new Prescription();

        int option;
        do {
            System.out.println("1. Create Prescription");
            System.out.println("2. Display Prescription");
            System.out.println("3. Update Prescription");
            System.out.println("4. Delete Prescription");
            System.out.println("0. Return to main Menu");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    prescriptionService.createPrescription();
                    break;

                case 2:
                    prescriptionService.displayPrescription();
                    break;

                case 3:
                    prescriptionService.updatePrescription(prescription.getPrescriptionId(),prescription.getPrescriptionDetails());
                    break;

                case 4:
                    prescriptionService.deletePrescription(prescription.getPrescriptionId());
                    break;

                default:
                    System.out.println("please enter valid input");
            }

        }while(option!=0);{
            System.out.println("please enter valid input");
        }

    }
}
