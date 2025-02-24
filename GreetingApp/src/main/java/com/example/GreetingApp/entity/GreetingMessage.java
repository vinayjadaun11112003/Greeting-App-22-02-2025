package com.example.GreetingApp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // Marks this class as a database entity
public class GreetingMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    private String message;

    // Constructors
    public GreetingMessage() {}

    public GreetingMessage(String message) {
        this.message = message;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}