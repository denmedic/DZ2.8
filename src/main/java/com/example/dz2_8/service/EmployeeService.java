package com.example.dz2_8.service;

import com.example.dz2_7.exeptions.EmployeeAlreadyAddedException;
import com.example.dz2_7.exeptions.EmployeeNotFoundExeption;
import com.example.dz2_7.exeptions.EmployeeStorageIsFullException;
import com.example.dz2_7.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee){
        return employee.getFirstName() + employee.getLastName();
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(getKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(getKey(employee),employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }


    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = getKey(employee);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundExeption();
        }
        return employees.remove(key);

    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(getKey(employee))) {
            throw new EmployeeNotFoundExeption();
        }
        return employee;


    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }


}




