package com.servicies.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.servicies.services.model.Servicie;

public interface ServiceRepository extends JpaRepository<Servicie, Long> {
}
