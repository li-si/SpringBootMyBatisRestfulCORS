package com.sli.healthtest.model;

/**
 * @author sli
 * @since 2016/10/27
 */
public class ResponseEntity<T> {

    private int status = 0;

    private String message = "";

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

