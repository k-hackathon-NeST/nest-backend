package com.khackathon.nest.domain.shelter.service;

import com.khackathon.nest.domain.admin.entity.Admin;
import com.khackathon.nest.domain.admin.repository.AdminRepository;
import com.khackathon.nest.domain.shelter.entity.ImageType;
import com.khackathon.nest.domain.shelter.entity.Shelter;
import com.khackathon.nest.domain.shelter.entity.ShelterImage;
import com.khackathon.nest.domain.shelter.repository.ShelterImageRepository;
import com.khackathon.nest.domain.shelter.repository.ShelterRepository;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ShelterImageService {

    private final AdminRepository adminRepository;
    private final ShelterRepository shelterRepository;
    private final ShelterImageRepository shelterImageRepository;

    @Transactional
    public void transMainPicture(
        Long adminId,
        Long shelterId,
        MultipartFile picture
    ) {
        //FIXME admin 인증
        Admin admin = adminRepository.getReferenceById(adminId);
        Shelter shelter = shelterRepository.getReferenceById(shelterId);

        shelterImageRepository.findByShelterAndImageType(shelter, ImageType.MAIN)
            .ifPresent(shelterImageRepository::delete);

        ShelterImage shelterImage = ShelterImage.builder()
            .shelter(shelter)
            .imageCode(imageToCode(picture))
            .imageType(ImageType.MAIN)
            .build();

        shelterImageRepository.save(shelterImage);
    }

    @Transactional
    public void transSubPicture(
        Long adminId,
        Long shelterId,
        List<Long> shelterImageIds,
        List<MultipartFile> pictures
    ) {
        //FIXME admin 인증
        Admin admin = adminRepository.getReferenceById(adminId);
        Shelter shelter = shelterRepository.getReferenceById(shelterId);

        if(shelterImageIds != null && !shelterImageIds.isEmpty()) {
            shelterImageIds.forEach(shelterImageId ->
                shelterImageRepository.findById(shelterImageId)
                    .ifPresent(shelterImageRepository::delete)
            );
        }

        pictures.forEach(picture -> {
            ShelterImage shelterImage = ShelterImage.builder()
                .shelter(shelter)
                .imageCode(imageToCode(picture))
                .imageType(ImageType.SUB)
                .build();

            shelterImageRepository.save(shelterImage);
        });
    }

    private String imageToCode(MultipartFile picture) {
        //FIXME
        try {
            return Base64.getEncoder().encodeToString(picture.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
