package com.alkimin.jdbipractice.outbound.repository;

import com.alkimin.jdbipractice.core.domain.entity.Pub;
import com.alkimin.jdbipractice.outbound.repository.PubRepository;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PubDAO {

    private final PubRepository pubRepository;

    public PubDAO(Jdbi jdbi){
        this.pubRepository = jdbi.onDemand(PubRepository.class);
    }

    public Pub save(Pub pub) {
        var id = pubRepository.insert(pub);
        return getById(id.toString());
    }

    private Pub getById(String id) {

        Pub pub = pubRepository.getById(UUID.fromString(id));
        if(pub == null) {
            throw new RuntimeException("Error to find data.");
        }
        return pub;
    }
}
