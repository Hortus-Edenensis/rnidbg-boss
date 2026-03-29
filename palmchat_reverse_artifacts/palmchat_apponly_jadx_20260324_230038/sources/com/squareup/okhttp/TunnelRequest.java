package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.ss.android.download.api.constant.BaseConstants;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class TunnelRequest {
    final String host;
    final int port;
    final String proxyAuthorization;
    final String userAgent;

    public TunnelRequest(String str, int i, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        if (str2 == null) {
            throw new NullPointerException("userAgent == null");
        }
        this.host = str;
        this.port = i;
        this.userAgent = str2;
        this.proxyAuthorization = str3;
    }

    public RawHeaders getRequestHeaders() {
        String str;
        RawHeaders rawHeaders = new RawHeaders();
        rawHeaders.setRequestLine("CONNECT " + this.host + ":" + this.port + " HTTP/1.1");
        if (this.port == Util.getDefaultPort(BaseConstants.SCHEME_HTTPS)) {
            str = this.host;
        } else {
            str = this.host + ":" + this.port;
        }
        rawHeaders.set("Host", str);
        rawHeaders.set("User-Agent", this.userAgent);
        String str2 = this.proxyAuthorization;
        if (str2 != null) {
            rawHeaders.set(HttpHeaders.PROXY_AUTHORIZATION, str2);
        }
        rawHeaders.set("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
        return rawHeaders;
    }
}
