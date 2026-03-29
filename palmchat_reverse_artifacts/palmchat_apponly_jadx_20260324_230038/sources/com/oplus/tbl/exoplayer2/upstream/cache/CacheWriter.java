package com.oplus.tbl.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.oplus.tbl.exoplayer2.upstream.DataSourceException;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.jp0;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class CacheWriter {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    private final boolean allowShortContent;
    private long bytesCached;
    private final Cache cache;
    private final String cacheKey;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private long endPosition;
    private boolean initialized;
    private volatile boolean isCanceled;
    private long nextPosition;

    @Nullable
    private final ProgressListener progressListener;
    private final byte[] temporaryBuffer;

    /* JADX INFO: compiled from: SearchBox */
    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, boolean z, @Nullable byte[] bArr, @Nullable ProgressListener progressListener) {
        this.dataSource = cacheDataSource;
        this.cache = cacheDataSource.getCache();
        this.dataSpec = dataSpec;
        this.allowShortContent = z;
        this.temporaryBuffer = bArr == null ? new byte[131072] : bArr;
        this.progressListener = progressListener;
        this.cacheKey = cacheDataSource.getCacheKeyFactory().buildCacheKey(dataSpec);
        this.nextPosition = dataSpec.position;
    }

    private long getLength() {
        long j = this.endPosition;
        if (j == -1) {
            return -1L;
        }
        return j - this.dataSpec.position;
    }

    private void onNewBytesCached(long j) {
        this.bytesCached += j;
        ProgressListener progressListener = this.progressListener;
        if (progressListener != null) {
            progressListener.onProgress(getLength(), this.bytesCached, j);
        }
    }

    private void onRequestEndPosition(long j) {
        if (this.endPosition == j) {
            return;
        }
        this.endPosition = j;
        ProgressListener progressListener = this.progressListener;
        if (progressListener != null) {
            progressListener.onProgress(getLength(), this.bytesCached, 0L);
        }
    }

    private long readBlockToCache(long j, long j2) throws IOException {
        long jOpen;
        boolean z = true;
        boolean z2 = j + j2 == this.endPosition || j2 == -1;
        try {
            if (j2 != -1) {
                try {
                    jOpen = this.dataSource.open(this.dataSpec.buildUpon().setPosition(j).setLength(j2).build());
                } catch (IOException e) {
                    if (!this.allowShortContent || !z2 || !DataSourceException.isCausedByPositionOutOfRange(e)) {
                        throw e;
                    }
                    Util.closeQuietly(this.dataSource);
                    jOpen = -1;
                    z = false;
                }
            } else {
                jOpen = -1;
                z = false;
            }
            if (!z) {
                throwIfCanceled();
                jOpen = this.dataSource.open(this.dataSpec.buildUpon().setPosition(j).setLength(-1L).build());
            }
            if (z2 && jOpen != -1) {
                onRequestEndPosition(jOpen + j);
            }
            int i = 0;
            int i2 = 0;
            while (i != -1) {
                throwIfCanceled();
                CacheDataSource cacheDataSource = this.dataSource;
                byte[] bArr = this.temporaryBuffer;
                i = cacheDataSource.read(bArr, 0, bArr.length);
                if (i != -1) {
                    onNewBytesCached(i);
                    i2 += i;
                }
            }
            if (z2) {
                onRequestEndPosition(j + ((long) i2));
            }
            return i2;
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }

    private void throwIfCanceled() throws InterruptedIOException {
        if (this.isCanceled) {
            throw new InterruptedIOException();
        }
    }

    @WorkerThread
    public void cache() throws IOException {
        long j;
        throwIfCanceled();
        if (!this.initialized) {
            DataSpec dataSpec = this.dataSpec;
            long j2 = dataSpec.length;
            if (j2 != -1) {
                this.endPosition = dataSpec.position + j2;
            } else {
                long jA = jp0.a(this.cache.getContentMetadata(this.cacheKey));
                if (jA == -1) {
                    jA = -1;
                }
                this.endPosition = jA;
            }
            Cache cache = this.cache;
            String str = this.cacheKey;
            DataSpec dataSpec2 = this.dataSpec;
            this.bytesCached = cache.getCachedBytes(str, dataSpec2.position, dataSpec2.length);
            ProgressListener progressListener = this.progressListener;
            if (progressListener != null) {
                progressListener.onProgress(getLength(), this.bytesCached, 0L);
            }
            this.initialized = true;
        }
        while (true) {
            long j3 = this.endPosition;
            if (j3 != -1 && this.nextPosition >= j3) {
                return;
            }
            throwIfCanceled();
            long j4 = this.endPosition;
            long cachedLength = this.cache.getCachedLength(this.cacheKey, this.nextPosition, j4 == -1 ? Long.MAX_VALUE : j4 - this.nextPosition);
            if (cachedLength > 0) {
                j = this.nextPosition;
            } else {
                long j5 = -cachedLength;
                if (j5 == Long.MAX_VALUE) {
                    j5 = -1;
                }
                j = this.nextPosition;
                cachedLength = readBlockToCache(j, j5);
            }
            this.nextPosition = j + cachedLength;
        }
    }

    public void cancel() {
        this.isCanceled = true;
    }
}
