package com.heytap.mspsdk.exception;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MspUnHandledException extends MspSdkException {
    public MspUnHandledException(Throwable th) {
        super("unhandled: " + th.getMessage(), th, -1);
    }
}
