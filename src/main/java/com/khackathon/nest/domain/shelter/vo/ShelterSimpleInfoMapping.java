package com.khackathon.nest.domain.shelter.vo;

public interface ShelterSimpleInfoMapping {

    Long getId();
    String getName();
    String getAddress();
    int getCapacity();
    int getCurrentResident();
    String getProtectionPeriod();

}
