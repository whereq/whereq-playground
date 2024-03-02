package com.fedex.sample.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fedex.framework.model.entity.AuditableEntity;
import com.fedex.framework.service.Audit;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sample_ticket")
@Getter
@Setter
@Audit
public class TicketEntity extends AuditableEntity {

    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_TICKET_ID")
    @SequenceGenerator(name = "SEQ_TICKET_ID", sequenceName = "SEQ_TICKET_ID", allocationSize = 1)
    @Id
    @Column(name = "TICKET_ID_NBR")
    private Long ticketId;   

    @Column(name = "TICKET_TITLE_TXT")
    private String ticketTitle;

    @Column(name = "TICKET_DETAIL_DESC")
    private String ticketDetail;

    @Column(name = "TICKET_PROPS_JSON")
    private String ticketProps;

    @Column(name = "TICKET_STATUS_CD")
    private String ticketStatus;
}
