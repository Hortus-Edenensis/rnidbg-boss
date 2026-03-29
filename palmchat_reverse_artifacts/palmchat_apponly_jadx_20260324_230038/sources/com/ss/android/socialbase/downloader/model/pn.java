package com.ss.android.socialbase.downloader.model;

import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.jk.iz;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn implements Closeable {
    private RandomAccessFile fx;
    private FileDescriptor nr;
    private BufferedOutputStream u;

    public pn(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.fx = randomAccessFile;
            this.nr = randomAccessFile.getFD();
            if (i <= 0) {
                this.u = new BufferedOutputStream(new FileOutputStream(this.fx.getFD()));
                return;
            }
            if (i < 8192) {
                i = 8192;
            } else if (i > 131072) {
                i = 131072;
            }
            this.u = new BufferedOutputStream(new FileOutputStream(this.fx.getFD()), i);
        } catch (IOException e) {
            throw new BaseException(FunDC.ID_AUTH_1039, e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        iz.u(this.fx, this.u);
    }

    public void fx() throws IOException {
        FileDescriptor fileDescriptor = this.nr;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void nr() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.u;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void u(byte[] bArr, int i, int i2) throws IOException {
        this.u.write(bArr, i, i2);
    }

    public void u() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.u;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.nr;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void nr(long j) throws IOException {
        this.fx.setLength(j);
    }

    public void u(long j) throws IOException {
        this.fx.seek(j);
    }
}
