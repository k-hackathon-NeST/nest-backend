package com.khackathon.nest.domain.inquiry.controller;

import com.khackathon.nest.domain.inquiry.domain.InquiryCreateRequest;
import com.khackathon.nest.domain.inquiry.service.InquiryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inquiries")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    @Operation(summary = "문의 글 작성 Api", description = "청소년이 문의 글을 작성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "문의 글 저장 후 Http 상태 코드만 반환"),
            @ApiResponse(responseCode = "400", description = "I001: 문의 글 요청 값이 유효하지 않습니다.", content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid InquiryCreateRequest request) {
        inquiryService.create(request);
        return ResponseEntity.noContent().build();

        /**
         *  cf. 응답 값이 있는 경우
         *  리턴 타입 : ResponseEntity<SuccessResponse<InquiryCreateResponse>>
         *  리턴 값 : return SuccessResponse.of(inquiryService.create(request)).asHttp(HttpStatus.CREATED);
         */
    }

}
