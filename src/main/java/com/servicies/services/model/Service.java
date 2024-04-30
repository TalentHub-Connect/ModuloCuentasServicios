package com.servicies.services.model;


import java.lang.annotation.Annotation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Service implements org.springframework.stereotype.Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String moduleService;
    private String status;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModuleService() {
        return moduleService;
    }
    public void setModuleService(String moduleService) {
        this.moduleService = moduleService;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public Class<? extends Annotation> annotationType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'annotationType'");
    }
    @Override
    public String value() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'value'");
    }

    
}