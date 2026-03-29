package com.heytap.msp.ipc.common.exception;

import com.heytap.mspsdk.exception.MspSdkException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class IPCBridgeException extends MspSdkException {
    public IPCBridgeException(String str, int i) {
        super(i, str);
    }

    public IPCBridgeException(String str, Throwable th, int i) {
        super(str, th, i);
    }

    public IPCBridgeException(Throwable th, int i) {
        super(th.getMessage(), th, i);
    }
}
