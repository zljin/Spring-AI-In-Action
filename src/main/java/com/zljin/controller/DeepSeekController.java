package com.zljin.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekController {

    private final ChatClient chatClient;

    @Autowired
    public DeepSeekController(ChatClient.Builder defaultChatClientBuilder) {
        this.chatClient = defaultChatClientBuilder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {
        // 调用 DeepSeek 的聊天 API
        String response = chatClient.prompt().user(message).call().content();
        return "DeepSeek Response: " + response;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "Error: " + ex.getMessage();
    }
}
