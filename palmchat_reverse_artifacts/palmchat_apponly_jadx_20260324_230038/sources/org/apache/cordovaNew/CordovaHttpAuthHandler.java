package org.apache.cordovaNew;

import android.webkit.HttpAuthHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaHttpAuthHandler implements ICordovaHttpAuthHandler {
    private final HttpAuthHandler handler;

    public CordovaHttpAuthHandler(HttpAuthHandler httpAuthHandler) {
        this.handler = httpAuthHandler;
    }

    @Override // org.apache.cordovaNew.ICordovaHttpAuthHandler
    public void cancel() {
        this.handler.cancel();
    }

    @Override // org.apache.cordovaNew.ICordovaHttpAuthHandler
    public void proceed(String str, String str2) {
        this.handler.proceed(str, str2);
    }
}
