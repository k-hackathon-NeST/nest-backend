package com.khackathon.nest.infra.openai.service;

import com.khackathon.nest.infra.openai.dto.request.ChatRequest;
import com.khackathon.nest.infra.openai.dto.response.ChatResponse;
import com.khackathon.nest.infra.openai.vo.ChatMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OpenAIService {

    @Value("${chatgpt.api-key}")
    private String API_KEY;
    private static final String ENDPOINT = "https://api.openai.com/v1/chat/completions";

    public ChatResponse question(ChatRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_KEY);

        List<ChatMessage> messages = new ArrayList<>();

        messages.add(new ChatMessage("system", "You are a counselor"));
        messages.add(new ChatMessage("user", request.getPrompt()));

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("messages", messages);
        requestBody.put("model","gpt-3.5-turbo");
        requestBody.put("temperature", 0.0f);
        requestBody.put("max_tokens", 50);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(ENDPOINT, requestEntity, Map.class);
        Map<String, Object> responseBody = response.getBody();
        return ChatResponse.of(responseBody.toString());
    }
}
