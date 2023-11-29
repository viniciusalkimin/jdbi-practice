package com.alkimin.jdbipractice.core.domain.repository;

import com.alkimin.jdbipractice.core.domain.entity.Pub;
import com.alkimin.jdbipractice.inbound.dto.PubListRecord;

import java.util.List;

public interface PubDAO  {

    public Pub save(Pub pub);

    public Pub getById(String id);

    List<PubListRecord> getByParameter(String state, String city, String county);
}
