package com.example.GreetingApp.controller;
import com.example.GreetingApp.dto.GreetingRequest;
import com.example.GreetingApp.dto.GreetingResponse;
import com.example.GreetingApp.entity.GreetingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.GreetingApp.service.GreetingService;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Create and Save Greeting
    @PostMapping
    public GreetingResponse createGreeting(@RequestBody GreetingRequest request) {
        return greetingService.generateAndSaveGreeting(request);
    }

    // Fetch All Saved Greetings
    @GetMapping("/all")
    public List<GreetingMessage> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    // Created a method to get messages using id
    @GetMapping("/{Id}")
    public GreetingMessage getGreetingById(@PathVariable Long Id) {
        return greetingService.getGreetingById(Id);
    }

//    // Created a method to get all messages using id
//    @GetMapping("/{id}")
//    public ResponseEntity<GreetingMessage> getAllGreetingById(@PathVariable Long id) {
//        return ResponseEntity.ok(greetingService.getGreetingById(id));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<GreetingMessage> updateGreeting(@PathVariable Long id, @RequestBody GreetingMessage newGreeting) {
        // Making call to service layer update greeting and get the updated response
        GreetingMessage updatedGreeting = greetingService.updateGreeting(id, newGreeting.getMessage());

        // returning the updated greeting status
        return ResponseEntity.ok(updatedGreeting);
    }

    // Deleting the greeting message by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.ok("Greeting with ID " + id + " has been deleted.");
    }
}