package com.fedex.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fedex.framework.model.entity.AuditableEntity;
import com.fedex.framework.service.Audit;
import com.fedex.framework.util.JsonConverter;
import com.fedex.sample.model.entity.AuditEntity;
import com.fedex.sample.repository.AuditRepository;

@Service
public class AuditServiceImpl implements com.fedex.framework.service.AuditService{
    @Autowired
    AuditRepository repo;

    @PersistenceContext
	private EntityManager em;

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AuditEntity audit(Object target) {
        if (!(target instanceof AuditableEntity) || !target.getClass().isAnnotationPresent(Audit.class)) return null;
        
        AuditableEntity auditTarget = (AuditableEntity) target;
        Object id = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(auditTarget);
        if (!(id instanceof Long)) return null;

        AuditEntity audit = new AuditEntity();
        audit.setCreatedById(auditTarget.getCreatedById());
        audit.setCreatedEpochNbr(auditTarget.getCreatedEpochNbr());
        audit.setUpdatedById(auditTarget.getUpdatedById());
        audit.setUpdatedEpochNbr(auditTarget.getUpdatedEpochNbr());
        audit.setVersionNbr(auditTarget.getVersionNbr());
        audit.setEntityId((Long)id);
        audit.setEntityType(auditTarget.getClass().getSimpleName());

        audit.setEntityJson(JsonConverter.toJson(auditTarget));

        return repo.save(audit);
    }
}
