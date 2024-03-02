package com.fedex.sample.model.value;

import java.util.Map;

import com.fedex.sample.model.enums.TicketStatus;

import lombok.Data;

@Data
public class Ticket {
    private Long id;
    
    private String title;

    private String detail;
    
    private Map<String, Object> props;
    
    private TicketStatus status;

    private String createdBy;

    private Long createdEpoch;

    private String updatedBy;

    private Long updatedEpoch;

    private Integer version;
}
