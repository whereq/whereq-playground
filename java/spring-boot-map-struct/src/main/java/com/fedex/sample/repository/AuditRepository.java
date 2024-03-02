package com.fedex.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedex.sample.model.entity.AuditEntity;

public interface AuditRepository extends JpaRepository<AuditEntity, Long>{
}
