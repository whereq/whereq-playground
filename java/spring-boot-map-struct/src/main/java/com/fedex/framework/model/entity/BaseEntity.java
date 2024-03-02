package com.fedex.framework.model.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.fedex.framework.util.EntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(EntityListener.class)
public class BaseEntity {
    @Column(name = "CREATED_BY_ID", updatable = false)
    protected String createdById;

	@Column(name = "CREATED_EPOCH_NBR", updatable = false)
    protected Long createdEpochNbr;
}
