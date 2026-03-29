package com.oplus.tblplayer.upstream;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.upstream.cache.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TBLOkHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private Cache cache;

    @Nullable
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;

    @Nullable
    private final TransferListener listener;
    private boolean preferRedirectAddress;
    private boolean preferSubrangeRequest;

    @Nullable
    private final String userAgent;

    public TBLOkHttpDataSourceFactory(Call.Factory factory, @Nullable String str) {
        this(factory, str, null, null);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource.BaseFactory
    public HttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        TBLOkHttpDataSource tBLOkHttpDataSource = new TBLOkHttpDataSource(this.callFactory, this.userAgent, null, this.cacheControl, requestProperties, this.preferRedirectAddress, this.preferSubrangeRequest, this.cache);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            tBLOkHttpDataSource.addTransferListener(transferListener);
        }
        return tBLOkHttpDataSource;
    }

    public TBLOkHttpDataSourceFactory(Call.Factory factory, @Nullable String str, @Nullable TransferListener transferListener) {
        this(factory, str, transferListener, null);
    }

    public TBLOkHttpDataSourceFactory(Call.Factory factory, @Nullable String str, @Nullable TransferListener transferListener, @Nullable CacheControl cacheControl) {
        this(factory, str, transferListener, cacheControl, false, false, null);
    }

    public TBLOkHttpDataSourceFactory(Call.Factory factory, @Nullable String str, @Nullable TransferListener transferListener, @Nullable CacheControl cacheControl, boolean z, boolean z2, Cache cache) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl;
        this.preferRedirectAddress = z;
        this.preferSubrangeRequest = z2;
        this.cache = cache;
    }

    public TBLOkHttpDataSourceFactory(Call.Factory factory, @Nullable String str, @Nullable CacheControl cacheControl) {
        this(factory, str, null, cacheControl);
    }
}
