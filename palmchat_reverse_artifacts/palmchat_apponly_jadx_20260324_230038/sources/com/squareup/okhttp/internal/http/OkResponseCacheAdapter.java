package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.OkResponseCache;
import com.squareup.okhttp.ResponseSource;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class OkResponseCacheAdapter implements OkResponseCache {
    private final ResponseCache responseCache;

    public OkResponseCacheAdapter(ResponseCache responseCache) {
        this.responseCache = responseCache;
    }

    @Override // com.squareup.okhttp.OkResponseCache
    public CacheResponse get(URI uri, String str, Map<String, List<String>> map) throws IOException {
        return this.responseCache.get(uri, str, map);
    }

    @Override // com.squareup.okhttp.OkResponseCache
    public CacheRequest put(URI uri, URLConnection uRLConnection) throws IOException {
        return this.responseCache.put(uri, uRLConnection);
    }

    @Override // com.squareup.okhttp.OkResponseCache
    public void trackConditionalCacheHit() {
    }

    @Override // com.squareup.okhttp.OkResponseCache
    public void trackResponse(ResponseSource responseSource) {
    }

    @Override // com.squareup.okhttp.OkResponseCache
    public void maybeRemove(String str, URI uri) throws IOException {
    }

    @Override // com.squareup.okhttp.OkResponseCache
    public void update(CacheResponse cacheResponse, HttpURLConnection httpURLConnection) throws IOException {
    }
}
