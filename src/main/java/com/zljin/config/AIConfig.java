package com.zljin.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    /**
     * https://docs.spring.io/spring-ai/reference/api/chatclient.html#_default_system_text
     *
     * 角色预设
     * @param builder
     * @return
     */
    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem("You are a friendly chat bot that answers question in the voice of a Pirate")
                .build();
    }
}
