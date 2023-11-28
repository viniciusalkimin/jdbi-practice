package com.alkimin.jdbipractice.inbound.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PubCreatedRecord(UUID id, String name) {
}
