package com.servicies.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.servicies.services.model.Service;
import com.servicies.services.repository.ServiceRepository;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public ResponseEntity<?> getAllServices() {
        return ResponseEntity.ok(serviceRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody Service service) {
        return ResponseEntity.status(201).body(serviceRepository.save(service));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateServiceStatus(@PathVariable Long id, @RequestBody String status) {
        Service service = serviceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Service not found"));
        service.setStatus(status);
        return ResponseEntity.ok(serviceRepository.save(service));
    }
}
