package com.khackathon.nest.domain.shelter.vo;

public interface ShelterInfoMapping {

    Long getId();
    String getName();
    String getDescription();
    int getCapacity();
    int getCurrentResident();
    String getPhoneNumber();
    String getOperationHour();
    String getProtectionPeriod();;
    String getShelterType();

}
