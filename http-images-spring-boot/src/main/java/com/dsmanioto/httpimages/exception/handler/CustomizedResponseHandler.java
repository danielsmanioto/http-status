package com.dsmanioto.httpimages.exception.handler;

import com.dsmanioto.httpimages.exception.ImageNotFoundException;
import com.dsmanioto.httpimages.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseHandler extends ResponseEntityExceptionHandler {

    private final ImageService service;

    @Autowired
    public CustomizedResponseHandler(ImageService service) {
        this.service = service;
    }

    @ExceptionHandler(ImageNotFoundException.class)
    public final ResponseEntity<byte[]> notFound(Exception ex, WebRequest request) {
        byte[] bytes = service.getImage("404");

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<byte[]> defaultException(Exception ex, WebRequest request) {
        byte[] bytes = service.getImage("500");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

}
