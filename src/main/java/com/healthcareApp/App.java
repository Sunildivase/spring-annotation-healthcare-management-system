package com.healthcareApp;

import com.healthcareApp.controller.PersonController;
import com.healthcareApp.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "com.healthcareApp")
public class App {

    private static final Scanner scanner = new Scanner(System.in);

    private static ApplicationContext context;

    public static void main(String[] args) throws SQLException {

        // Load Spring context
        context = new AnnotationConfigApplicationContext(App.class);

        int option;
        do {

            System.out.println("-------spring-annotation-healthcare-management-system-------");
            System.out.println("1.Create Person");
            System.out.println("2.Create Doctor");
            System.out.println("3.Create Hospital");
            System.out.println("4.Create Department");
            System.out.println("5.Create Appointment");
            System.out.println("6.Create Prescription");
            System.out.println("7.Create billing");

            System.out.println("select the option below");
            option = Integer.parseInt(scanner.nextLine());


            switch (option) {
                case 1:
                    PersonController personController = context.getBean("personController", PersonController.class);
                    personController.run();
                    System.out.println("person created successfully!!!");
                    break;

                case 2:
                    System.out.println("doctor created successfully!!!");
                    break;

                case 3:
                    System.out.println("hospital created successfully!!!");
                    break;

                case 4:
                    System.out.println("department created successfully!!!");
                    break;

                case 5:
                    System.out.println("appointment created successfully!!!");
                    break;

                case 6:
                    System.out.println("prescription created successfully!!!");
                    break;

                case 7:
                    System.out.println("billing created successfully!!!");
                    break;

                default:
                    System.out.println("please enter valid input");
                    break;
            }


        } while (option != 0);
        {
            System.out.println("Thank you!!!");

        }
    }
}
