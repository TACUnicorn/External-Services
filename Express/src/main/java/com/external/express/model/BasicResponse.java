package com.external.express.model;

/**
 * Created by xuantang on 11/30/17.
 */

public class BasicResponse<T> {
    private int code;
    private String message;
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
