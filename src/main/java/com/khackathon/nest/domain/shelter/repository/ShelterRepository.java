package com.khackathon.nest.domain.shelter.repository;

import com.khackathon.nest.domain.shelter.entity.Shelter;
import com.khackathon.nest.domain.shelter.vo.ShelterInfoMapping;
import com.khackathon.nest.domain.shelter.vo.ShelterSimpleInfoMapping;
import java.util.List;
import java.util.Optional;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    @Query(value = "SELECT s.shelter_id as id, s.name as name, s.address as address, " +
        "s.capacity as capacity, s.current_resident as currentResident, " +
        "s.protection_period as protectionPeriod, " +
        "si.image_code as imageCode, " +
        "ST_Distance(s.point, :point) as distance " +
        "FROM shelter s " +
        "LEFT JOIN shelter_image si ON s.shelter_id = si.shelter_id AND si.image_type = 'main' " +
        "WHERE ST_DWithin(s.point, :point, 4000) " +
        "ORDER BY distance ASC " +
        "LIMIT 5", nativeQuery = true)
    List<ShelterSimpleInfoMapping> findNearbyBy(@Param("point") Point point);

    @Query(value = "SELECT s.shelter_id as id, s.name as name, s.description as description, " +
        "s.capacity as capacity, s.current_resident as currentResident, " +
        "s.phone_number as phoneNumber, s.operation_hour as operationHour, " +
        "s.protection_period as protectionPeriod, s.shelter_type as shelterType " +
        "FROM shelter s " +
        "WHERE s.shelter_id = :id", nativeQuery = true)
    Optional<ShelterInfoMapping> getBy(@Param("id") Long id);

}
