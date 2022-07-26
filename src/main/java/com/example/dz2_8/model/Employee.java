package com.example.dz2_8.model;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private final String FirstName;
    private final String LastName;
    private final int department;
    private final double salary;


    public Employee(String firstName, String lastName, int department, double salary) {
        FirstName = firstName;
        LastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return FirstName;
    }


    public String getLastName() {
        return LastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && FirstName.equals(employee.FirstName) && LastName.equals(employee.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, department, salary);
    }

    @Override
    public String toString() {
        return this.FirstName + ","  + this.LastName + "," + this.department + "," + this.salary;
    }

    @Override
    public int compareTo(Employee o){
        return (int) (getSalary() - o.getSalary());
    }


}
