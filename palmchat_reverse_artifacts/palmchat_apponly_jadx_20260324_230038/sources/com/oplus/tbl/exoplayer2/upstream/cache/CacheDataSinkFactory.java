package com.oplus.tbl.exoplayer2.upstream.cache;

import com.oplus.tbl.exoplayer2.upstream.DataSink;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class CacheDataSinkFactory implements DataSink.Factory {
    private final int bufferSize;
    private final Cache cache;
    private final long fragmentSize;

    public CacheDataSinkFactory(Cache cache, long j) {
        this(cache, j, 20480);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSink.Factory
    public DataSink createDataSink() {
        return new CacheDataSink(this.cache, this.fragmentSize, this.bufferSize);
    }

    public CacheDataSinkFactory(Cache cache, long j, int i) {
        this.cache = cache;
        this.fragmentSize = j;
        this.bufferSize = i;
    }
}
