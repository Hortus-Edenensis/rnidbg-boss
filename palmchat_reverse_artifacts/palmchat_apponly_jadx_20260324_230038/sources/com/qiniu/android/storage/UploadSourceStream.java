package com.qiniu.android.storage;

import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UploadSourceStream extends UploadSource {
    private String fileName;
    private String id;
    private InputStream inputStream;
    private long readOffset = 0;
    private boolean hasSize = false;
    private long size = -1;

    public UploadSourceStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean couldReloadSource() {
        return false;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getId() {
        return !StringUtils.isNullOrEmpty(this.id) ? this.id : this.fileName;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public long getSize() {
        long j = this.size;
        if (j > -1) {
            return j;
        }
        return -1L;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getSourceType() {
        return this.hasSize ? "Stream:HasSize" : "Stream:NoSize";
    }

    @Override // com.qiniu.android.storage.UploadSource
    public byte[] readData(int i, long j) throws IOException {
        byte[] bArr;
        boolean z;
        if (this.inputStream == null) {
            throw new IOException("inputStream is empty");
        }
        synchronized (this) {
            while (true) {
                long j2 = this.readOffset;
                if (j2 == j) {
                    bArr = new byte[i];
                    int i2 = 0;
                    while (true) {
                        if (i2 >= i) {
                            z = false;
                            break;
                        }
                        int i3 = this.inputStream.read(bArr, i2, i - i2);
                        if (i3 < 0) {
                            z = true;
                            break;
                        }
                        i2 += i3;
                    }
                    if (i2 < i) {
                        byte[] bArr2 = new byte[i2];
                        System.arraycopy(bArr, 0, bArr2, 0, i2);
                        bArr = bArr2;
                    }
                    long j3 = this.readOffset + ((long) i2);
                    this.readOffset = j3;
                    if (z) {
                        this.size = j3;
                    }
                } else {
                    if (j2 >= j) {
                        throw new IOException("read stream data error");
                    }
                    this.readOffset = j2 + this.inputStream.skip(j - j2);
                }
            }
        }
        return bArr;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean reloadSource() {
        this.readOffset = 0L;
        return false;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setSize(long j) {
        this.hasSize = j > 0;
        this.size = j;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public void close() {
    }
}
