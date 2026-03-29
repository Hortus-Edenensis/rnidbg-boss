package com.oplus.tblplayer.config;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.PriorityTaskManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class PreCacheConfig {
    public static final int DEFAULT_MAX_CACHE_DIR_SIZE = 104857600;
    public static final int DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final String DEFAULT_PRECACHE_CONTENT_DIRECTORY = "download_cache";
    public final long maxCacheDirSize;
    public final long maxCacheFileSize;
    public final String preCacheDirPath;
    public final boolean preCacheEnable;
    public final PriorityTaskManager priorityTaskManager;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        public boolean preCacheEnable = false;
        public String preCacheDirPath = null;
        public long maxCacheDirSize = 104857600;
        public long maxCacheFileSize = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;

        public PreCacheConfig build() {
            return new PreCacheConfig(this.preCacheEnable, this.preCacheDirPath, this.maxCacheDirSize, this.maxCacheFileSize);
        }

        public Builder setMaxCacheDirSize(long j) {
            this.maxCacheDirSize = j;
            return this;
        }

        public Builder setMaxCacheFileSize(long j) {
            this.maxCacheFileSize = j;
            return this;
        }

        public Builder setPreCacheDir(String str) {
            this.preCacheDirPath = str;
            return this;
        }

        public Builder setPreCacheEnable(boolean z) {
            this.preCacheEnable = z;
            return this;
        }
    }

    private PreCacheConfig(boolean z, @Nullable String str, long j, long j2) {
        this.preCacheEnable = z;
        this.preCacheDirPath = str;
        this.maxCacheDirSize = j;
        this.maxCacheFileSize = j2;
        this.priorityTaskManager = new PriorityTaskManager();
    }

    public String toString() {
        return "PreCacheConfig{preCacheEnable=" + this.preCacheEnable + ", preCacheDirPath=" + this.preCacheDirPath + ", maxCacheDirSize=" + this.maxCacheDirSize + ", maxCacheFileSize=" + this.maxCacheFileSize + "}";
    }
}
