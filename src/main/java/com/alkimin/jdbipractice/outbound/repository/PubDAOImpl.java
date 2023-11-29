package com.alkimin.jdbipractice.outbound.repository;

import com.alkimin.jdbipractice.core.domain.repository.PubDAO;
import com.alkimin.jdbipractice.core.domain.entity.Pub;
import com.alkimin.jdbipractice.inbound.dto.PubListRecord;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.UseTemplateEngine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PubDAOImpl implements PubDAO {

    private final PubRepository pubRepository;

    public PubDAOImpl(Jdbi jdbi){
        this.pubRepository = jdbi.onDemand(PubRepository.class);
    }

    @Override
    public Pub save(Pub pub) {
        var id = pubRepository.insert(pub);
        return getById(id.toString());
    }

    @Override
    public Pub getById(String id) {

        Pub pub = pubRepository.getById(UUID.fromString(id));
        if(pub == null) {
            throw new RuntimeException("Error to find data.");
        }
        return pub;
    }

    @Override
    public List<PubListRecord> getByParameter(String state, String city, String county) {
        StringBuilder whereClause = new StringBuilder("WHERE 1 = 1");
        if(state != null) {
            whereClause.append(" AND pubs.state = '" + state + "'");
        }
        if(city != null) {
            whereClause.append(" AND city = '" +  city + "'");
        }
        if(county != null) {
            whereClause.append(" AND county = '" +  county + "'");
        }
        var pubs = pubRepository.getByParameters(whereClause.toString());
        return pubs.stream().map(PubListRecord::new).toList();
    }
}
