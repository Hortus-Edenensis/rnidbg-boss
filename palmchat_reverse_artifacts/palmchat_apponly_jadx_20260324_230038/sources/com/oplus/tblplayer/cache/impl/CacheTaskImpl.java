package com.oplus.tblplayer.cache.impl;

import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.cache.Cache;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheWriter;
import com.oplus.tbl.exoplayer2.util.PriorityTaskManager;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.cache.DownloadRequest;
import com.oplus.tblplayer.cache.ICacheListener;
import com.oplus.tblplayer.cache.ICacheTask;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.executor.SafeRunnable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CacheTaskImpl extends SafeRunnable implements ICacheTask {
    private static final String TAG = "CacheTaskImpl";
    private long alreadyCachedBytes;

    @NonNull
    private final Cache cache;

    @Nullable
    private final ICacheListener cacheListener;

    @NonNull
    private final CacheWriter cacheWriter;
    private long contentLength;

    @NonNull
    private final DownloadRequest downloadRequest;
    private final AtomicBoolean isCanceled = new AtomicBoolean();
    private final AtomicBoolean isFinished = new AtomicBoolean();

    @Nullable
    private final PriorityTaskManager priorityTaskManager;

    public CacheTaskImpl(@NonNull DownloadRequest downloadRequest, @Nullable ICacheListener iCacheListener, @NonNull CacheDataSource.Factory factory, @Nullable PriorityTaskManager priorityTaskManager) {
        this.downloadRequest = (DownloadRequest) Util.castNonNull(downloadRequest);
        this.cacheListener = iCacheListener;
        this.priorityTaskManager = priorityTaskManager;
        this.cache = (Cache) Util.castNonNull(factory.getCache());
        this.cacheWriter = new CacheWriter(factory.createDataSource(), createDataSpec((DownloadRequest) Util.castNonNull(downloadRequest)), true, null, new CacheWriter.ProgressListener() { // from class: ow
            @Override // com.oplus.tbl.exoplayer2.upstream.cache.CacheWriter.ProgressListener
            public final void onProgress(long j, long j2, long j3) {
                this.f19885a.onProgress(j, j2, j3);
            }
        });
    }

    private static DataSpec createDataSpec(@NonNull DownloadRequest downloadRequest) {
        return new DataSpec.Builder().setUri((Uri) Util.castNonNull(downloadRequest.mediaUrl.getUri())).setKey(downloadRequest.mediaUrl.getCustomCacheKey()).setPosition(downloadRequest.position).setLength(downloadRequest.length).setFlags(4).build();
    }

    private boolean isEOFException(Exception exc) {
        return (exc instanceof EOFException) || (exc.getCause() != null && (exc.getCause() instanceof EOFException));
    }

    private void onCacheCancel() {
        ICacheListener iCacheListener = this.cacheListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheCancel(this.downloadRequest.mediaUrl);
        }
    }

    private void onCacheError(String str) {
        ICacheListener iCacheListener = this.cacheListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheError(this.downloadRequest.mediaUrl, 0, str);
        }
    }

    private void onCacheFinish(long j, long j2, long j3, long j4) {
        ICacheListener iCacheListener = this.cacheListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheFinish(this.downloadRequest.mediaUrl, j, j2, j3, j4);
        }
    }

    private void onCacheStart() {
        ICacheListener iCacheListener = this.cacheListener;
        if (iCacheListener != null) {
            iCacheListener.onCacheStart(this.downloadRequest.mediaUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(long j, long j2, long j3) {
        this.contentLength = j;
        this.alreadyCachedBytes = j2;
    }

    @Override // com.oplus.tblplayer.cache.ICacheTask
    public void cancel() {
        Thread.currentThread().interrupt();
        this.isCanceled.set(true);
        this.cacheWriter.cancel();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.downloadRequest.mediaUrl.equals(((CacheTaskImpl) obj).downloadRequest.mediaUrl);
    }

    @Override // com.oplus.tblplayer.cache.ICacheTask
    @NonNull
    public String getKey() {
        String customCacheKey = this.downloadRequest.mediaUrl.getCustomCacheKey();
        return customCacheKey == null ? this.downloadRequest.mediaUrl.toString() : customCacheKey;
    }

    public int hashCode() {
        return this.downloadRequest.hashCode();
    }

    @Override // com.oplus.tblplayer.cache.ICacheTask
    public boolean isFinished() {
        return this.isFinished.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x010f A[PHI: r0
      0x010f: PHI (r0v10 com.oplus.tbl.exoplayer2.util.PriorityTaskManager) = 
      (r0v5 com.oplus.tbl.exoplayer2.util.PriorityTaskManager)
      (r0v9 com.oplus.tbl.exoplayer2.util.PriorityTaskManager)
      (r0v17 com.oplus.tbl.exoplayer2.util.PriorityTaskManager)
     binds: [B:42:0x010d, B:46:0x0139, B:32:0x00c6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.oplus.tblplayer.utils.executor.SafeRunnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void safeRun() {
        PriorityTaskManager priorityTaskManager;
        long cachedBytes;
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 != null) {
            priorityTaskManager2.add(this.downloadRequest.priority);
        }
        String str = TAG;
        LogUtil.d(str, "TASK [" + this.downloadRequest.id + "] : Cache start.");
        onCacheStart();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            try {
                try {
                    Cache cache = this.cache;
                    String key = getKey();
                    DownloadRequest downloadRequest = this.downloadRequest;
                    cachedBytes = cache.getCachedBytes(key, downloadRequest.position, downloadRequest.length);
                } catch (InterruptedIOException | InterruptedException unused) {
                    LogUtil.d(TAG, "TASK [" + this.downloadRequest.id + "] : Cache cancel.");
                    onCacheCancel();
                    priorityTaskManager = this.priorityTaskManager;
                    if (priorityTaskManager != null) {
                    }
                }
            } catch (IOException e) {
                if (isEOFException(e)) {
                    LogUtil.d(TAG, "Reached to the end of the data.");
                    this.isFinished.set(true);
                } else {
                    LogUtil.d(TAG, "TASK [" + this.downloadRequest.id + "] : Cache error." + e.getMessage());
                    onCacheError(e.getMessage());
                }
                priorityTaskManager = this.priorityTaskManager;
                if (priorityTaskManager != null) {
                }
            }
            if (cachedBytes > 0) {
                LogUtil.d(str, "TASK [" + this.downloadRequest.id + "] : Cache maybe ignored. Already cached " + cachedBytes + " bytes.");
                onCacheFinish(this.downloadRequest.length, cachedBytes, cachedBytes, SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.isFinished.set(true);
                PriorityTaskManager priorityTaskManager3 = this.priorityTaskManager;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.remove(this.downloadRequest.priority);
                    return;
                }
                return;
            }
            while (!this.isFinished.get() && !this.isCanceled.get()) {
                PriorityTaskManager priorityTaskManager4 = this.priorityTaskManager;
                if (priorityTaskManager4 != null) {
                    priorityTaskManager4.proceed(this.downloadRequest.priority);
                }
                try {
                    this.cacheWriter.cache();
                    this.isFinished.set(true);
                } catch (Exception e2) {
                    if (!(e2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (e2 instanceof IOException) {
                            throw ((IOException) e2);
                        }
                        Util.sneakyThrow(e2);
                    }
                }
            }
            priorityTaskManager = this.priorityTaskManager;
            if (priorityTaskManager != null) {
                priorityTaskManager.remove(this.downloadRequest.priority);
            }
            if (this.isFinished.get()) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                LogUtil.d(TAG, "TASK [" + this.downloadRequest.id + "] : Cache finished. Already cached " + this.alreadyCachedBytes + " bytes, content length is " + this.contentLength + ", total cost " + jElapsedRealtime2 + " ms.");
                onCacheFinish(this.contentLength, 0L, this.alreadyCachedBytes, jElapsedRealtime2);
            }
        } catch (Throwable th) {
            PriorityTaskManager priorityTaskManager5 = this.priorityTaskManager;
            if (priorityTaskManager5 != null) {
                priorityTaskManager5.remove(this.downloadRequest.priority);
            }
            throw th;
        }
    }

    public String toString() {
        return "CacheTaskImpl {" + this.downloadRequest.id + "} @" + Integer.toHexString(hashCode());
    }
}
