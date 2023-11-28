package com.alkimin.jdbipractice.inbound.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePubRecord(
        @NotBlank
        String name,
        @NotBlank
        String state,
        @NotBlank
        String city,
        @NotBlank
        String county,
        @NotBlank
        String address) {
}
