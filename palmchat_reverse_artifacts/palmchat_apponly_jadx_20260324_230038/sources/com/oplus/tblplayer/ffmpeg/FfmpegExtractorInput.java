package com.oplus.tblplayer.ffmpeg;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.extractor.DefaultExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.upstream.ContentDataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.DefaultDataSource;
import com.oplus.tbl.exoplayer2.upstream.FileDataSource;
import com.oplus.tbl.exoplayer2.upstream.StatsDataSource;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.utils.ReflectUtil;
import com.wifi.ad.core.config.EventParams;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FfmpegExtractorInput implements ExtractorInput, Closeable {
    private static final long MAX_SKIP_BYTES = 262144;
    private static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_FILE = "file";
    private static final String SCHEME_RAW = "rawresource";
    private static final String TAG = "FfmpegExtractorInput";
    private static final long UNSET_VALUE = -1;
    private long currentPosition;
    private DataSource dataSource;
    private ExtractorInput extractorInput;
    private boolean isLocalFile = false;
    private ExtractorInput loadableInput;
    private DataSource realDataSource;
    private Uri uri;

    private boolean getDataSourceFromInput(ExtractorInput extractorInput) {
        this.dataSource = null;
        if (extractorInput instanceof DefaultExtractorInput) {
            this.dataSource = (DataSource) ReflectUtil.getField(extractorInput, DataSource.class, "dataReader");
            FfmpegUtil.d(TAG, "getDataSourceFromInput: " + this.dataSource);
            Uri uri = (Uri) ReflectUtil.getField(this.dataSource, Uri.class, "lastOpenedUri");
            this.uri = uri;
            this.isLocalFile = isLocalFileUri(uri.getScheme());
        }
        return this.dataSource != null;
    }

    private DataSource getRealDataSource(DataSource dataSource) {
        if (!(dataSource instanceof StatsDataSource)) {
            return null;
        }
        DataSource dataSource2 = (DataSource) ReflectUtil.getField(dataSource, DataSource.class, "dataSource");
        if (dataSource2 instanceof DefaultDataSource) {
            return (DataSource) ReflectUtil.getField(dataSource2, DataSource.class, "dataSource");
        }
        return null;
    }

    private boolean isLocalFileUri(String str) {
        return TextUtils.isEmpty(str) || SCHEME_FILE.equals(str) || SCHEME_ASSET.equals(str) || "content".equals(str) || "rawresource".equals(str) || SCHEME_ANDROID_RESOURCE.equals(str);
    }

    private boolean maybeDirectlySeekPosition(long j) {
        DataSource dataSource;
        RandomAccessFile randomAccessFile;
        StringBuilder sb;
        if (this.isLocalFile && (dataSource = this.realDataSource) != null) {
            if (dataSource instanceof ContentDataSource) {
                FileInputStream fileInputStream = (FileInputStream) ReflectUtil.getField(dataSource, FileInputStream.class, "inputStream");
                if (fileInputStream != null) {
                    try {
                        long size = fileInputStream.getChannel().position(j).size() - j;
                        if (size < 0) {
                            return false;
                        }
                        ReflectUtil.setField(this.realDataSource, Long.TYPE, "bytesRemaining", Long.valueOf(size));
                        updateExtractorInputPosition(j);
                        return true;
                    } catch (IOException e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append("Directly seek position failed. ");
                        sb.append(e.getMessage());
                        FfmpegUtil.i(TAG, sb.toString());
                        return false;
                    }
                }
            } else if ((dataSource instanceof FileDataSource) && (randomAccessFile = (RandomAccessFile) ReflectUtil.getField(dataSource, RandomAccessFile.class, SCHEME_FILE)) != null) {
                try {
                    randomAccessFile.seek(j);
                    long length = randomAccessFile.length() - j;
                    if (length < 0) {
                        return false;
                    }
                    ReflectUtil.setField(this.realDataSource, Long.TYPE, "bytesRemaining", Long.valueOf(length));
                    updateExtractorInputPosition(j);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    sb = new StringBuilder();
                    sb.append("Directly seek position failed. ");
                    sb.append(e.getMessage());
                    FfmpegUtil.i(TAG, sb.toString());
                    return false;
                }
            }
        }
        return false;
    }

    private boolean maybeUpdateExtractorInput(long j) throws InterruptedException, IOException {
        if (j < 0 || j == this.currentPosition) {
            return false;
        }
        if (!maybeDirectlySeekPosition(j) && !skipInputUntilPosition(this.extractorInput, j)) {
            FfmpegUtil.d(TAG, "maybeUpdateExtractorInput: will create new input");
            updateFfmpegExtractorInput(j);
        }
        return true;
    }

    private void updateExtractorInputPosition(long j) {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput != null) {
            ReflectUtil.setField(extractorInput, Long.TYPE, EventParams.KEY_CT_SDK_POSITION, Long.valueOf(j));
        }
    }

    private void updateFfmpegExtractorInput(long j) throws IOException {
        if (j != -1) {
            if (!getDataSourceFromInput(this.loadableInput)) {
                throw new IOException("Get data source failed.");
            }
            Util.closeQuietly(this.dataSource);
            DataSpec dataSpec = new DataSpec(this.uri, j, -1L, null);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jOpen = this.dataSource.open(dataSpec);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime2 > 10) {
                FfmpegUtil.i(TAG, "Data source reopen cost: " + jElapsedRealtime2);
            }
            if (jOpen != -1) {
                jOpen += j;
            }
            FfmpegUtil.d(TAG, "updateFfmpegExtractorInput: create new DefaultExtractorInput");
            this.realDataSource = getRealDataSource(this.dataSource);
            this.extractorInput = new DefaultExtractorInput(this.dataSource, j, jOpen);
        }
    }

    private void updateLoadableExtractorInput(long j) {
        ExtractorInput extractorInput = this.loadableInput;
        if (extractorInput != null) {
            ReflectUtil.setField(extractorInput, Long.TYPE, EventParams.KEY_CT_SDK_POSITION, Long.valueOf(j));
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.advancePeekPosition(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.extractorInput = null;
        this.dataSource = null;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getLength();
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getPeekPosition();
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getPosition();
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public int peek(byte[] bArr, int i, int i2) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0;
        }
        return extractorInput.peek(bArr, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) throws IOException {
        if (this.extractorInput == null) {
            return;
        }
        peekFully(bArr, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput, com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.extractorInput == null) {
            throw new IOException("Extractor input is null.");
        }
        FfmpegUtil.d(TAG, "readAt params: position = " + this.extractorInput.getPosition() + ", offset = " + i + ", size = " + i2);
        Assertions.checkNotNull(this.extractorInput);
        int i3 = this.extractorInput.read(bArr, i, i2);
        long position = this.extractorInput.getPosition();
        this.currentPosition = position;
        updateLoadableExtractorInput(position);
        return i3;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.readFully(bArr, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.resetPeekPosition();
    }

    public long seekToReadPosition(long j) throws InterruptedException, IOException {
        boolean z = this.isLocalFile;
        long length = getLength();
        if (z) {
            if (j > length || j < 0) {
                FfmpegUtil.d(TAG, "Seek position is not valid,return end of input");
                return -1L;
            }
        } else if (j >= length || j < 0) {
            throw new IOException("Seek position is not valid.");
        }
        Assertions.checkNotNull(this.extractorInput);
        if (maybeUpdateExtractorInput(j)) {
            long position = this.extractorInput.getPosition();
            this.currentPosition = position;
            updateLoadableExtractorInput(position);
        }
        return this.extractorInput.getPosition();
    }

    public void setExtractorInput(ExtractorInput extractorInput) throws IOException {
        if (this.loadableInput != extractorInput) {
            this.loadableInput = extractorInput;
            long position = extractorInput.getPosition();
            this.currentPosition = position;
            updateFfmpegExtractorInput(position);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e) throws Throwable {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.setRetryPosition(j, e);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public int skip(int i) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0;
        }
        return extractorInput.skip(i);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.skipFully(i);
    }

    public final boolean skipInputUntilPosition(ExtractorInput extractorInput, long j) throws InterruptedException, IOException {
        long position = j - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i, boolean z) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.advancePeekPosition(i, z);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.peekFully(bArr, i, i2, z);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.readFully(bArr, i, i2, z);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) throws IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.skipFully(i, z);
    }
}
