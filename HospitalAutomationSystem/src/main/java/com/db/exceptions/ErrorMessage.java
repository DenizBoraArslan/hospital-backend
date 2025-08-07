package com.db.exceptions;

import com.db.exceptions.exepciton_enums.MessageType;

public class ErrorMessage {

    private String ofStatic;

    private MessageType messageType;

    public ErrorMessage(MessageType messageType, String token) {
    }

    public String prepareErorMessage()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());
        if(this.ofStatic != null)
        {
            builder.append(" :" +ofStatic);
        }
        return builder.toString();
    }


}
