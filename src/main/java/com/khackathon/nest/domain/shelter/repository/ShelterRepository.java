package com.khackathon.nest.domain.shelter.repository;

import com.khackathon.nest.domain.shelter.entity.Shelter;
import com.khackathon.nest.domain.shelter.vo.ShelterInfoMapping;
import java.util.List;
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
        "ST_Distance(s.point, :point) as distance " +
        "FROM shelter s " +
        "WHERE ST_DWithin(s.point, :point, 4000) " +
        "ORDER BY distance ASC " +
        "LIMIT 5", nativeQuery = true)
    List<ShelterInfoMapping> getNearby(@Param("point") Point point);

}
