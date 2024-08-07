package com.khackathon.nest.domain.shelter.controller;

import com.khackathon.nest.domain.shelter.service.ShelterImageService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/shelter-images")
@RequiredArgsConstructor
public class ShelterImageController {

    private final ShelterImageService shelterImageService;

    @Operation(summary = "관계자용 쉼터 대표사진 수정 API")
    @PatchMapping(value = "/main/{admin-id}/{shelter-id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public HttpStatus transMainPicture(
        @PathVariable("admin-id") Long adminId,
        @PathVariable("shelter-id") Long shelterId,
        @RequestPart MultipartFile picture
    ) {
        shelterImageService.transMainPicture(
            adminId,
            shelterId,
            picture
        );

        return HttpStatus.NO_CONTENT;
    }

    @Operation(summary = "관계자용 쉼터 미리보기 사진 수정 API")
    @PatchMapping(value = "/sub", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public HttpStatus transSubPicture(
        @RequestParam(value = "adminId") Long adminId,
        @RequestParam(value = "shelterId") Long shelterId,
        @RequestParam(value = "shelterImageId", required = false) List<Long> shelterImageId,
        @RequestPart List<MultipartFile> pictures
    ) {
        shelterImageService.transSubPicture(
            adminId,
            shelterId,
            shelterImageId,
            pictures
        );

        return HttpStatus.NO_CONTENT;
    }


}
