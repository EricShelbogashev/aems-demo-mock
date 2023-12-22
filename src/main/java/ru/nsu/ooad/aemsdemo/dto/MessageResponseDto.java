package ru.nsu.ooad.aemsdemo.dto;

/**
 * Класс передачи данных (DTO), представляющий ответ-сообщение.
 */
public record MessageResponseDto(String message) {
    /**
     * Создает объект MessageResponseDto с предоставленным сообщением.
     *
     * @param message Сообщение.
     * @throws IllegalArgumentException если предоставленное сообщение является null.
     */
    public MessageResponseDto {
        if (message == null) {
            throw new IllegalArgumentException("сообщение не должно быть null");
        }
    }
}
