package com.oplus.tblplayer.upstream;

import android.content.Context;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLAesCipherDataSourceFactory implements DataSource.Factory {
    private final DataSource.Factory baseDataSourceFactory;
    private final Context context;
    private final String key;

    @Nullable
    private final TransferListener listener;

    public TBLAesCipherDataSourceFactory(String str, Context context, DataSource.Factory factory) {
        this(str, context, null, factory);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
    public DataSource createDataSource() {
        TBLAesCipherDataSource tBLAesCipherDataSource = new TBLAesCipherDataSource(this.key, this.context, this.baseDataSourceFactory.createDataSource());
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            tBLAesCipherDataSource.addTransferListener(transferListener);
        }
        return tBLAesCipherDataSource;
    }

    public TBLAesCipherDataSourceFactory(String str, Context context, @Nullable TransferListener transferListener, DataSource.Factory factory) {
        this.key = str;
        this.context = context.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSourceFactory = factory;
    }
}
