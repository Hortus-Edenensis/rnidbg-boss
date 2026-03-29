package com.zenmen.palmchat.messaging.smack;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class XMPPException extends Exception {
    private Throwable wrappedThrowable;

    public XMPPException() {
        this.wrappedThrowable = null;
    }

    public Throwable getWrappedThrowable() {
        return this.wrappedThrowable;
    }

    public XMPPException(String str) {
        super(str);
        this.wrappedThrowable = null;
    }

    public XMPPException(Throwable th) {
        this.wrappedThrowable = th;
    }

    public XMPPException(String str, Throwable th) {
        super(str);
        this.wrappedThrowable = th;
    }
}
