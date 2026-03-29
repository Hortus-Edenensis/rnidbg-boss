package com.oplus.tblplayer.cache.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.DefaultDataSourceFactory;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.upstream.cache.Cache;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource;
import com.oplus.tbl.exoplayer2.util.PriorityTaskManager;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.cache.DownloadRequest;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheManager;
import com.oplus.tblplayer.cache.ICacheTask;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.managers.TBLSourceManager;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.executor.DefaultDiscardPolicy;
import com.oplus.tblplayer.utils.executor.DefaultThreadFactory;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultCacheManagerImpl implements TransferListener, ICacheManager {
    private static final int CORE_SIZE = 2;
    private static final long KEEP_ALIVE_TIME = 900;
    private static final int MAX_BLOCKING_SIZE = 6;
    private static final int MAX_SIZE = 3;
    private static final String TAG = "DefaultCacheManagerImpl";
    private static final String THREAD_NAME = "preload";
    private final Context appContext;
    private ICacheListener cacheListener;

    @NonNull
    private final ICacheListener innerListener = new ICacheListener() { // from class: com.oplus.tblplayer.cache.impl.DefaultCacheManagerImpl.1
        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheCancel(MediaUrl mediaUrl) {
            if (DefaultCacheManagerImpl.this.cacheListener != null) {
                DefaultCacheManagerImpl.this.cacheListener.onCacheCancel(mediaUrl);
            }
            DefaultCacheManagerImpl.this.removeCacheTask(mediaUrl);
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheError(MediaUrl mediaUrl, int i, String str) {
            if (DefaultCacheManagerImpl.this.cacheListener != null) {
                DefaultCacheManagerImpl.this.cacheListener.onCacheError(mediaUrl, i, str);
            }
            DefaultCacheManagerImpl.this.removeCacheTask(mediaUrl);
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheFinish(MediaUrl mediaUrl, long j, long j2, long j3, long j4) {
            if (DefaultCacheManagerImpl.this.cacheListener != null) {
                DefaultCacheManagerImpl.this.cacheListener.onCacheFinish(mediaUrl, j, j2, j3, j4);
            }
            DefaultCacheManagerImpl.this.removeCacheTask(mediaUrl);
        }

        @Override // com.oplus.tblplayer.cache.ICacheListener
        public void onCacheStart(MediaUrl mediaUrl) {
            if (DefaultCacheManagerImpl.this.cacheListener != null) {
                DefaultCacheManagerImpl.this.cacheListener.onCacheStart(mediaUrl);
            }
        }
    };

    @NonNull
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue(6), new DefaultThreadFactory(THREAD_NAME), new DefaultDiscardPolicy());

    @NonNull
    private final CopyOnWriteArrayList<ICacheTask> cacheTasks = new CopyOnWriteArrayList<>();

    @NonNull
    private final Cache cache = (Cache) Util.castNonNull(Globals.getGlobalPreCache());
    private final PriorityTaskManager priorityTaskManager = Globals.getPriorityTaskManager();

    public DefaultCacheManagerImpl(Context context) {
        this.appContext = context;
    }

    private boolean addTask(ICacheTask iCacheTask) {
        return this.cacheTasks.add(iCacheTask);
    }

    public static CacheDataSource.Factory buildCacheDataSourceFactory(DataSource.Factory factory, Cache cache) {
        return new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(factory).setFlags(2);
    }

    private ICacheTask getCacheTask(MediaUrl mediaUrl) {
        String key = getKey(mediaUrl);
        for (ICacheTask iCacheTask : this.cacheTasks) {
            if (key.equals(iCacheTask.getKey())) {
                return iCacheTask;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCacheTask(MediaUrl mediaUrl) {
        String key = getKey(mediaUrl);
        for (ICacheTask iCacheTask : this.cacheTasks) {
            if (key.equals(iCacheTask.getKey())) {
                removeTask(iCacheTask);
                return;
            }
        }
    }

    private boolean removeTask(ICacheTask iCacheTask) {
        return this.cacheTasks.remove(iCacheTask);
    }

    private CacheTaskImpl wrapTask(MediaUrl mediaUrl, long j, long j2, int i) {
        return new CacheTaskImpl(new DownloadRequest.Builder(Integer.toString(i), mediaUrl).setPosition(Math.max(j, 0L)).setLength(j2).setPriority(i).build(), this.innerListener, buildCacheDataSourceFactory(buildDataSourceFactory(mediaUrl), this.cache), this.priorityTaskManager);
    }

    public DataSource.Factory buildDataSourceFactory(@NonNull MediaUrl mediaUrl) {
        HttpDataSource.Factory factoryBuildOkHttpDataSourceFactory = Globals.isOkhttpEnable() ? TBLSourceManager.buildOkHttpDataSourceFactory(Globals.getUserAgent(), Globals.getOkhttpCallFactory(), Globals.getOkhttpCacheControl()) : TBLSourceManager.buildHttpDataSourceFactory(Globals.getUserAgent());
        if (!mediaUrl.isHttpRequestHeadersEmpty()) {
            factoryBuildOkHttpDataSourceFactory.setDefaultRequestProperties((Map) Util.castNonNull(mediaUrl.getHeaders()));
        }
        return new DefaultDataSourceFactory(this.appContext, factoryBuildOkHttpDataSourceFactory);
    }

    public String getKey(MediaUrl mediaUrl) {
        String customCacheKey = mediaUrl.getCustomCacheKey();
        return customCacheKey == null ? mediaUrl.toString() : customCacheKey;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void registerCacheListener(ICacheListener iCacheListener) {
        this.cacheListener = iCacheListener;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2) {
        startCache(mediaUrl, j, j2, -1000);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopAllCache() {
        LogUtil.d(TAG, "stopAllCache schedule tasks size: " + this.cacheTasks.size());
        for (ICacheTask iCacheTask : this.cacheTasks) {
            iCacheTask.cancel();
            removeTask(iCacheTask);
            this.threadPoolExecutor.remove((Runnable) iCacheTask);
        }
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void stopCache(MediaUrl mediaUrl) {
        if (mediaUrl == null || TextUtils.isEmpty(mediaUrl.toString())) {
            LogUtil.d(TAG, "stopCache ignore due to empty url");
            return;
        }
        ICacheTask cacheTask = getCacheTask(mediaUrl);
        if (cacheTask == null || cacheTask.isFinished()) {
            return;
        }
        cacheTask.cancel();
        removeTask(cacheTask);
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void unregisterCacheListener(ICacheListener iCacheListener) {
        this.cacheListener = null;
    }

    @Override // com.oplus.tblplayer.cache.ICacheManager
    public void startCache(MediaUrl mediaUrl, long j, long j2, int i) {
        if (mediaUrl == null || TextUtils.isEmpty(mediaUrl.toString())) {
            LogUtil.d(TAG, "startCache ignore due to empty url.");
            return;
        }
        if (!TBLSourceManager.shouldRequirePreCache(mediaUrl)) {
            LogUtil.d(TAG, "startCache ignore due to local file.");
            return;
        }
        ICacheTask cacheTask = getCacheTask(mediaUrl);
        if (cacheTask != null) {
            LogUtil.d(TAG, "startCache ignore due to task already exists. " + cacheTask.toString());
            return;
        }
        CacheTaskImpl cacheTaskImplWrapTask = wrapTask(mediaUrl, j, j2, i);
        addTask(cacheTaskImplWrapTask);
        this.threadPoolExecutor.execute(cacheTaskImplWrapTask);
        LogUtil.d(TAG, "startCache schedule task: " + cacheTaskImplWrapTask.toString());
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onTransferEnd(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onTransferStart(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z) {
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(@NonNull DataSource dataSource, @NonNull DataSpec dataSpec, boolean z, int i) {
    }
}
