package com.vertersoft.primo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongFormatException extends RuntimeException {

    public WrongFormatException(String message) {
        super(message);
    }
}
