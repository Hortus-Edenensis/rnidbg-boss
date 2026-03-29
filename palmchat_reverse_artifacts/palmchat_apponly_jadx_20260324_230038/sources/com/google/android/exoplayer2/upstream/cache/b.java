package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface b extends Cache.a {
    void b(Cache cache, String str, long j, long j2);

    void onCacheInitialized();

    boolean requiresCacheSpanTouches();
}
