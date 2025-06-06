package com.healthcareApp.service;

import com.healthcareApp.model.Person;
import com.healthcareApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Service
public class PersonService{

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private PersonRepository personRepository;

    void printPerson(Person person){
        System.out.println(person);
    }

    public boolean createPerson() throws SQLException {

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter type");
        String type = scanner.nextLine();

        System.out.println("please enter firstName");
        String firstName = scanner.nextLine();

        System.out.println("please enter lastName");
        String lastName = scanner.nextLine();

        System.out.println("please enter age");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter gender");
        String gender = scanner.nextLine();

        System.out.println("please enter contactNo");
        String contactNo = scanner.nextLine();

        System.out.println("please enter alternateMobile");
        String  alternateMobile = scanner.nextLine();

        System.out.println("please enter address");
        String address = scanner.nextLine();

        Person person = new Person();

        person.setPersonId(personId);
        person.setType(type);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        person.setGender(gender);
        person.setContactNo(contactNo);
        person.setAlternateMobile(alternateMobile);
        person.setAddress(address);

        System.out.println("person created successfully!!!");
        return personRepository.createPerson(person);
    }

    public List<Person> displayPerson() throws SQLException {

        Person person = new Person();

        List<Person> personList = new ArrayList<>();

        System.out.println("person list: "+personRepository.displayPerson());

        return personList;
    }

    public boolean updatePerson(int personId,String firstName) throws SQLException {

        if (personRepository.updatePerson(personId, firstName)) {
            System.out.println("person updated successfully ");
        } else {
            System.out.println("Failed to update person");
        }
        return false;
    }

    public void deletePerson(int personId) throws SQLException {

        boolean deletedPerson = personRepository.deletePerson(personId);
        System.out.println("deleted person: "+deletedPerson);
    }
}