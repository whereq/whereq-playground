package com.fedex.sample.repository;

import com.fedex.framework.repository.AuditableRepository;
import com.fedex.sample.model.entity.TicketEntity;

public interface TicketRepository extends AuditableRepository<TicketEntity, Long>{
}
