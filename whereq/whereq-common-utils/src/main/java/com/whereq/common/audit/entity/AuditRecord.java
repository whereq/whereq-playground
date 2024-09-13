package com.whereq.common.audit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.common.audit.AuditUtil;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AUDIT_LOG")
@Getter
@Setter
public class AuditRecord {
	private static ObjectMapper om = new ObjectMapper();
	static {
		om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	}

	@Id
	@SequenceGenerator(name="SEQ_AUDIT_LOG_ID_NBR", sequenceName="SEQ_AUDIT_LOG_ID_NBR", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "SEQ_AUDIT_LOG_ID_NBR")
	@Column(name="RECORD_AUDIT_ID_NBR", updatable=false)
	private long recordAuditItemIdNbr;

	@Column(name="RECORD_ID_NBR", updatable=false)
	private Long recordIdNbr;

	@Column(name="RECORD_TYPE_CD", updatable=false)
	private String recordTypeCd;

	@JsonIgnore
	@Lob
	@Column(name="AUDIT_RECORD_DATA")
	private String auditRecordData;

	@Column(name="TRANSACTION_NBR")
	private Long transactionNbr;
    public AuditRecord() {
	}

	public Object getRecord() {
		return AuditUtil.getFromObject(this.auditRecordData, recordTypeCd);
	}
	public AuditRecord(String recordTypeCd, long recordIdNbr, String auditRecordData, long transactionId) {
		this.recordTypeCd = recordTypeCd;
		this.recordIdNbr = recordIdNbr;
		this.auditRecordData = auditRecordData;
		this.transactionNbr = transactionId;
	}

}
