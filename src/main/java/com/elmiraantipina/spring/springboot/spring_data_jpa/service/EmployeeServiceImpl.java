package com.elmiraantipina.spring.springboot.spring_data_jpa.service;

import com.elmiraantipina.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.elmiraantipina.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//означает, что этот класс соединительное звено между Controller-ом и DAO(на тот случай, если ДАО будет несколько)
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    //@Transactional//можем убрать, так как SpringBootRepository все это делает
    public List<Employee> getAllEmployees() {
        //вызываем методы из EmployeeRepository, которые делает за нас SpringBoot
        return employeeRepository.findAll();//получние всех работников
    }

    @Override
    public void saveEmployee(Employee employee) {
        //вызываем методы из EmployeeRepository, которые делает за нас SpringBoot
        employeeRepository.save(employee);//изменение или добавление работника
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){//проверем есть ли работник с таким id
            employee = optional.get();// если есть, то назначаем этого работника переменной employee
        }
        return employee;
    }


    @Override
    public void deleteEmployee(int id) {
        //вызываем методы из EmployeeRepository, которые делает за нас SpringBoot
        employeeRepository.deleteById(id);//удаление работника
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }

}
