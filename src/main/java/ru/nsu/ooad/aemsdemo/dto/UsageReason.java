package ru.nsu.ooad.aemsdemo.dto;

/**
 * Причины использования реактива.
 */
public enum UsageReason {
    IMPORTED,             // Импортирован
    SYNTHESIZED,          // Синтезирован
    USED_FOR_SYNTHESIS,   // Использован для синтеза
    NOT_REGISTERED,       // Незарегистрированный расход
    USED_FOR_ANALYSIS,    // Использован для анализа
    EXPIRED,              // Истек срок годности
    DAMAGED,              // Поврежден
    LOST,                 // Утерян
    STOLEN,               // Украден
    USED_FOR_TESTING,     // Использован для тестирования
    USED_FOR_TEACHING,    // Использован в учебных целях
    RETURNED,             // Возвращен
    DISPOSED,             // Утилизирован
    SAMPLE_TAKEN,         // Взят образец
    ACCIDENTAL_SPILL,     // Случайное разливание
    QUALITY_CHECK         // Проверка качества
}