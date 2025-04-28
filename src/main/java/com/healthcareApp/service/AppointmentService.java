package com.healthcareApp.service;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Hospital;
import com.healthcareApp.repository.AppointmentRepository;
import com.healthcareApp.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Data
@Service
public class AppointmentService {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private AppointmentRepository appointmentRepository;

    void printAppointment(Appointment appointment){
        System.out.println(appointment);
    }

    public boolean createAppointment() throws SQLException {

        System.out.println("please enter appointmentId");
        int appointmentId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter doctorId");
        int doctorId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter hospitalId");
        int hospitalId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter deptId");
        int deptId = Integer.parseInt(scanner.nextLine());

        Appointment appointment = new Appointment(appointmentId,personId,doctorId,hospitalId,deptId);

        System.out.println("appointment created successfully !!");
        return appointmentRepository.createAppointment(appointment);
    }

    public List<Appointment> displayAppointment() throws SQLException {

        Appointment appointment = new Appointment();

        List<Appointment> appointmentList = new ArrayList<>();

        System.out.println("appointment list: "+ appointmentRepository.displayAppointment());

        return appointmentList;
    }

    public void updateAppointment(int appointmentId,int personId) throws SQLException {

        if (appointmentRepository.updateAppointment(appointmentId, personId)) {
            System.out.println("appointment updated successfully ");
        } else {
            System.out.println("Failed to update appointment");
        }

    }

    public boolean deleteAppointment(int appointmentId) throws SQLException {
        boolean deletedAppointment = appointmentRepository.deleteAppointment(appointmentId);
        System.out.println("deleted appointment: "+deletedAppointment);

        return deletedAppointment;

    }
}
