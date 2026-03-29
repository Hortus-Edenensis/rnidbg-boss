package com.squareup.okhttp.internal.http;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface Policy {
    int getChunkLength();

    long getFixedContentLength();

    HttpURLConnection getHttpConnectionToCache();

    long getIfModifiedSince();

    URL getURL();

    boolean getUseCaches();

    void setSelectedProxy(Proxy proxy);

    boolean usingProxy();
}
