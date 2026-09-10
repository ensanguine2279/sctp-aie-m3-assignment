package sg.edu.ntu.taskflow_api.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sg.edu.ntu.taskflow_api.model.Task;

@Service
public class AiServiceImpl implements AiService {

    Logger logger = LoggerFactory.getLogger(AiServiceImpl.class);

    @Value("${spring.ai.taskflow.sysprompt.role}")
    String roleSummarizer;

    @Value("${spring.ai.taskflow.sysprompt.scope}")
    String scopeSummarizer;

    @Value("${spring.ai.taskflow.sysprompt.tone}")
    String toneSummarizer;

    @Value("${spring.ai.taskflow.sysprompt.boundaries}")
    String boundariesSummarizer;

    // Main interface for interacting with the AI models
    private final ChatClient chatClient;

    public AiServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    // Constructs a system prompt for the AI model based on the provided role,
    // scope, tone, and boundaries.
    private String getSystemPrompt(String role, String scope, String tone, String boundaries) {
        return String.format(
                "Role: %s\nScope: %s\nTone: %s\nBoundaries: %s",
                role, scope, tone, boundaries);
    }

    // Summarizes a list of tasks using the AI model, returning a concise summary
    // based on the system prompt.
    @Override
    public String summarize(List<Task> tasks) {
        logger.info("Summarizing tasks: {}", tasks);

        return chatClient.prompt()
                .system(getSystemPrompt(roleSummarizer, scopeSummarizer, toneSummarizer, boundariesSummarizer))
                .user(tasks.toString())
                .call()
                .content();
    }
}
