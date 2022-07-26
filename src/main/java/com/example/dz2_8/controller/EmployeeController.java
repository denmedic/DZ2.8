package com.example.dz2_8.controller;

import com.example.dz2_8.model.Employee;
import com.example.dz2_8.service.EmployeeService;
import com.example.dz2_8.model.Employee;
import com.example.dz2_8.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("department") int department,
                        @RequestParam("salary") double salary)
    {
        return employeeService.add(firstName, lastName,department,salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("department") int department,
                           @RequestParam("salary") double salary) {
        return employeeService.remove(firstName, lastName,department,salary);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("department") int department,
                         @RequestParam("salary") double salary) {
        return employeeService.find(firstName, lastName,department,salary);
    }

    @GetMapping(path = "/")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


}
