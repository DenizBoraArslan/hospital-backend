package com.db.exceptions.exepciton_enums;

import lombok.Getter;

@Getter
public enum MessageType
{
    NO_RECORD_EXIST ("",""),
    USERNAME_NOT_FOUND ("","Username not found"),
    GENERAL_EXCEPTION("",""),
    TOKEN_IS_EXPIRED("","Token is expired"),;

    private String code;
    private String message;

    MessageType(String code,String message)
    {
        this.code = code;
        this.message = message;

    }


}
