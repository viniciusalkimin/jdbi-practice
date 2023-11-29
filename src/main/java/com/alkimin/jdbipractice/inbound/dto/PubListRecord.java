package com.alkimin.jdbipractice.inbound.dto;

import com.alkimin.jdbipractice.core.domain.entity.Pub;

import java.util.UUID;

public record PubListRecord(UUID id, String name, String state, String city, String county, String address) {
    public PubListRecord(Pub pub){
        this(pub.getId(), pub.getName(), pub.getState(), pub.getCity(), pub.getCounty(), pub.getAddress());
    }
}
