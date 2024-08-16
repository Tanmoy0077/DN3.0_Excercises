package com.tanmoy.employeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Employee.findByName", query = "Select e from Employee e where e.name = :name")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "email")
    private String email;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;
}
