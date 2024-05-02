package ru.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.api.client.GptClient;
import ru.api.client.KinopoiskClient;
import ru.api.model.Message;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 27.04.2024
 */
@RestController
@RequiredArgsConstructor
public class Controller {
    private final KinopoiskClient kinopoiskClient;
    private final GptClient gptClient;

    @GetMapping("/kinopoisk")
    public ResponseEntity<?> getKino() {
        return kinopoiskClient.getTop10Films();
    }

    @PostMapping("/gpt")
    public ResponseEntity<?> ask(@RequestBody Message message) {
        System.out.println(message);
        return gptClient.ask(message);
    }
}
