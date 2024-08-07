package com.khackathon.nest.domain.shelter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "shelter_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShelterImage {

    @Id @GeneratedValue
    @Column(name = "shelter_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @Lob
    @Column(name = "image_code", nullable = false)
    private String imageCode;

    @Column(name = "image_type", nullable = false)
    private ImageType imageType;

    @Builder
    public ShelterImage(
        Shelter shelter,
        String imageCode,
        ImageType imageType
    ) {
        this.shelter = shelter;
        this.imageCode = imageCode;
        this.imageType = imageType;
    }

}
