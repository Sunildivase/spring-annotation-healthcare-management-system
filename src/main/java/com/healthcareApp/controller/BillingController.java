package com.healthcareApp.controller;

import com.healthcareApp.model.Appointment;
import com.healthcareApp.model.Billing;
import com.healthcareApp.service.AppointmentService;
import com.healthcareApp.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class BillingController {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private BillingService billingService;

    public void run() throws SQLException {

        Billing billing = new Billing();

        int option;
        do {
            System.out.println("1. Create Billing");
            System.out.println("2. Display Billing");
            System.out.println("3. Update Billing");
            System.out.println("4. Delete Billing");
            System.out.println("0. Return to main Menu");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    billingService.createBilling();
                    break;

                case 2:
                    billingService.displayBilling();
                    break;

                case 3:
                    billingService.updateBilling(billing.getBillId(),billing.getTotalBill());
                    break;

                case 4:
                    billingService.deleteBilling(billing.getBillId());
                    break;

                default:
                    System.out.println("please enter valid input");
            }

        }while(option!=0);{
            System.out.println("please enter valid input");
        }

    }
}
