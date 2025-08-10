package com.example.innoctivedb.model;

import com.example.innoctivedb.model.enums.Volunteer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 45)
    @NotNull
    @Column(name = "company_name", nullable = false, length = 45)
    private String companyName;

    @Size(max = 45)
    @NotNull
    @Column(name = "employee_name", nullable = false, length = 45)
    private String employeeName;

    @Size(max = 45)
    @NotNull
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Size(max = 45)
    @NotNull
    @Column(name = "phone", nullable = false, length = 45)
    private String phone;

    @Size(max = 45)
    @NotNull
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Size(max = 45)
    @Column(name = "description", length = 45)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "voluneer")
    private Volunteer voluneer;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public User() {
    }

    public User(Long id, String companyName, String employeeName, String email, String phone, String password, String description, Volunteer voluneer, Category category) {
        this.id = id;
        this.companyName = companyName;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.description = description;
        this.voluneer = voluneer;
        this.category = category;
        //hello
    }
}