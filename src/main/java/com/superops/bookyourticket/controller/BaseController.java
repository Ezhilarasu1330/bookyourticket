package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.constants.MessageConstants;
import com.superops.bookyourticket.constants.ResponseStatus;
import com.superops.bookyourticket.vo.BaseVO;
import com.superops.bookyourticket.vo.ResponseVO;

public class BaseController {

    public void success(final ResponseVO responseVO, final BaseVO response, final String message) {
        responseVO.setStatus(MessageConstants.SUCCESS);
        responseVO.setCode(ResponseStatus.SUCCESS.getCode());
        responseVO.setMessage(message);
        responseVO.setResponse(response);
    }

    public void error(final ResponseVO responseVO, final int code, final String message, final Throwable t) {
        responseVO.setStatus(MessageConstants.ERROR);
        responseVO.setCode(code);
        responseVO.setMessage(message);
    }

    public void userErrorHandler(final ResponseVO responseVO, final Throwable t) {
        switch (t.getMessage()) {
            case MessageConstants.USER_FIRST_NAME_NULL:
                this.error(responseVO, ResponseStatus.USER_FIRST_NAME_NULL.getCode(), ResponseStatus.USER_FIRST_NAME_NULL.getMessage(), t);
                break;
            case MessageConstants.USER_LAST_NAME_NULL:
                this.error(responseVO, ResponseStatus.USER_LAST_NAME_NULL.getCode(), ResponseStatus.USER_LAST_NAME_NULL.getMessage(), t);
                break;
            case MessageConstants.USER_MAIL_ID_NULL:
                this.error(responseVO, ResponseStatus.USER_MAIL_ID_NULL.getCode(), ResponseStatus.USER_MAIL_ID_NULL.getMessage(), t);
                break;
            case MessageConstants.USER_PASSWORD_NULL:
                this.error(responseVO, ResponseStatus.USER_PASSWORD_NULL.getCode(), ResponseStatus.USER_PASSWORD_NULL.getMessage(), t);
                break;
            case MessageConstants.USER_PHONE_NUMBER_NULL:
                this.error(responseVO, ResponseStatus.USER_PHONE_NUMBER_NULL.getCode(), ResponseStatus.USER_PHONE_NUMBER_NULL.getMessage(), t);
                break;
            case MessageConstants.USER_MAIL_ID_NOT_VALID:
                this.error(responseVO, ResponseStatus.USER_MAIL_ID_NOT_VALID.getCode(), ResponseStatus.USER_MAIL_ID_NOT_VALID.getMessage(), t);
                break;
            case MessageConstants.INVALID_REQUEST:
                this.error(responseVO, ResponseStatus.INVALID_REQUEST.getCode(), ResponseStatus.INVALID_REQUEST.getMessage(), t);
                break;
            case MessageConstants.ACC_DISABLED:
                this.error(responseVO, ResponseStatus.ACC_DISABLED.getCode(), ResponseStatus.ACC_DISABLED.getMessage(), t);
                break;
            default:
                this.error(responseVO, ResponseStatus.UNKNOWN_ERROR.getCode(), ResponseStatus.UNKNOWN_ERROR.getMessage(), t);

        }
    }
}
