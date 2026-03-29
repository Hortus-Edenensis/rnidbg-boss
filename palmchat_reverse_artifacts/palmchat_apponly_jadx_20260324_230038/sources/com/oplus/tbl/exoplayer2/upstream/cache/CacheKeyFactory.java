package com.oplus.tbl.exoplayer2.upstream.cache;

import com.oplus.tbl.exoplayer2.upstream.DataSpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new CacheKeyFactory() { // from class: gw
        @Override // com.oplus.tbl.exoplayer2.upstream.cache.CacheKeyFactory
        public final String buildCacheKey(DataSpec dataSpec) {
            return jw.a(dataSpec);
        }
    };

    String buildCacheKey(DataSpec dataSpec);
}
