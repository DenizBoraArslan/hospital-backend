package com.db.exceptions.exepciton_enums;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("ERR_01", "No record found "),
    USERNAME_NOT_FOUND("ERR_02", "Username not found"),
    USER_NOT_FOUND("ERR_03", "User not found"),
    APPOINTMENT_NOT_FOUND("ERR_04", "Appointment not found"),
    APPOINTMENT_CANNOT_BE_NULL("ERR_05", "Appointment cannot be null"),
    PATIENT_CANNOT_BE_NULL("ERR_06", "Patient cannot be null"),
    PATIENT_ID_CANNOT_BE_NULL("ERR_07", "Patient id cannot be null"),
    DOCTOR_CANNOT_BE_NULL("ERR_08", "Doctor cannot be null"),
    DOCTOR_ID_CANNOT_BE_NULL("ERR_9", "Doctor id cannot be null"),
    APPOINTMENT_DATE_CANNOT_BE_NULL("ERR_10", "Appointment date cannot be null"),
    STATUS_CANNOT_BE_NULL("ERR_11", "Status cannot be null"),
    NO_CONTENT("ERR_12", "No content"),

    GENERAL_EXCEPTION("500", "Something went wrong");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;

    }


}
