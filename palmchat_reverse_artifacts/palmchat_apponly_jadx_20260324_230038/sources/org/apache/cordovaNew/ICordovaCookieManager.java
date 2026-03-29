package org.apache.cordovaNew;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface ICordovaCookieManager {
    void clearCookies();

    void flush();

    String getCookie(String str);

    void setCookie(String str, String str2);

    void setCookiesEnabled(boolean z);
}
