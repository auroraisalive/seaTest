package me.aurorash.seaTest.commons;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{

    private String internalMessage;

    public BadRequestException(String message) {
        this.internalMessage = "BadRequest: " + message;
    }

}
