package com.superops.bookyourticket.vo;

public class ResponseVO extends BaseVO{

    private int code;
    private String status;
    private String message;
    private BaseVO response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseVO getResponse() {
        return response;
    }

    public void setResponse(BaseVO response) {
        this.response = response;
    }
}
