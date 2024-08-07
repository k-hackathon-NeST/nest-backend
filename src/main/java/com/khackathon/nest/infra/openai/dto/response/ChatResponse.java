package com.khackathon.nest.infra.openai.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ChatResponse {

    private final String answer;

    public static ChatResponse of(String answer){
        return ChatResponse.builder()
            .answer(answer)
            .build();
    }

}
