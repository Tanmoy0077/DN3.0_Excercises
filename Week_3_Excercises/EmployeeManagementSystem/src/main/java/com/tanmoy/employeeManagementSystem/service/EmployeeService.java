package com.tanmoy.employeeManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.tanmoy.employeeManagementSystem.repository.EmployeeRepository;
import com.tanmoy.employeeManagementSystem.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(int id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    public void deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Optional<Employee> getEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }

    public Page<Employee> getAllEmployees(int pageNumber, int pageSize, String sortField, boolean ascending) {
        Sort sort = ascending ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize, sort);
        return employeeRepository.findAll(pageRequest);
    }
}
