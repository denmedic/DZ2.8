package com.example.dz2_8.model;

import java.util.Objects;

public class Employee {
    private final String FirstName;
    private final String LastName;


    public Employee(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;

    }

    public String getFirstName() {
        return FirstName;
    }


    public String getLastName() {
        return LastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return FirstName.equals(employee.FirstName) && LastName.equals(employee.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName);
    }

    @Override
    public String toString() {
        return this.FirstName + ","  + this.LastName;
    }

}
