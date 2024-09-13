package com.whereq.common.audit;

import java.util.List;
import java.util.stream.Collectors;

import com.whereq.common.audit.entity.AuditRecord;
import com.whereq.common.audit.repo.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuditService {

	@Autowired(required = false)
	protected AuditRepository auditRepo;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public String findInstance() {
		return auditRepo.findInstance();
	}
		
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public <T> long saveAuditSync(String submitter, Long idNbr, T obj, String objSimpleNm) {
		log.info("(saveAudit) {}, idNbr: {}, Object Type given:{}", submitter, idNbr, objSimpleNm);
		AuditRecord rec = AuditUtil.getFromObject(objSimpleNm, obj, idNbr);
		AuditRecord r = auditRepo.save(rec);
		return r.getRecordAuditItemIdNbr();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public <T> void saveAudit(String submitter, Long idNbr, T obj, String objSimpleNm) {
		log.info("(saveAudit) {}, idNbr: {}, Object Type given:{}", submitter, idNbr, objSimpleNm);
		AuditRecord rec = AuditUtil.getFromObject(objSimpleNm, obj, idNbr);
		auditRepo.save(rec);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public <T> long saveAuditSync(String submitter, Long idNbr, T obj) {
		log.info("(saveAudit) {}, idNbr: {}, Object Type:{}", submitter, idNbr, obj.getClass().getSimpleName());
		AuditRecord rec = AuditUtil.getFromObject(obj.getClass().getSimpleName(), obj, idNbr);
		AuditRecord r = auditRepo.save(rec);
		return r.getRecordAuditItemIdNbr();
	}
	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public <T> void saveAudit(String submitter, Long idNbr, T obj) {
		log.info("(saveAudit) {}, idNbr: {}, Object Type:{}", submitter, idNbr, obj.getClass().getSimpleName());
		AuditRecord rec = AuditUtil.getFromObject(obj.getClass().getSimpleName(), obj, idNbr);
		auditRepo.save(rec);
	}
	
	public <T> List<T> getHistories(long id, String recordType,  TypeReference<List<T>> typeFormList) {
		return auditRepo.findByRecordIdNbrAndRecordTypeCdOrderByTransactionNbrDesc(id, recordType)
				.stream().map(e -> AuditUtil.getFromObject(e.getAuditRecordData(), typeFormList)).flatMap(List::stream).collect(Collectors.toList());
	}
	
	public <T> List<T> getHistories(long id, Class<T> clazz) {
		return auditRepo.findByRecordIdNbrAndRecordTypeCdOrderByTransactionNbrDesc(id, clazz.getSimpleName())
				.stream().map(e -> AuditUtil.getFromObject(e.getAuditRecordData(), clazz)).collect(Collectors.toList());
	}
}
