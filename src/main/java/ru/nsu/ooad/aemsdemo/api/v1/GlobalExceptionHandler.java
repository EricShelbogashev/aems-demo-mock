package ru.nsu.ooad.aemsdemo.api.v1;

import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import java.util.*;
import java.util.stream.*;

/**
 * Глобальный обработчик исключений для обработки ошибок чтения HTTP-сообщений.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение MethodArgumentNotValidException, которое возникает при валидации аргументов метода контроллера.
     * Возвращает ResponseEntity с объектом ErrorResponseDto, содержащим информацию об ошибках валидации.
     *
     * @param ex Исключение MethodArgumentNotValidException, которое было сгенерировано при валидации аргументов метода.
     * @return ResponseEntity с объектом ErrorResponseDto в случае ошибок валидации или HttpStatus.OK в случае отсутствия ошибок.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex) {
        // Извлекаем ошибки валидации из объекта BindingResult
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        // Создаем объект ErrorResponseDto для возврата информации об ошибках
        ErrorResponseDto responseDto = new ErrorResponseDto("Ошибка валидации", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }

}
