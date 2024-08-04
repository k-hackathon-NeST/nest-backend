package com.khackathon.nest.domain.shelter.vo;

public interface ShelterInfoMapping {

    Long getId();
    String getName();
    String getAddress();
    int getCapacity();
    int getCurrentResident();
    String getProtectionPeriod();

}
