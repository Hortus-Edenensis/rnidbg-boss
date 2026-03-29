package com.oplus.tblplayer.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.FileDataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.upstream.crypto.AesCipherDataSource;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.wu0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLAesCipherDataSource implements DataSource {
    private static final String TAG = "TBLAesCipherDataSource";

    @Nullable
    private DataSource aesCipherDataSource;
    private final DataSource baseDataSource;
    private final Context context;

    @Nullable
    private DataSource dataSource;

    @Nullable
    private DataSource fileDataSource;
    private String key;
    long mBytesToRead;
    private final List<TransferListener> transferListeners = new ArrayList();

    public TBLAesCipherDataSource(String str, Context context, DataSource dataSource) {
        this.key = str;
        this.context = context.getApplicationContext();
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource);
    }

    private void addListenersToDataSource(DataSource dataSource) {
        for (int i = 0; i < this.transferListeners.size(); i++) {
            dataSource.addTransferListener(this.transferListeners.get(i));
        }
    }

    private DataSource getCryptedDataSource(String str, DataSource dataSource) {
        if (this.aesCipherDataSource == null) {
            AesCipherDataSource aesCipherDataSource = new AesCipherDataSource(str.getBytes(), dataSource);
            this.aesCipherDataSource = aesCipherDataSource;
            addListenersToDataSource(aesCipherDataSource);
        }
        return this.aesCipherDataSource;
    }

    private DataSource getFileDataSource() {
        if (this.fileDataSource == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.fileDataSource = fileDataSource;
            addListenersToDataSource(fileDataSource);
        }
        return this.fileDataSource;
    }

    private void maybeAddListenerToDataSource(@Nullable DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.addTransferListener(transferListener);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        this.baseDataSource.addTransferListener(transferListener);
        this.transferListeners.add(transferListener);
        maybeAddListenerToDataSource(this.fileDataSource, transferListener);
        maybeAddListenerToDataSource(this.aesCipherDataSource, transferListener);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void close() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.dataSource = null;
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        DataSource dataSource = this.dataSource;
        return dataSource == null ? wu0.a(this) : dataSource.getResponseHeaders();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        DataSource dataSource = this.dataSource;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws IOException {
        String str;
        DataSource fileDataSource;
        Assertions.checkState(this.dataSource == null);
        if (Util.isLocalFileUri(dataSpec.uri)) {
            str = this.key;
            fileDataSource = getFileDataSource();
        } else {
            str = this.key;
            fileDataSource = this.baseDataSource;
        }
        this.dataSource = getCryptedDataSource(str, fileDataSource);
        long jOpen = this.dataSource.open(dataSpec);
        this.mBytesToRead = jOpen;
        return jOpen;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = ((DataSource) Assertions.checkNotNull(this.dataSource)).read(bArr, i, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }
}
