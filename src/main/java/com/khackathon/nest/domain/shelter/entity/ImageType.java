package com.khackathon.nest.domain.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImageType {

    MAIN("main"),
    SUB("sub");

    private final String imageTypeStr;

}
