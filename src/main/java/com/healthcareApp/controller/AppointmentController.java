package com.healthcareApp.controller;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Hospital;
import com.healthcareApp.service.AppointmentService;
import com.healthcareApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class AppointmentController {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private AppointmentService appointmentService;

    public void run() throws SQLException {

        Appointment appointment = new Appointment();

        int option;
        do {
            System.out.println("1. Create Appointment");
            System.out.println("2. Display Appointment");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("0. Return to main Menu");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    appointmentService.createAppointment();
                    break;

                case 2:
                    appointmentService.displayAppointment();
                    break;

                case 3:
                    appointmentService.updateAppointment(appointment.getAppointmentId(),appointment.getPersonId());
                    break;

                case 4:
                    appointmentService.deleteAppointment(appointment.getAppointmentId());
                    break;

                default:
                    System.out.println("please enter valid input");
            }

        }while(option!=0);{
            System.out.println("please enter valid input");
        }

    }
}
