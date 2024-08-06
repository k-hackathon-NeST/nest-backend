package com.khackathon.nest.domain.admin.entity;

import com.khackathon.nest.domain.shelter.entity.Shelter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Admin {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "login_id")
    private String loginId;
    private Region region;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;
}
