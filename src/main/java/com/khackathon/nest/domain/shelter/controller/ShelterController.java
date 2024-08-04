package com.khackathon.nest.domain.shelter.controller;

import com.khackathon.nest.domain.shelter.dto.response.NearbyResponse;
import com.khackathon.nest.domain.shelter.service.ShelterService;
import com.khackathon.nest.global.common.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        @ApiResponse(responseCode = "200", description = "쉼터 반환"),
        @ApiResponse(responseCode = "404", description = "요청에 해당하는 protection period 존재하지 않습니다.")
    })
    @GetMapping
    public ResponseEntity<SuccessResponse<NearbyResponse>> getNearby(
        @RequestParam Double longitude,
        @RequestParam Double latitude
    ) {
        return SuccessResponse.of(shelterService.getNearby(longitude, latitude)).asHttp(HttpStatus.OK);
    }

}
