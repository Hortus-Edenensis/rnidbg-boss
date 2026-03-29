package org.apache.harmony.javax.security.auth.callback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class UnsupportedCallbackException extends Exception {
    private static final long serialVersionUID = -6873556327655666839L;
    private Callback callback;

    public UnsupportedCallbackException(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public UnsupportedCallbackException(Callback callback, String str) {
        super(str);
        this.callback = callback;
    }
}
