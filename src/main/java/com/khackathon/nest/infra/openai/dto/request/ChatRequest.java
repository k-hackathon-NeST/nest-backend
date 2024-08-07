package com.khackathon.nest.infra.openai.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Schema(description = "chatgpt 질문 요청 request")
public class ChatRequest {

    @NotNull
    private final String prompt;

}
