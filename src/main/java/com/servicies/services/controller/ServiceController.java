package com.servicies.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.servicies.services.model.Servicie;
import com.servicies.services.repository.ServiceRepository;

import java.util.List;

@RestController
@RequestMapping("/services")  // Updated the base path to match the specified endpoints
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    // Listar todos los Servicios
    @GetMapping
    public ResponseEntity<List<Servicie>> getAllServices() {
        List<Servicie> services = serviceRepository.findAll();
        return ResponseEntity.ok(services);
    }

    // Crear un Servicio
    @PostMapping
    public ResponseEntity<Servicie> createService(@RequestBody Servicie service) {
        Servicie savedService = serviceRepository.save(service);
        return ResponseEntity.status(201).body(savedService);
    }

    // Obtener un Servicio
    @GetMapping("/{serviceId}")
    public ResponseEntity<Servicie> getService(@PathVariable Long serviceId) {
        Servicie service = serviceRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));
        return ResponseEntity.ok(service);
    }

    // Actualizar un Servicio
    @PutMapping("/{serviceId}")
    public ResponseEntity<Servicie> updateService(@PathVariable Long serviceId, @RequestBody Servicie serviceDetails) {
        Servicie service = serviceRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));

        service.setDescription(serviceDetails.getDescription());
        service.setRoleId(serviceDetails.getRoleId());

        Servicie updatedService = serviceRepository.save(service);
        return ResponseEntity.ok(updatedService);
    }

    // Eliminar un Servicio
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
        Servicie service = serviceRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));

        serviceRepository.delete(service);
        return ResponseEntity.ok().build();
    }
}
