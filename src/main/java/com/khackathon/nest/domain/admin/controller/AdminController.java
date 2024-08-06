package com.khackathon.nest.domain.admin.controller;

import com.khackathon.nest.domain.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "관계자 로그인 Api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공 시 상태코드(200)만 반환"),
            @ApiResponse(responseCode = "404", description = "A001: 해당하는 지역(소속)이 존재하지 않습니다."),
            @ApiResponse(responseCode = "404", description = "A002: 로그인 정보에 해당하는 사용자가 존재하지 않습니다.")
    })
    @GetMapping("/{region}/{loginId}")
    public HttpStatus login(@PathVariable String region, @PathVariable String loginId) {
        adminService.login(region, loginId);
        return HttpStatus.OK;
    }
}
