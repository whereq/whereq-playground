package com.fedex.sample;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedex.sample.model.entity.TicketEntity;
import com.fedex.sample.repository.TicketRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TicketRepositoryTests {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TicketRepository repo;

    private static TicketEntity entity = new TicketEntity();

    @Test
    void test_00_init() throws Exception {
        assertThat(repo).isNotNull();
    }

    @Test
    void test_01_create() throws Exception {
        entity.setTicketTitle("TicketRepositoryTests");
        entity.setTicketDetail("detail");
        entity.setCreatedById("Test");
        entity.setTicketProps(mapper.writeValueAsString(Collections.singletonMap("create.millis", System.currentTimeMillis())));

        entity = repo.save(entity);
        System.out.println(">>> Create entity " + entity.getTicketId() + ".v." + entity.getVersionNbr());
        assertThat(entity.getTicketId()).isNotNull();
    }

    @Test 
    void test_02_read() throws Exception {
        Optional<TicketEntity> opt = repo.findById(entity.getTicketId());
        
        assertThat(opt).isPresent();

        entity = opt.get();
        System.out.println(">>> Read entity " + entity.getTicketId() + ".v." + entity.getVersionNbr());
    }

    @Test
    void test_03_update() throws Exception {
        entity.setTicketDetail("detail updated");
        entity = repo.save(entity);
        assertThat(entity.getTicketDetail()).isEqualTo("detail updated");
        
        System.out.println(">>> Update entity " + entity.getTicketId() + ".v." + entity.getVersionNbr());
    }

    @Test
    void test_04_delete() throws Exception {
        repo.delete(entity);

        Optional<TicketEntity> opt = repo.findById(entity.getTicketId());
        assertThat(opt).isPresent();
        
        System.out.println(">>> Delete entity " + entity.getTicketId() + ".v." + entity.getVersionNbr());
    }
}
