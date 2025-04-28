package com.healthcareApp.service;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Billing;
import com.healthcareApp.repository.AppointmentRepository;
import com.healthcareApp.repository.BillingRepository;
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
public class BillingService {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private BillingRepository billingRepository;

    void printBilling(Billing billing){
        System.out.println(billing);
    }

    public boolean createBilling() throws SQLException {

        System.out.println("please enter billId");
        int billId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter bill");
        double bill = Double.parseDouble(scanner.nextLine());

        System.out.println("please enter totalBill");
        double totalBill = Double.parseDouble(scanner.nextLine());

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        Billing billing = new Billing(billId,bill,totalBill,personId);

        System.out.println("billing created successfully !!");
        return billingRepository.createBilling(billing);
    }

    public List<Billing> displayBilling() throws SQLException {

        Billing billing = new Billing();

        List<Billing> billingList = new ArrayList<>();

        System.out.println("billing list: "+ billingRepository.displayBilling());

        return billingList;
    }

    public void updateBilling(int billId,double totalBill) throws SQLException {

        if (billingRepository.updateBilling(billId, totalBill)) {
            System.out.println("billing updated successfully ");
        } else {
            System.out.println("Failed to update billing");
        }

    }

    public void deleteBilling(int billId) throws SQLException {
        boolean deletedBilling = billingRepository.deleteBilling(billId);
        System.out.println("deleted billing: "+deletedBilling);



    }
}
