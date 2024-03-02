package com.fedex.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.sample.model.TicketMapper;
import com.fedex.sample.model.entity.TicketEntity;
import com.fedex.sample.model.value.Ticket;
import com.fedex.sample.repository.TicketRepository;

@Service
public class TicketService {
    @Autowired
    private TicketRepository repo;

    @Autowired
    private TicketMapper mapper;

    public List<Ticket> getAllTickets() {
        // stream + entity mapper 
        return repo.findAll().stream().map(mapper::toTicketWithoutDetail).collect(Collectors.toList());

        // entities mapper, this is the better approach!
        // return mapper.toTickets(repo.findAll());
    }

    public Optional<Ticket> getTicket(Long id)  {
        return repo.findById(id).map(mapper::toTicket);
    }

    public Ticket createTicket(Ticket ticket) {
        return mapper.toTicket(repo.save(mapper.toNewTicketEntity(ticket)));
    }

    public Ticket updateTicket(Ticket ticket) {
        if (ticket.getId() == null || ticket.getId() <= 0) throw new IllegalArgumentException("invalid ticket id");

        return mapper.toTicket( repo.save( 
            mapper.patchTicketEntity(
                repo.findById(ticket.getId()).orElseThrow(() -> new IllegalArgumentException("invalid ticket id " + ticket.getId())),
                ticket
            )
        ));
    }

    public Ticket patchTicket(Ticket ticket) {
        TicketEntity entity = repo.findById(ticket.getId()).orElseThrow(EntityNotFoundException::new);
        return mapper.toTicket( repo.save( mapper.patchTicketEntity(entity, ticket) ));
    }

    public Ticket deleteTicket(Long id, String deletedBy) {
        repo.deleteById(id, deletedBy);

        return mapper.toTicket( repo.findById(id).orElseThrow(EntityNotFoundException::new) );
    }
}
