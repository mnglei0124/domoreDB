package com.example.innoctivedb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 45)
    @NotNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Size(max = 45)
    @NotNull
    @Column(name = "location", nullable = false, length = 45)
    private String location;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Post() {
    }

    public Post(Long id, String name, String location, Date date, String description, Category category, User user) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.description = description;
        this.category = category;
        this.user = user;
    }
}