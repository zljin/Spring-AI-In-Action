package com.zljin.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DeepSeekController {

    @Resource
    private ChatClient chatClient;

    @GetMapping("/ai/chat")
    public String chat(@RequestParam("message") String message) {
        String response = chatClient.prompt().user(message).call().content();
        return "DeepSeek Response: " + response;
    }

    /**
     * 通过流的方式返回聊天内容
     * @param message
     * @return
     */
    @GetMapping(value = "/ai/stream/chat",produces = "text/html;charset=UTF-8")
    public Flux<String> chatStream(@RequestParam("message") String message) {
        Flux<String> response = chatClient.prompt()
                .user(message)
//                .system()
                .stream().content();
        return response;
    }
}
