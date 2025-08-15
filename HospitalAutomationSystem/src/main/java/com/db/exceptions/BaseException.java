package com.db.exceptions;

public class BaseException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public BaseException(ErrorMessage errorMessage) {

        super(errorMessage.prepareErorMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

}

