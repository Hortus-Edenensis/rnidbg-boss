package com.heytap.mspsdk.exception;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MspSdkException extends RuntimeException {
    private int code;

    public MspSdkException(int i, String str) {
        super(str);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "MspSdkException{code=" + this.code + ",message=" + super.toString() + '}';
    }

    public MspSdkException(String str, Throwable th, int i) {
        super(str, th);
        this.code = i;
    }
}
