package com.zenmen.palmchat.circle.bridge.http;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public abstract class Response<T> {
    public static final int CODE_ERROR = -1;
    public static final int CODE_OK = 0;

    public abstract T getData();

    public abstract String getErrorMsg();

    public abstract int getResultCode();

    public abstract void setData(T t);

    public abstract void setErrorMsg(String str);

    public abstract void setResultCode(int i);
}
