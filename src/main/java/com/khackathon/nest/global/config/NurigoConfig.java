package com.khackathon.nest.global.config;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NurigoConfig {
    @Value("${nurigo.url}")
    private String nurigoUrl;

    @Value("${nurigo.api-key}")
    private String nurigoApiKey;

    @Value("${nurigo.secret-key}")
    private String nurigoSecretKey;

    @Bean
    public DefaultMessageService messageService() {
        return NurigoApp.INSTANCE.initialize(nurigoApiKey, nurigoSecretKey, nurigoUrl);
    }
}
