package com.bytedance.sdk.openadsdk.core.m;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends SSLSocketFactory {
    protected SSLSocketFactory u = HttpsURLConnection.getDefaultSSLSocketFactory();
}
