package com.heytap.mspsdk.exception;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MspBridgeWrapException extends MspSdkException {
    public MspBridgeWrapException(String str, Throwable th, int i) {
        super("bridge: " + str, th, i);
    }
}
