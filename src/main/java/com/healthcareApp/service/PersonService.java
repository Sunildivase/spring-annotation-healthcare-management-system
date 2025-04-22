package com.healthcareApp.service;

import com.healthcareApp.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class PersonService {

    public boolean createPerson(){
        return false;
    }

    public List<Person> displayPerson(){
        return displayPerson();
    }

    public boolean updatePerson(){
        return false;
    }

    public boolean deletePerson(){
        return false;
    }
}
