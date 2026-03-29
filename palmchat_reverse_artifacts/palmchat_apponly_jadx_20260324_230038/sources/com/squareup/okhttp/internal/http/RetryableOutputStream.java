package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.AbstractOutputStream;
import com.squareup.okhttp.internal.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class RetryableOutputStream extends AbstractOutputStream {
    private final ByteArrayOutputStream content;
    private final int limit;

    public RetryableOutputStream(int i) {
        this.limit = i;
        this.content = new ByteArrayOutputStream(i);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        if (this.content.size() >= this.limit) {
            return;
        }
        throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.size());
    }

    public synchronized int contentLength() throws IOException {
        close();
        return this.content.size();
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        Util.checkOffsetAndCount(bArr.length, i, i2);
        if (this.limit != -1 && this.content.size() > this.limit - i2) {
            throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
        }
        this.content.write(bArr, i, i2);
    }

    public void writeToSocket(OutputStream outputStream) throws IOException {
        this.content.writeTo(outputStream);
    }

    public RetryableOutputStream() {
        this.limit = -1;
        this.content = new ByteArrayOutputStream();
    }
}
