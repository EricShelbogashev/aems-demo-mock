package ru.nsu.ooad.aemsdemo.api.v1;

import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import java.util.*;

/**
 * Глобальный обработчик исключений для обработки ошибок чтения HTTP-сообщений.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обработчик исключения, срабатывающий при HttpMessageNotReadableException.
     *
     * @param ex Исключение, сигнализирующее о том, что HTTP-сообщение не может быть прочитано.
     * @return ResponseEntity с объектом ErrorResponseDto содержащим информацию об ошибке.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorResponseDto responseDto = new ErrorResponseDto(Collections.singletonList("Входящий запрос имеет некорректную структуру и не может быть прочитан"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }
}
