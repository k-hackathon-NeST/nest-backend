package com.khackathon.nest.domain.inquiry.controller;

import com.khackathon.nest.domain.inquiry.dto.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.service.InquiryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inquiries")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    @Operation(summary = "문의 글 작성 Api", description = "청소년이 문의 글을 작성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "문의 글 저장 후 Http 상태 코드(201)만 반환"),
    })
    @PostMapping
    public HttpStatus create(@RequestBody @Valid InquiryCreateRequest request) {
        inquiryService.create(request);
        return HttpStatus.CREATED;
    }
}
