package com.khackathon.nest.domain.inquiry.controller;

import com.khackathon.nest.domain.inquiry.dto.request.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.dto.request.InquiryReplyRequest;
import com.khackathon.nest.domain.inquiry.dto.response.InquiryResponse;
import com.khackathon.nest.domain.inquiry.dto.response.SimpleInquiryResponse;
import com.khackathon.nest.domain.inquiry.service.InquiryService;
import com.khackathon.nest.global.common.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            @ApiResponse(responseCode = "404", description = "I001: 요청에 해당하는 grade가 존재하지 않습니다.")
    })
    @PostMapping
    public HttpStatus create(@RequestBody @Valid InquiryCreateRequest request) {
        inquiryService.create(request);
        return HttpStatus.CREATED;
    }

    @Operation(summary = "문의 글 답변 Api", description = "관계자가 문의 글에 답변")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "문의 글 답변 저장 후 Http 상태코드(204)만 반환")
    })
    @PatchMapping
    public HttpStatus updateReply(@RequestBody @Valid InquiryReplyRequest request) {
        inquiryService.updateReply(request);
        return HttpStatus.NO_CONTENT;
    }

    @Operation(summary = "작성자별(청소년) 문의 글 조회 Api", description = "전화번호와 비밀번호로 식별된 글 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "해당 전화번호와 비밀번호 조건에 맞는 모든 문의 글 반환(없을 시 빈 배열 반환)")
    })
    @GetMapping("/{phone-number}/{password}")
    public ResponseEntity<SuccessResponse<List<InquiryResponse>>> getBy(@PathVariable("phone-number") String phoneNumber, @PathVariable("password") String password) {
        return SuccessResponse.of(inquiryService.getBy(phoneNumber, password))
                .asHttp(HttpStatus.OK);
    }

    @Operation(summary = "관계자별(해당 쉼터) 문의 글 조회 Api", description = "관계자 pk로 식별된 쉼터의 글 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping("/{admin-id}")
    public ResponseEntity<SuccessResponse<List<SimpleInquiryResponse>>> getSimpleBy(@PathVariable("admin-id") Long adminId) {
        return SuccessResponse.of(inquiryService.getSimpleBy(adminId))
                .asHttp(HttpStatus.OK);
    }

    @Operation(summary = "문의 글 상세 조회 Api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping("{inquiry-id}")
    public ResponseEntity<SuccessResponse<InquiryResponse>> getBy(@PathVariable("inquiry-id") Long inquiryId) {
        return SuccessResponse.of(inquiryService.getBy(inquiryId))
                .asHttp(HttpStatus.OK);
    }
}
