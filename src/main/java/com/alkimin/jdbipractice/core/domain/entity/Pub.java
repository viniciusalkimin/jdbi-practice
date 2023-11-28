package com.alkimin.jdbipractice.core.domain.entity;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pub implements Serializable {

    private UUID id;

    @NotBlank
    private String name;
    @NotBlank
    private String state;
    @NotBlank
    private String city;
    @NotBlank
    private String county;
    @NotBlank
    private String address;
}
