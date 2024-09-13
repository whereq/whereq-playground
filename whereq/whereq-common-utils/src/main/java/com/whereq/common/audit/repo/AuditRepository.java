package com.whereq.common.audit.repo;

import java.util.List;

import com.whereq.common.audit.entity.AuditRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuditRepository extends CrudRepository<AuditRecord, Long> {
    @Query(value = "select sys_context('USERENV','DB_DOMAIN') ||':'||sys_context('USERENV','DB_NAME') ||':'||sys_context('USERENV','CURRENT_SCHEMA') as Instance from dual", nativeQuery = true)
    String findInstance();
    List<AuditRecord> findByRecordIdNbrAndRecordTypeCdOrderByTransactionNbrDesc(long formIdNbr, String typeCd);
    List<AuditRecord> findByRecordIdNbrOrderByTransactionNbrDesc(long formIdNbr);
}
