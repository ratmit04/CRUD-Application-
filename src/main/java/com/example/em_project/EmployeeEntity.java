package com.example.em_project;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="RATNESH")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String phone;
}
