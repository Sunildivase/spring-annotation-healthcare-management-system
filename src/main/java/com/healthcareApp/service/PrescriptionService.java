package com.healthcareApp.service;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Prescription;
import com.healthcareApp.repository.AppointmentRepository;
import com.healthcareApp.repository.PrescriptionRepository;
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
public class PrescriptionService {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    void printPrescription(Prescription prescription){
        System.out.println(prescription);
    }

    public boolean createPrescription() throws SQLException {

        System.out.println("please enter prescriptionId");
        int prescriptionId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter prescriptionDetails");
        String prescriptionDetails = scanner.nextLine();

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        Prescription prescription = new Prescription(prescriptionId,prescriptionDetails,personId);

        System.out.println("prescription created successfully !!");
        return prescriptionRepository.createPrescription(prescription);
    }

    public List<Prescription> displayPrescription() throws SQLException {

        Prescription prescription = new Prescription();

        List<Prescription> prescriptionList = new ArrayList<>();

        System.out.println("prescription list: "+ prescriptionRepository.displayPrescription());

        return prescriptionList;
    }

    public void updatePrescription(int prescriptionId,String prescriptionDetails) throws SQLException {

        if (prescriptionRepository.updatePrescription(prescriptionId, prescriptionDetails)) {
            System.out.println("prescription updated successfully ");
        } else {
            System.out.println("Failed to update prescription");
        }

    }

    public void deletePrescription(int prescriptionId) throws SQLException {
       boolean deletedPrescription = prescriptionRepository.deletePrescription(prescriptionId);
        System.out.println("deleted prescription: "+deletedPrescription);

    }
}
