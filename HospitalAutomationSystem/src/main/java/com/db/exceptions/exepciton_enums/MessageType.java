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
    DOCTOR_FIRST_NAME_CANNOT_BE_NULL("ERR_13", "Doctor first name cannot be null"),
    DOCTOR_LAST_NAME_CANNOT_BE_NULL("ERR_14", "Doctor last name cannot be null"),
    DOCTOR_EMAIL_CANNOT_BE_NULL("ERR_15", "Doctor email cannot be null"),
    DOCTOR_GENDER_CANNOT_BE_NULL("ERR_16", "Doctor gender cannot be null"),
    DOCTOR_NOT_FOUND("ERR_17", "Doctor not found"),
    APPOINTMENT_ID_CANNOT_BE_NULL("ERR_18", "Appointment id cannot be null"),
    DOCTOR_ID_MUST_BE_NULL("ERR_19", "Doctor id must be null"),
    DEPARTMENT_CANNOT_BE_NULL("ERR_20", "Department cannot be null"),
    GENDER_CANNOT_BE_NULL("ERR_21", "Gender cannot be null"),
    EMPLOYEE_FIRSTNAME_CANNOT_BE_NULL("ERR_22", "Employee first name cannot be null"),
    EMPLOYEE_LASTNAME_CANNOT_BE_NULL("ERR_23", "Employee last name cannot be null"),
    EMPLOYEE_GENDER_CANNOT_BE_NULL("ERR_24", "Employee gender cannot be null"),
    EMPLOYEE_EMAIL_CANNOT_BE_NULL("ERR_24", "Employee email cannot be null"),
    EMPLOYEE_ROLE_CANNOT_BE_NULL("ERR_25", "Employee role cannot be null"),
    EXIST_BY_EMAIL("ERR_26", "This email is used in the system"),
    USER_FIRSTNAME_CANNOT_BE_NULL("ERR_27", "User first name cannot be null"),
    USER_LASTNAME_CANNOT_BE_NULL("ERR_28", "User last name cannot be null"),
    USER_EMAIL_CANNOT_BE_NULL("ERR_29", "User email cannot be null"),
    USER_EMAIL_CANNOT_FOUND("ERR_30", "User email cannot found"),
    INVALID_PASSWORD("ERR_31", "Invalid password"),
    EXAMINATION_ID_NOT_FOUND("ERR_32", "Examination id not found"),
    APPOINTMENT_ID_NOT_FOUND("ERR_32", "Appointment id not found"),
    PRESCRIPTION_ITEM_ID_NOT_FOUND("ERR_32", "Appointment id not found"),

    GENERAL_EXCEPTION("500", "Something went wrong");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;

    }


}
