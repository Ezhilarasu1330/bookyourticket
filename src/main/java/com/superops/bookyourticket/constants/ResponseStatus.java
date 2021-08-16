package com.superops.bookyourticket.constants;

import com.superops.bookyourticket.constants.MessageConstants;

public enum ResponseStatus {

    FORBIDDEN_ACCESS(MessageConstants.ACCESS_FORBIDDEN_CODE, MessageConstants.FORBIDDEN_ACCESS),
    BAD_CREDENTIALS(MessageConstants.ACCESS_FORBIDDEN_CODE, MessageConstants.BAD_CREDENTIALS),

    USER_FIRST_NAME_NULL(MessageConstants.VALIDATION_CODE, MessageConstants.USER_FIRST_NAME_NULL),
    USER_LAST_NAME_NULL(MessageConstants.VALIDATION_CODE, MessageConstants.USER_LAST_NAME_NULL),
    USER_MAIL_ID_NULL(MessageConstants.VALIDATION_CODE, MessageConstants.USER_MAIL_ID_NULL),
    USER_PASSWORD_NULL(MessageConstants.VALIDATION_CODE, MessageConstants.USER_PASSWORD_NULL),
    USER_PHONE_NUMBER_NULL(MessageConstants.VALIDATION_CODE, MessageConstants.USER_PHONE_NUMBER_NULL),
    USER_MAIL_ID_EXISTS(MessageConstants.VALIDATION_CODE, MessageConstants.USER_MAIL_ID_EXISTS),
    USER_MAIL_ID_NOT_VALID(MessageConstants.VALIDATION_CODE, MessageConstants.USER_MAIL_ID_NOT_VALID),
    USER_PHONE_NUMBER_NOT_VALID(MessageConstants.VALIDATION_CODE, MessageConstants.USER_PHONE_NUMBER_NOT_VALID),
    INVALID_REQUEST(MessageConstants.VALIDATION_CODE, MessageConstants.INVALID_REQUEST),
    ACC_DISABLED(MessageConstants.ACCESS_FORBIDDEN_CODE, MessageConstants.ACC_DISABLED),
    MAX_6_ALLOWED_TO_BOOK(MessageConstants.SUCCESS_CODE, MessageConstants.USER_CAN_BOOK_MAX_6_TICKETS),
    TICKET_ALREADY_BOOKED_BY_OTHER_USER(MessageConstants.SUCCESS_CODE, MessageConstants.TICKET_ALREADY_BOOKED_BY_OTHER_USER),

    SUCCESS(MessageConstants.SUCCESS_CODE, MessageConstants.SUCCESS),
    UNKNOWN_ERROR(MessageConstants.UNKNOWN_ERROR_CODE, MessageConstants.UNKNOWN_ERROR);

    private int code;
    private String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
