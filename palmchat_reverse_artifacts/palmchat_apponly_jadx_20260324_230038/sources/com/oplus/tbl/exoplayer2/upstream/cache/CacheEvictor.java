package com.oplus.tbl.exoplayer2.upstream.cache;

import com.oplus.tbl.exoplayer2.upstream.cache.Cache;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface CacheEvictor extends Cache.Listener {
    void onCacheInitialized();

    void onStartFile(Cache cache, String str, long j, long j2);

    boolean requiresCacheSpanTouches();
}
