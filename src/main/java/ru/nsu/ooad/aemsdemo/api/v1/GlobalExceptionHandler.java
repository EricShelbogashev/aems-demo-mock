package ru.nsu.ooad.aemsdemo.api.v1;

import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import java.util.*;
import java.util.stream.*;
import ru.nsu.ooad.aemsdemo.factory.exception.BaseException;

/**
 * Глобальный обработчик исключений для обработки ошибок чтения HTTP-сообщений.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение MethodArgumentNotValidException, которое возникает при валидации аргументов метода контроллера.
     * Возвращает ResponseEntity с объектом ErrorResponseDto, содержащим информацию об ошибках валидации.
     *
     * @param exception Исключение MethodArgumentNotValidException, которое было сгенерировано при валидации аргументов метода.
     * @return ResponseEntity с объектом ErrorResponseDto в случае ошибок валидации или HttpStatus.OK в случае отсутствия ошибок.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException exception) {
        // Извлекаем ошибки валидации из объекта BindingResult
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        // Создаем объект ErrorResponseDto для возврата информации об ошибках
        ErrorResponseDto responseDto = new ErrorResponseDto("Ошибка валидации", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponseDto> handleBaseException(BaseException exception) {
        List<String> errors = Collections.singletonList(exception.getMessage());

        ErrorResponseDto responseDto = new ErrorResponseDto("Ошибка валидации", errors);

        return ResponseEntity.badRequest().body(responseDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception exception) {
        exception.printStackTrace();

        List<String> errors = new ArrayList<>();

        ErrorResponseDto responseDto = new ErrorResponseDto("что-то пошло не так, проверьте запрос", errors);

        return ResponseEntity.badRequest().body(responseDto);
    }
}
