package com.example.CRUD.Models;

import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String designation;
}