package com.tanmoy.employeeManagementSystem.repository;

import com.tanmoy.employeeManagementSystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "Select * from Employee where email = :email", nativeQuery = true)
    Optional<Employee> findByEmail(@Param("email") String email);

    Optional<Employee> findByName(String name);

    Page<Employee> findAll(Pageable pageable);
}
