package com.alkimin.jdbipractice.outbound.serviceimpl;

import com.alkimin.jdbipractice.core.domain.entity.Pub;
import com.alkimin.jdbipractice.core.domain.service.PubService;
import com.alkimin.jdbipractice.inbound.dto.CreatePubRecord;
import com.alkimin.jdbipractice.inbound.dto.PubCreatedRecord;
import com.alkimin.jdbipractice.outbound.repository.PubDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PubServiceImpl implements PubService {

    private PubDAO pubDAO;

    @Override
    public PubCreatedRecord create(CreatePubRecord createPubRecord) {
        var pub = Pub.builder().id(UUID.randomUUID()).name(createPubRecord.name()).state(createPubRecord.state())
                .city(createPubRecord.city()).county(createPubRecord.county()).address(createPubRecord.address()).build();
        var pubCreated = pubDAO.save(pub);
        return PubCreatedRecord.builder().id(pubCreated.getId()).name(pubCreated.getName()).build();
    }
}
