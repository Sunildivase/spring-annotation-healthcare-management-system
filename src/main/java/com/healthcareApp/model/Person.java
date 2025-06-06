package com.healthcareApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int personId;
    private String type;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNo;
    private String alternateMobile;
    private String address;
}
