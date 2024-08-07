package com.khackathon.nest.domain.shelter.repository;

import com.khackathon.nest.domain.shelter.entity.ImageType;
import com.khackathon.nest.domain.shelter.entity.Shelter;
import com.khackathon.nest.domain.shelter.entity.ShelterImage;
import com.khackathon.nest.domain.shelter.vo.ShelterImageMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterImageRepository extends JpaRepository<ShelterImage, Long> {

    Optional<ShelterImage> findByShelterAndImageType(Shelter shelter, ImageType imageType);


    @Query("SELECT si.id as id, si.imageCode as imageCode, " +
        "si.imageType as imageType " +
        "From ShelterImage si " +
        "WHERE si.shelter = :shelter")
    List<ShelterImageMapping> findByShelter(@Param("shelter") Shelter shelter);

}
