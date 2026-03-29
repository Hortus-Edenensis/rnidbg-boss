package com.oplus.tbl.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.FileDataSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class FileDataSourceFactory implements DataSource.Factory {
    private final FileDataSource.Factory wrappedFactory;

    public FileDataSourceFactory() {
        this(null);
    }

    public FileDataSourceFactory(@Nullable TransferListener transferListener) {
        this.wrappedFactory = new FileDataSource.Factory().setListener(transferListener);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
    public FileDataSource createDataSource() {
        return this.wrappedFactory.createDataSource();
    }
}
