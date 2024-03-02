package com.fedex.framework.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.fedex.framework.model.entity.AuditableEntity;

@NoRepositoryBean
public interface AuditableRepository<T extends AuditableEntity, K> extends JpaRepository<T, K> {
    default void deleteById(K id, String deletedBy) {
        T entity = findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setUpdatedById(deletedBy);
        
        delete(entity);
    }

    default void delete(T entity) {
        int version = entity.getVersionNbr() == null ? -1 : entity.getVersionNbr().intValue();
        
        if (version == 0) version = -1; else if (version > 0) version = -version;
        
        entity.setVersionNbr(version);
        save(entity);
    }

    @Query("select e from #{#entityName} e where e.versionNbr > 0")
    List<T> findAll();
}
