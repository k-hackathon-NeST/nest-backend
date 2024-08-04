package com.khackathon.nest.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "NeST",
                description = "K-해커톤 NeST Api 문서",
                version = "v1"),
        servers = @Server(url = "http://localhost:8080", description = "개발 서버")
)
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi allOpenApi() {
        String[] paths = {"/**"};

        return GroupedOpenApi
                .builder()
                .group("전체 API")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi inquiryOpenApi() {
        String[] paths = {"/api/inquiries/**"};

        return GroupedOpenApi
                .builder()
                .group("문의 API")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi shelterOpenApi() {
        String[] paths = {"/api/shelters/**"};

        return GroupedOpenApi
            .builder()
            .group("쉼터 API")
            .pathsToMatch(paths)
            .build();
    }

}
