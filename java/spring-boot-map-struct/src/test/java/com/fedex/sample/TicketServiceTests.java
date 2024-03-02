package com.fedex.sample;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fedex.sample.model.enums.TicketStatus;
import com.fedex.sample.model.value.Ticket;
import com.fedex.sample.service.TicketService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TicketServiceTests {
    private static Ticket ticket = new Ticket();

    @Autowired
    private TicketService service;

    @Test
    void test_01_getAllTickets() {
        List<Ticket> tickets = service.getAllTickets();

        assertThat(tickets).isNotNull();
        System.out.println(">>> all tickets " + tickets.size());

        if(tickets.size() > 0) {
            assertThat(tickets.get(0).getDetail()).isNull();
        }
    }

    @Test
    void test_02_createTicket() {
        ticket = new Ticket();
        ticket.setTitle("test ticket - " + System.currentTimeMillis());
        ticket.setDetail("test ticket creation by service");
        ticket.setCreatedBy("Test");

        // below should be ignored by service
        ticket.setId(10001L);
        ticket.setStatus(TicketStatus.CLOSED);

        ticket = service.createTicket(ticket);

        assertThat(ticket.getId()).isNotNull();
        System.out.println(">>> create ticket " + ticket.getId() + ".v." + ticket.getVersion());
    }

    @Test
    void test_03_getTicket() {
        Optional<Ticket> opt = service.getTicket(ticket.getId());

        assertThat(opt).isPresent();
        assertThat(opt.get().getId()).isEqualTo(ticket.getId());
        
        ticket = opt.get();
        System.out.println(">>> read ticket " + ticket.getId() + ".v." + ticket.getVersion());
    }

    @Test
    void test_04_updateTicket() {
        ticket.setDetail(ticket.getDetail() + ", updated " + System.currentTimeMillis());
        ticket.setUpdatedBy("Test");
        ticket = service.updateTicket(ticket);
        
        assertThat(ticket.getUpdatedBy()).isEqualTo("Test");
        assertThat(ticket.getUpdatedEpoch()).isNotNull();
        assertThat(ticket.getVersion()).isEqualTo(2);
        
        System.out.println(">>> update ticket " + ticket.getId() + ".v." + ticket.getVersion());
    }

    @Test
    void test_05_patchTicket() {
        Ticket ticket2 = new Ticket();
        ticket2.setId(ticket.getId());
        ticket2.setDetail(ticket.getDetail() + ", patched " + System.currentTimeMillis());
        
        ticket2 = service.patchTicket(ticket2);
        
        assertThat(ticket.getTitle()).isEqualTo(ticket2.getTitle());
        
        ticket = ticket2;

        System.out.println(">>> patch ticket " + ticket.getId() + ".v." + ticket.getVersion());        
    }

    @Test
    void test_06_deleteTicket() {
        service.deleteTicket(ticket.getId(), "Test");

        Optional<Ticket> opt = service.getTicket(ticket.getId());
        
        assertThat(opt.get().getVersion()).isEqualTo(-3);

        System.out.println(">>> delete ticket " + ticket.getId() + ".v." + ticket.getVersion());
    }
 
}
