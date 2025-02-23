package com.zljin.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekController {

    @Resource
    private ChatClient chatClient;

    @GetMapping("/ai/chat")
    public String chat(@RequestParam("message") String message) {
        String response = chatClient.prompt().user(message).call().content();
        return "DeepSeek Response: " + response;
    }
}
