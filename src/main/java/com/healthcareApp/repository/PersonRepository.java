package com.healthcareApp.repository;

import com.healthcareApp.controller.PersonController;
import com.healthcareApp.model.Person;
import com.healthcareApp.service.ConnectionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Repository
public class PersonRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean createPerson(Person person) throws SQLException {

        this.initConnection();

        String query = "INSERT INTO person(personId,type,firstName,lastName,age,gender,contactNo,alternateMobile,address) VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, person.getPersonId());
            preparedStatement.setString(2, person.getType());
            preparedStatement.setString(3, person.getFirstName());
            preparedStatement.setString(4, person.getLastName());
            preparedStatement.setInt(5, person.getAge());
            preparedStatement.setString(6, person.getGender());
            preparedStatement.setString(7, person.getContactNo());
            preparedStatement.setString(8, person.getAlternateMobile());
            preparedStatement.setString(9, person.getAddress());

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public List<Person> displayPerson() throws SQLException {

        List<Person> personList = new ArrayList<>();

        this.initConnection();

        String query = "SELECT * FROM person";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getInt("personId"),
                        resultSet.getString("type"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("contactNo"),
                        resultSet.getString("alternateMobile"),
                        resultSet.getString("address")
                );


                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public boolean updatePerson(int personId, String firstName) throws SQLException {

        this.initConnection();

        String query = "UPDATE person SET firstName=? WHERE personId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, personId);

            int rowUpdated = preparedStatement.executeUpdate();

            return rowUpdated > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean deletePerson(int personId) throws SQLException {

        this.initConnection();

        String query = "DELETE FROM person WHERE personId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, personId);

            int rowDeleted = preparedStatement.executeUpdate();

            return rowDeleted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
