package com.healthcareApp.repository;

import com.healthcareApp.controller.PersonController;
import com.healthcareApp.model.Person;
import com.healthcareApp.service.ConnectionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Data
@Repository
public class personRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public boolean createPerson(Person person){

        
        return false;
    }

    public List<Person> displayPerson(){
        return displayPerson();
    }

    public Boolean updatePerson(){
        return false;
    }

    public boolean deletePerson(){
        return false;
    }
}
