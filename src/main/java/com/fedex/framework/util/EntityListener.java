package com.fedex.framework.util;

import java.time.Instant;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fedex.framework.model.entity.AuditableEntity;
import com.fedex.framework.model.entity.BaseEntity;
import com.fedex.framework.service.Audit;
import com.fedex.framework.service.AuditService;

public class EntityListener {

    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) entity;
            baseEntity.setCreatedEpochNbr(Instant.now().toEpochMilli());
        }

        if (entity instanceof AuditableEntity) {
            AuditableEntity auditEntity = (AuditableEntity) entity;
            auditEntity.setUpdatedEpochNbr(auditEntity.getCreatedEpochNbr());
            auditEntity.setUpdatedById(auditEntity.getCreatedById());
            auditEntity.setVersionNbr(1);
        }
    }
    
    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof AuditableEntity) {
            AuditableEntity auditEntity = (AuditableEntity) entity;
            auditEntity.setUpdatedEpochNbr(Instant.now().toEpochMilli());
            
            if (auditEntity.getVersionNbr() == null) { 
                auditEntity.setVersionNbr(1); 
            } else if (auditEntity.getVersionNbr() > 0) {
                auditEntity.setVersionNbr(auditEntity.getVersionNbr() + 1);
            }
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Object entity) {
        if (entity.getClass().isAnnotationPresent(Audit.class)) {
            SpringUtil.getBean(AuditService.class).audit(entity);
        }
    }
}
