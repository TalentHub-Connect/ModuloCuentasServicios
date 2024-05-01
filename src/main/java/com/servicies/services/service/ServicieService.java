package com.servicies.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.servicies.services.repository.ServiceRepository;
import com.servicies.services.model.Servicie;
import java.util.List;
import java.util.Optional;

@Service
public class ServicieService {

    private final ServiceRepository servicieRepository;

    @Autowired
    public ServicieService(ServiceRepository servicieRepository) {
        this.servicieRepository = servicieRepository;
    }

    @Transactional(readOnly = true)
    public List<Servicie> findAllServicies() {
        return servicieRepository.findAll();
    }

    @Transactional
    public Servicie createServicie(Servicie servicie) {
        return servicieRepository.save(servicie);
    }

    @Transactional
    public Servicie updateServicie(Long id, String description, Long roleId) {
        Servicie servicie = servicieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicie not found"));
        servicie.setDescription(description);
        servicie.setRoleId(roleId);
        return servicieRepository.save(servicie);
    }

    @Transactional(readOnly = true)
    public Optional<Servicie> findServicieById(Long id) {
        return servicieRepository.findById(id);
    }

    @Transactional
    public void deleteServicie(Long id) {
        Servicie servicie = servicieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicie not found"));
        servicieRepository.delete(servicie);
    }
}