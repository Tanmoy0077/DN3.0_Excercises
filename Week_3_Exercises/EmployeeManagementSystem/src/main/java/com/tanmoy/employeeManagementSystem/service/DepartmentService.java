package com.tanmoy.employeeManagementSystem.service;

import com.tanmoy.employeeManagementSystem.entity.Department;
import com.tanmoy.employeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    public Department updateDepartment(int id, Department department) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return departmentRepository.save(department);
        } else {
            throw new RuntimeException("Department not found with id " + id);
        }
    }

    public void deleteDepartment(int id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Department not found with id " + id);
        }
    }
}

