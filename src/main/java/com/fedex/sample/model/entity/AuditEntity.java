package com.fedex.sample.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="entity_audit")
@Getter
@Setter
public class AuditEntity {
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_ENTITY_AUDIT")
    @SequenceGenerator(name = "SEQ_ENTITY_AUDIT", sequenceName = "SEQ_ENTITY_AUDIT", allocationSize = 1)
    @Id
    @Column(name = "ENTITY_AUDIT_ID_NBR")
    private Long auditId;   

    @Column(name = "ENTITY_ID_NBR")
    protected Long entityId;

    @Column(name = "ENTITY_TYPE_CD")
    protected String entityType;

    @Column(name = "CREATED_BY_ID")
    protected String createdById;

	@Column(name = "CREATED_EPOCH_NBR")
    protected Long createdEpochNbr;

    @Column(name = "UPDATED_BY_ID")
    protected String updatedById;

	@Column(name = "UPDATED_EPOCH_NBR")
    protected Long updatedEpochNbr;

    @Column(name = "VERSION_NBR")
    protected Integer versionNbr;

    @Lob 	
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ENTITY_JSON")
    protected String entityJson;
}
