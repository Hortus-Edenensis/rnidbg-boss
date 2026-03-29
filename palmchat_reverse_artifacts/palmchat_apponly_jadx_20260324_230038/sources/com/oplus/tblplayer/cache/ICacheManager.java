package com.oplus.tblplayer.cache;

import com.oplus.tblplayer.misc.MediaUrl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ICacheManager {
    public static final long DEFAULT_CACHE_MIN_LENGTH = 1048576;

    void registerCacheListener(ICacheListener iCacheListener);

    void startCache(MediaUrl mediaUrl, long j, long j2);

    void startCache(MediaUrl mediaUrl, long j, long j2, int i);

    void stopAllCache();

    void stopCache(MediaUrl mediaUrl);

    void unregisterCacheListener(ICacheListener iCacheListener);
}
