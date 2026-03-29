package com.oplus.tbl.exoplayer2.ext.okhttp;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import okhttp3.CacheControl;
import okhttp3.Call;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class OkHttpDataSourceFactory extends HttpDataSource.BaseFactory {

    @Nullable
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;

    @Nullable
    private final TransferListener listener;

    @Nullable
    private final String userAgent;

    public OkHttpDataSourceFactory(Call.Factory factory) {
        this(factory, null, null, null);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource.BaseFactory
    public OkHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.callFactory, this.userAgent, this.cacheControl, requestProperties);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            okHttpDataSource.addTransferListener(transferListener);
        }
        return okHttpDataSource;
    }

    public OkHttpDataSourceFactory(Call.Factory factory, @Nullable String str) {
        this(factory, str, null, null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, @Nullable String str, @Nullable TransferListener transferListener) {
        this(factory, str, transferListener, null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, @Nullable String str, @Nullable TransferListener transferListener, @Nullable CacheControl cacheControl) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl;
    }

    public OkHttpDataSourceFactory(Call.Factory factory, @Nullable String str, @Nullable CacheControl cacheControl) {
        this(factory, str, null, cacheControl);
    }
}
