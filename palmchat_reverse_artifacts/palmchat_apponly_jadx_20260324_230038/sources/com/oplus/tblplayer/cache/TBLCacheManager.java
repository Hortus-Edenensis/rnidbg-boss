package com.oplus.tblplayer.cache;

import android.content.Context;
import android.content.Intent;
import com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl;
import com.oplus.tblplayer.cache.service.CacheManagerProxy;
import com.oplus.tblplayer.cache.service.RemoteCacheManagerService;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.AssertUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLCacheManager implements ICacheManager {
    private static final String TAG = "TBLCacheManager";
    private static volatile TBLCacheManager sCacheManagerInstance;
    private ICacheManager cacheManagerImpl;

    private TBLCacheManager(Context context, boolean z) {
        if (z) {
            this.cacheManagerImpl = new CacheManagerProxy(context, new Intent(context, (Class<?>) RemoteCacheManagerService.class));
        } else {
            this.cacheManagerImpl = new DefaultCacheManagerImpl(context);
        }
    }

    public static TBLCacheManager getCacheManager(Context context) {
        return getCacheManager(context, false);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        if (AssertUtil.checkState(this.cacheManagerImpl != null)) {
            this.cacheManagerImpl.registerCacheListener(iCacheListener);
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2) {
        if (AssertUtil.checkState(this.cacheManagerImpl != null)) {
            this.cacheManagerImpl.startCache(mediaUrl, j, j2);
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        if (AssertUtil.checkState(this.cacheManagerImpl != null)) {
            this.cacheManagerImpl.stopAllCache();
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        if (AssertUtil.checkState(this.cacheManagerImpl != null)) {
            this.cacheManagerImpl.stopCache(mediaUrl);
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        if (AssertUtil.checkState(this.cacheManagerImpl != null)) {
            this.cacheManagerImpl.unregisterCacheListener(iCacheListener);
        }
    }

    public static TBLCacheManager getCacheManager(Context context, boolean z) {
        if (AssertUtil.checkState(Globals.isPreCacheEnable(), "Must enable pre-cache in GlobalsConfig.") && sCacheManagerInstance == null) {
            synchronized (TBLCacheManager.class) {
                if (sCacheManagerInstance == null) {
                    Globals.maybeInitialize(context, null);
                    sCacheManagerInstance = new TBLCacheManager(context, z);
                }
            }
        }
        return sCacheManagerInstance;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2, int i) {
        if (AssertUtil.checkState(this.cacheManagerImpl != null)) {
            this.cacheManagerImpl.startCache(mediaUrl, j, j2, i);
        }
    }

    public void stopCache(String str) {
        stopCache(new MediaUrl.Builder(str).build());
    }

    public void startCache(String str, long j, long j2) {
        startCache(new MediaUrl.Builder(str).build(), j, j2);
    }

    public void startCache(String str, long j, long j2, int i) {
        startCache(new MediaUrl.Builder(str).build(), j, j2, i);
    }
}
