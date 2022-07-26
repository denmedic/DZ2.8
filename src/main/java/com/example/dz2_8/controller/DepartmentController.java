package com.example.dz2_8.controller;

import com.example.dz2_8.model.Employee;
import com.example.dz2_8.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("/departmentId") int department){
        return departmentService.maxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("/departmentId") int department){
        return departmentService.minSalary(department);
    }

    @GetMapping(value = "/all", params = "/departmentId")
    public List<Employee> allEmployees(@RequestParam("/departmentId") int department) {
        return departmentService.allEmployees(department);
    }


    @GetMapping("/all")
    public Map<Integer,List<Employee>> allEmployeesWithDepartment (@RequestParam("/departmentId") int department){
        return departmentService.allEmployeesWithDepartment(department);
    }
}
