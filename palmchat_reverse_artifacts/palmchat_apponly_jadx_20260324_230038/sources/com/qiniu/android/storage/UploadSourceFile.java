package com.qiniu.android.storage;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UploadSourceFile extends UploadSource {
    private final File file;
    private final RandomAccessFile randomAccessFile;
    private Exception readException;

    public UploadSourceFile(File file) {
        RandomAccessFile randomAccessFile = null;
        this.readException = null;
        this.file = file;
        try {
            randomAccessFile = new RandomAccessFile(file, t.k);
        } catch (Exception e) {
            this.readException = e;
        }
        this.randomAccessFile = randomAccessFile;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public void close() {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                    this.randomAccessFile.close();
                }
            } catch (IOException unused2) {
            }
        }
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean couldReloadSource() {
        return this.randomAccessFile != null;
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getFileName() {
        return this.file.getName();
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getId() {
        return getFileName() + "_" + this.file.lastModified();
    }

    @Override // com.qiniu.android.storage.UploadSource
    public long getSize() {
        return this.file.length();
    }

    @Override // com.qiniu.android.storage.UploadSource
    public String getSourceType() {
        return "File";
    }

    @Override // com.qiniu.android.storage.UploadSource
    public byte[] readData(int i, long j) throws IOException {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile == null) {
            if (this.readException != null) {
                throw new IOException(this.readException);
            }
            throw new IOException("file is invalid");
        }
        byte[] bArr = new byte[i];
        try {
            randomAccessFile.seek(j);
            int i2 = 0;
            while (i2 < i) {
                int i3 = this.randomAccessFile.read(bArr, i2, i - i2);
                if (i3 < 0) {
                    break;
                }
                i2 += i3;
            }
            if (i2 >= i) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.qiniu.android.storage.UploadSource
    public boolean reloadSource() {
        return true;
    }
}
