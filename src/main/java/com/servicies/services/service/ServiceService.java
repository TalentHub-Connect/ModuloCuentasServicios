package com.servicies.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.servicies.services.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Transactional(readOnly = true)
    public List<com.servicies.services.model.Service> findAllServices() {
        return serviceRepository.findAll();
    }

    @Transactional
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    @Transactional
    public Service updateService(Long id, String status) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        ((com.servicies.services.model.Service) service).setStatus(status);
        return serviceRepository.save(service);
    }

    @Transactional(readOnly = true)
    public Optional<com.servicies.services.model.Service> findServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    @Transactional
    public void deleteService(Long id) {
        com.servicies.services.model.Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        serviceRepository.delete(service);
    }
}