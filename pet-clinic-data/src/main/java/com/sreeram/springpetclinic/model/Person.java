package com.sreeram.springpetclinic.model;

public class Person extends BaseEntity{

    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
