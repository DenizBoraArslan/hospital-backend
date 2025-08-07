package com.db.exceptions;

public class BaseException extends RuntimeException {

    public BaseException(ErrorMessage errorMessage)
    {
        super(errorMessage.prepareErorMessage());
    }

}
