package com.example.GreetingApp.controller;
import com.example.GreetingApp.dto.GreetingRequest;
import com.example.GreetingApp.dto.GreetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.GreetingApp.service.GreetingService;
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping
    public GreetingResponse getGreeting() {
        return new GreetingResponse(greetingService.getGreetingMessage(), HttpStatus.OK.value());
    }

    @PostMapping
    public GreetingResponse postGreeting(@RequestBody GreetingRequest greet) {
        return new GreetingResponse("Hello "+greet.getFirstName() + " " + greet.getLastName()+", this is a POST request!", HttpStatus.CREATED.value());
    }

    @PutMapping
    public GreetingResponse putGreeting() {
        return new GreetingResponse("Hello Vinay Jadaun, this is a PUT request!", HttpStatus.OK.value());
    }

    @DeleteMapping
    public GreetingResponse deleteGreeting() {
        return new GreetingResponse("Hello Vinay Jadaun, this is a DELETE request!", HttpStatus.NO_CONTENT.value());
    }
}