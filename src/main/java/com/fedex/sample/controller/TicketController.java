package com.fedex.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fedex.sample.model.value.Ticket;
import com.fedex.sample.service.TicketService;
import static com.fedex.sample.model.constant.AppCode.*;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {
    @Autowired
    private TicketService service;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets(@RequestHeader(UID) String submitter) {
        return ResponseEntity.ok(service.getAllTickets());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ticket> getTicket(@RequestHeader(UID) String submitter, @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok( service.getTicket(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket Not Found " + id))
        );
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestHeader(UID) String submitter, @RequestBody Ticket ticket) {
        ticket.setCreatedBy(submitter);
        return ResponseEntity.ok(service.createTicket(ticket));
    }

    @PutMapping
    public ResponseEntity<Ticket> updateTicket(@RequestHeader(UID) String submitter, @RequestBody Ticket ticket) {
        ticket.setUpdatedBy(submitter);
        return ResponseEntity.ok(service.updateTicket(ticket));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Ticket> deleteTicket(@RequestHeader(UID) String submitter, @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.deleteTicket(id, submitter));
    }
}
