package ru.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 02.05.2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prompt {
    private List<Message> messages;
    private String model;
}
