package com.oplus.tblplayer.upstream;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.BaseDataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TBLEncryptDataSource extends BaseDataSource {
    private static final String TAG = "TBLEncryptDataSource";
    private int bytesRemaining;
    private final byte[] data;

    @Nullable
    private final IOException error;
    private boolean opened;
    private int readPosition;

    @Nullable
    private Uri uri;

    public TBLEncryptDataSource(byte[] bArr, @Nullable IOException iOException) {
        super(false);
        this.data = bArr;
        this.error = iOException;
    }

    private void maybeThrowInitializationError() throws IOException {
        IOException iOException = this.error;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void close() {
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
        this.uri = null;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws IOException {
        LogUtil.d(TAG, "open: " + dataSpec);
        maybeThrowInitializationError();
        this.uri = dataSpec.uri;
        transferInitializing(dataSpec);
        long j = dataSpec.position;
        int i = (int) j;
        this.readPosition = i;
        long length = dataSpec.length;
        if (length == -1) {
            length = ((long) this.data.length) - j;
        }
        int i2 = (int) length;
        this.bytesRemaining = i2;
        if (i2 > 0 && i + i2 <= this.data.length) {
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesRemaining;
        }
        throw new IOException("Unsatisfiable range: [" + this.readPosition + ", " + dataSpec.length + "], length: " + this.data.length);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int read(@NonNull byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.bytesRemaining;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(this.data, this.readPosition, bArr, i, iMin);
        this.readPosition += iMin;
        this.bytesRemaining -= iMin;
        bytesTransferred(iMin);
        return iMin;
    }
}
