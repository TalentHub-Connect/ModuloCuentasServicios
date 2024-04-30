package com.servicies.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicies.services.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    org.springframework.stereotype.Service save(org.springframework.stereotype.Service service);
}