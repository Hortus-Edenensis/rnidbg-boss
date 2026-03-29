package com.zenmen.palmchat.circle.bridge.http;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class BaseResponse<T> extends Response<T> {
    private T data;
    private String errorMsg;
    private int resultCode;

    public BaseResponse(int i, String str) {
        this.resultCode = i;
        this.errorMsg = str;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public T getData() {
        return this.data;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public int getResultCode() {
        return this.resultCode;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public void setData(T t) {
        this.data = t;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public void setResultCode(int i) {
        this.resultCode = i;
    }
}
