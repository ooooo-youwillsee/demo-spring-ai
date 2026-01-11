package com.ooooo.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author <a href="https://github.com/ooooo-youwillsee">ooooo</a>
 * @since 1.0.0
 */
@Slf4j
@SpringBootTest
public class ChatModelTest {


    @Autowired
    private ChatModel chatModel;

    @Test
    void testOllama() {
        Prompt prompt = Prompt.builder()
                .content("java编程")
                .chatOptions(
                        OllamaChatOptions.builder().model("deepseek-r1:8b")
                                .build())
                .build();
        ChatResponse response = chatModel.call(prompt);
        System.out.println(response.getResult().getOutput().getText());
    }
}
