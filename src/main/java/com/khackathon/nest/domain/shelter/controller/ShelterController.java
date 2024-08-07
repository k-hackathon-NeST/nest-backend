package com.khackathon.nest.domain.shelter.controller;

import com.khackathon.nest.domain.shelter.dto.request.ShelterUpdateRequest;
import com.khackathon.nest.domain.shelter.dto.response.NearbyResponse;
import com.khackathon.nest.domain.shelter.dto.response.ShelterResponse;
import com.khackathon.nest.domain.shelter.service.ShelterService;
import com.khackathon.nest.global.common.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shelters")
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterService shelterService;

    @Operation(summary = "현재 위치 기반으로 쉼터 조회 API", description = "4km 거리 내, 최대 5개 쉼터 정렬, 가까운 거리순 default")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200")
    })
    @GetMapping
    public ResponseEntity<SuccessResponse<NearbyResponse>> findNearbyBy(
        @RequestParam Double longitude,
        @RequestParam Double latitude
    ) {
        return SuccessResponse.of(shelterService.findNearbyBy(longitude, latitude))
            .asHttp(HttpStatus.OK);
    }

    @Operation(summary = "쉼터 상세 조회 API")
    @GetMapping("{shelter-id}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404", description = "해당하는 쉼터가 존재하지 않습니다.")
    })
    public ResponseEntity<SuccessResponse<ShelterResponse>> getBy(
        @PathVariable("shelter-id") Long shelterId) {
        return SuccessResponse.of(shelterService.getBy(shelterId)).asHttp(HttpStatus.OK);
    }

    @Operation(summary = "관계자용 쉼터 조회 API", description = "쉼터 내용 수정 버튼")
    @GetMapping("/admin/{admin-id}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404", description = "해당하는 쉼터가 존재하지 않습니다.")
    })
    public ResponseEntity<SuccessResponse<ShelterResponse>> getByAdminId(
        @PathVariable("admin-id") Long adminId) {
        return SuccessResponse.of(shelterService.getByAdminId(adminId)).asHttp(HttpStatus.OK);
    }
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204"),
        @ApiResponse(responseCode = "404-1", description = "해당하는 쉼터가 존재하지 않습니다."),
        @ApiResponse(responseCode = "404-2", description = "해당하는 보호기간이 존재하지 않습니다."),
        @ApiResponse(responseCode = "404-3", description = "해당하는 쉼터의 type이 존재하지 않습니다.")
    })
    @Operation(summary = "관계자용 쉼터 내용 수정 API")
    @PatchMapping("/admin/info")

    public HttpStatus transInfo(@RequestBody @Valid ShelterUpdateRequest request) {
        shelterService.transInfo(request);
        return HttpStatus.NO_CONTENT;
    }

}
