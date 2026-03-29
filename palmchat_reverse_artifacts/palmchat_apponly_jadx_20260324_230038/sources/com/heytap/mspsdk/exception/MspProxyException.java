package com.heytap.mspsdk.exception;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MspProxyException extends MspSdkException {
    public MspProxyException(Throwable th) {
        super(th.getMessage(), th, -1);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
