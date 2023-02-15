package com.elmiraantipina.spring.springboot.spring_data_jpa.controller;

import com.elmiraantipina.spring.springboot.spring_data_jpa.entity.Employee;
import com.elmiraantipina.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    //Получение всех работников
    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){

        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        //@PathVariable используется для получения значения переменной из адреса запроса
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")//используется метод POST
    //добавление нового работника
    public Employee addNewEmployee(@RequestBody Employee employee){
        //@RequestBody чтобы использовать тело метода POST
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    //измнение существующего работника, в body-request необходимо прописывать id
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        //@PathVariable используется для получения значения переменной из адреса запроса

        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);
        return "Employee with ID = "+id+" was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name){

        List<Employee> employees = employeeService.findAllByName(name);

        return employees;
    }

}
