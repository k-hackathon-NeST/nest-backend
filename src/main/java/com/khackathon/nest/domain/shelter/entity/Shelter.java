package com.khackathon.nest.domain.shelter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Getter
@Entity
@Table(name = "shelter")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shelter {

    @Id
    @Column(name = "shelter_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, columnDefinition = "geometry(PointZ, 4326)")
    private Point point;

    @Column(nullable = false)
    private int capacity;

    @Column(name = "current_resident", nullable = false)
    private int currentResident;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "operation_hour", nullable = false)
    private String operationHour;

    @Enumerated(EnumType.STRING)
    @Column(name = "protection_period", nullable = false)
    private ProtectionPeriod protectionPeriod;

    @Builder
    public Shelter(
        Long id,
        String name,
        String address,
        String description,
        Point point,
        int capacity,
        int currentResident,
        String phoneNumber,
        String operationHour,
        ProtectionPeriod protectionPeriod
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.point = point;
        this.capacity = capacity;
        this.currentResident = currentResident;
        this.phoneNumber = phoneNumber;
        this.operationHour = operationHour;
        this.protectionPeriod =protectionPeriod;
    }


}