package com.oplus.tblplayer.upstream;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.BaseDataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tblplayer.upstream.FileDescriptorDataSource;
import com.oplus.tblplayer.utils.AssertUtil;
import com.oplus.tblplayer.utils.FileDescriptorUtil;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FileDescriptorDataSource extends BaseDataSource {
    private static final String TAG = "FileDescriptorDataSource";
    private long mBytesRemaining;

    @NonNull
    private final FileDescriptor mFileDescriptor;

    @Nullable
    private InputStream mInputStream;
    private final long mLength;
    private final long mOffset;
    private boolean mOpened;
    private long mPosition;

    @Nullable
    private Uri mUri;

    /* JADX INFO: compiled from: SearchBox */
    public static final class FileDescriptorDataSourceException extends IOException {
        public FileDescriptorDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDescriptorDataSource(@NonNull FileDescriptor fileDescriptor, long j, long j2) {
        super(false);
        this.mFileDescriptor = (FileDescriptor) AssertUtil.checkNotNull(fileDescriptor);
        this.mOffset = j;
        this.mLength = j2;
    }

    public static DataSource.Factory getFactory(final FileDescriptor fileDescriptor, final long j, final long j2) {
        return new DataSource.Factory() { // from class: du1
            @Override // com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
            public final DataSource createDataSource() {
                return FileDescriptorDataSource.lambda$getFactory$0(fileDescriptor, j, j2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DataSource lambda$getFactory$0(FileDescriptor fileDescriptor, long j, long j2) {
        return new FileDescriptorDataSource(fileDescriptor, j, j2);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void close() throws IOException {
        this.mUri = null;
        try {
            try {
                InputStream inputStream = this.mInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new FileDescriptorDataSourceException(e);
            }
        } finally {
            this.mInputStream = null;
            if (this.mOpened) {
                this.mOpened = false;
                transferEnded();
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws IOException {
        this.mUri = dataSpec.uri;
        transferInitializing(dataSpec);
        if (!this.mFileDescriptor.valid()) {
            throw new FileDescriptorDataSourceException(new IOException("File descriptor is invalid."));
        }
        this.mInputStream = new FileInputStream(this.mFileDescriptor);
        long j = dataSpec.length;
        if (j != -1) {
            this.mBytesRemaining = j;
        } else {
            long j2 = this.mLength;
            if (j2 != -1) {
                j = j2 - dataSpec.position;
                this.mBytesRemaining = j;
            } else {
                this.mBytesRemaining = -1L;
            }
        }
        this.mPosition = this.mOffset + dataSpec.position;
        this.mOpened = true;
        transferStarted(dataSpec);
        return this.mBytesRemaining;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.mBytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            i2 = (int) Math.min(j, i2);
        }
        try {
            FileDescriptorUtil.seek(this.mFileDescriptor, this.mPosition);
            int i3 = ((InputStream) AssertUtil.checkNotNull(this.mInputStream)).read(bArr, i, i2);
            if (i3 == -1) {
                if (this.mBytesRemaining == -1) {
                    return -1;
                }
                throw new FileDescriptorDataSourceException(new EOFException());
            }
            long j2 = i3;
            this.mPosition += j2;
            long j3 = this.mBytesRemaining;
            if (j3 != -1) {
                this.mBytesRemaining = j3 - j2;
            }
            bytesTransferred(i3);
            return i3;
        } catch (IOException e) {
            throw new FileDescriptorDataSourceException(e);
        }
    }
}
