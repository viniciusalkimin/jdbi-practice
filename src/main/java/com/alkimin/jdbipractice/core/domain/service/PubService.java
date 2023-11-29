package com.alkimin.jdbipractice.core.domain.service;

import com.alkimin.jdbipractice.core.domain.entity.Pub;
import com.alkimin.jdbipractice.inbound.dto.CreatePubRecord;
import com.alkimin.jdbipractice.inbound.dto.ParamSearch;
import com.alkimin.jdbipractice.inbound.dto.PubCreatedRecord;
import com.alkimin.jdbipractice.inbound.dto.PubListRecord;

import java.util.List;
import java.util.UUID;

public interface PubService {

    public PubCreatedRecord create(CreatePubRecord createPubRecord);

    List<PubListRecord> findByParameter(String state, String city, String county);
}
