package com.fedex.framework.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class AuditableEntity extends BaseEntity {
    @Column(name = "UPDATED_BY_ID")
    protected String updatedById;

	@Column(name = "UPDATED_EPOCH_NBR")
    protected Long updatedEpochNbr;

    @Column(name = "VERSION_NBR")
    protected Integer versionNbr;

}
