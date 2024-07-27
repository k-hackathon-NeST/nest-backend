package com.khackathon.nest.domain.inquiry.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Inquiry {
    @Id @GeneratedValue
    @Column(name = "inquiry_id")
    private Long id;

    private String content;

    //...
}
