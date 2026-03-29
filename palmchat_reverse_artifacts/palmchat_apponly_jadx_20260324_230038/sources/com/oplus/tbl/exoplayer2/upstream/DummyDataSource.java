package com.oplus.tbl.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DummyDataSource;
import defpackage.wu0;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class DummyDataSource implements DataSource {
    public static final DummyDataSource INSTANCE = new DummyDataSource();
    public static final DataSource.Factory FACTORY = new DataSource.Factory() { // from class: ni1
        @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
        public final DataSource createDataSource() {
            return DummyDataSource.a();
        }
    };

    private DummyDataSource() {
    }

    public static /* synthetic */ DummyDataSource a() {
        return new DummyDataSource();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public /* synthetic */ Map getResponseHeaders() {
        return wu0.a(this);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws IOException {
        throw new IOException("DummyDataSource cannot be opened");
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void close() {
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
    }
}
