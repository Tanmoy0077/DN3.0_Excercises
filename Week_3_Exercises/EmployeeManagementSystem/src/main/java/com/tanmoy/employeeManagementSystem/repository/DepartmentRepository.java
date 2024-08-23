package com.tanmoy.employeeManagementSystem.repository;

import com.tanmoy.employeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
