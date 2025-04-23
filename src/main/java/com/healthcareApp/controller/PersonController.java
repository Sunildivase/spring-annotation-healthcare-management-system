package com.healthcareApp.controller;

import com.healthcareApp.model.Person;
import com.healthcareApp.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@AllArgsConstructor
@Data
@Component
public class PersonController {

    @Autowired
    private PersonService personService;

    private static final Scanner scanner = new Scanner(System.in);

    public void run() throws SQLException {

        Person person = new Person();

        int option;
        do{
            System.out.println("1.Create person");
            System.out.println("2.Retrieve person");
            System.out.println("3.Update person");
            System.out.println("4.Delete person");
            System.out.println("0,Return to Main Menu");

            System.out.println("please select the option");
            option=Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    personService.createPerson();
                    break;

                case 2:
                    personService.displayPerson();
                    break;

                case 3:
                    personService.updatePerson(person.getPersonId(), person.getFirstName());
                    break;

                case 4:
                    personService.deletePerson(person.getPersonId());
                    break;

                default:
                    System.out.println("please enter valid input");
                    break;
            }

        }while(option!=0);{

            System.out.println("please enter valid input ");
        }
    }
}
