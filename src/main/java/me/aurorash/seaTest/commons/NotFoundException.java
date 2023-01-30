package me.aurorash.seaTest.commons;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private String internalMessage;

    public NotFoundException(String message) {
        this.internalMessage = "NotFound: " + message;
    }

}
