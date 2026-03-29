package com.zenmen.palmchat.peoplematch.bean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CommonResponse<T> {
    private T data;
    private String errorMsg;
    private int resultCode;

    public T getData() {
        return this.data;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }
}
