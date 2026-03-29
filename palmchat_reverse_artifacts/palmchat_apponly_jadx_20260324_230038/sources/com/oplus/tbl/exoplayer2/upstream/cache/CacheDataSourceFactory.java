package com.oplus.tbl.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.DataSink;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.FileDataSource;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSink;
import com.oplus.tbl.exoplayer2.upstream.cache.CacheDataSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class CacheDataSourceFactory implements DataSource.Factory {
    private final Cache cache;

    @Nullable
    private final CacheKeyFactory cacheKeyFactory;
    private final DataSource.Factory cacheReadDataSourceFactory;

    @Nullable
    private final DataSink.Factory cacheWriteDataSinkFactory;

    @Nullable
    private final CacheDataSource.EventListener eventListener;
    private final int flags;
    private final DataSource.Factory upstreamFactory;

    public CacheDataSourceFactory(Cache cache, DataSource.Factory factory) {
        this(cache, factory, 0);
    }

    public CacheDataSourceFactory(Cache cache, DataSource.Factory factory, int i) {
        this(cache, factory, new FileDataSource.Factory(), new CacheDataSink.Factory().setCache(cache), i, null);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
    public CacheDataSource createDataSource() {
        Cache cache = this.cache;
        DataSource dataSourceCreateDataSource = this.upstreamFactory.createDataSource();
        DataSource dataSourceCreateDataSource2 = this.cacheReadDataSourceFactory.createDataSource();
        DataSink.Factory factory = this.cacheWriteDataSinkFactory;
        return new CacheDataSource(cache, dataSourceCreateDataSource, dataSourceCreateDataSource2, factory == null ? null : factory.createDataSink(), this.flags, this.eventListener, this.cacheKeyFactory);
    }

    public CacheDataSourceFactory(Cache cache, DataSource.Factory factory, DataSource.Factory factory2, @Nullable DataSink.Factory factory3, int i, @Nullable CacheDataSource.EventListener eventListener) {
        this(cache, factory, factory2, factory3, i, eventListener, null);
    }

    public CacheDataSourceFactory(Cache cache, DataSource.Factory factory, DataSource.Factory factory2, @Nullable DataSink.Factory factory3, int i, @Nullable CacheDataSource.EventListener eventListener, @Nullable CacheKeyFactory cacheKeyFactory) {
        this.cache = cache;
        this.upstreamFactory = factory;
        this.cacheReadDataSourceFactory = factory2;
        this.cacheWriteDataSinkFactory = factory3;
        this.flags = i;
        this.eventListener = eventListener;
        this.cacheKeyFactory = cacheKeyFactory;
    }
}
