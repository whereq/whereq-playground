package com.fedex.sample;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fedex.sample.model.entity.AuditEntity;
import com.fedex.sample.repository.AuditRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class AuditRepositoryTests {
    @Autowired
    private AuditRepository repo;

    @Test
    void test_00_init() {
        assertThat(repo).isNotNull();
    }

    @Test
    void test_01_findAll() {
        List<AuditEntity> entities = repo.findAll();
        entities.forEach(e -> System.out.println(String.format("audit:%s entity:%s.v.%s", e.getAuditId(), e.getEntityId(), e.getVersionNbr())));
        assertThat(entities).isNotEmpty();
    }

    @Test
    void test_02_lazy() {
        Optional<AuditEntity> entity = repo.findById(10010L);
        assertThat(entity).isPresent();

        AuditEntity e = entity.get();
        System.out.println(String.format("audit:%s entity:%s.v.%s json size:%s\n%s", e.getAuditId(), e.getEntityId(), e.getVersionNbr(), e.getEntityJson().length(), e.getEntityJson()));
        assertThat(e.getEntityJson()).isNotEmpty(); 

    }
}
