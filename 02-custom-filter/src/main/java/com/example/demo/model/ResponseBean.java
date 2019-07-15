package com.example.demo.model;

public class ResponseBean<T> {
    private boolean success;
    private T data;
    private String errCode;
    private String errMsg;

    public ResponseBean(){
        this.success = true;
    }

    public ResponseBean(T data){
        this.success = true;
        this.data = data;
    }

    public ResponseBean(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
