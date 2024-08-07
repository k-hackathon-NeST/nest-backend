package com.khackathon.nest.infra.openai.controller;

import com.khackathon.nest.global.common.SuccessResponse;
import com.khackathon.nest.infra.openai.dto.request.ChatRequest;
import com.khackathon.nest.infra.openai.dto.response.ChatResponse;
import com.khackathon.nest.infra.openai.service.OpenAIService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open-ai")
public class OpenAIController {

    private final OpenAIService openAIService;

    @Operation(summary = "chatgpt 질문 요청 API")
    @PostMapping
    public ResponseEntity<SuccessResponse<ChatResponse>> question(
        @RequestBody @Valid ChatRequest request
    ) {
        return SuccessResponse.of(openAIService.question(request)).asHttp(HttpStatus.OK);
    }

}
