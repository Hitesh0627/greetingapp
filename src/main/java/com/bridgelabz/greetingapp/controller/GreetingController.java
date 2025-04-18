package com.bridgelabz.greetingapp.controller;



import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import com.bridgelabz.greetingapp.service.GreetingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingRepository Service;

    @Autowired
    private GreetingServiceImp greetingService;
    @Autowired
    private GreetingServiceImp greetingServiceImp;

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestParam String message) {
        return greetingServiceImp.saveGreeting(message);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingServiceImp.getAllGreetings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        if (greetingService.getGreetingById(id).isPresent()) {
            greetingService.deleteGreetingById(id);
            return ResponseEntity.ok("Greeting with ID " + id + " deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Greeting with ID " + id + " not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.updateGreeting(id, message)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}