package com.ecommerce.orderservice.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@org.springframework.web.bind.annotation.ControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(ProductQuantityUnavailableException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
    		ProductQuantityUnavailableException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Prtoduct quantity not available");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardNumberNotValidException.class)
    public ResponseEntity<Object> handleNodataFoundException(
    		CardNumberNotValidException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Card number is invalid");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
