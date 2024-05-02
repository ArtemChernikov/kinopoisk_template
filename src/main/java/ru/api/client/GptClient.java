package ru.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.api.model.Message;
import ru.api.model.Prompt;

import java.util.List;

@Service
public class GptClient extends BaseClient {
    private final String aiModel;

    @Autowired
    public GptClient(RestTemplateBuilder builder, @Value("${gpt.api.url}") String serverUrl,
                     @Value("${gpt.api.key}") String apiKey,
                     @Value("${gpt.api.headers}") String headers, @Value("${gpt.ai-model.url}") String aiModel) {
        super(
                builder.uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build(),
                apiKey, headers
        );
        this.aiModel = aiModel;
    }

    public ResponseEntity<Object> ask(Message message) {
        Prompt prompt = new Prompt(List.of(message), aiModel);
        return post("", prompt);
    }
}
