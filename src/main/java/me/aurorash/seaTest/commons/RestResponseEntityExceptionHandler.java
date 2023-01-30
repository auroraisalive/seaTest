package me.aurorash.seaTest.commons;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.aurorash.seaTest.json.exceptions.GenericExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @ExceptionHandler(value = { NotFoundException.class})
    protected ResponseEntity<Object> handleConflictNF(
            RuntimeException ex, WebRequest request) throws IOException {

        NotFoundException notFoundException = (NotFoundException) ex;

        GenericExceptionResponse body = new GenericExceptionResponse(notFoundException.getInternalMessage());

        return handleExceptionInternal(ex, gson.toJson(body),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { BadRequestException.class})
    protected ResponseEntity<Object> handleConflictBR(
            RuntimeException ex, WebRequest request) throws IOException {

        BadRequestException badRequestException = (BadRequestException) ex;

        GenericExceptionResponse body = new GenericExceptionResponse(badRequestException.getInternalMessage());

        return handleExceptionInternal(ex, gson.toJson(body),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
