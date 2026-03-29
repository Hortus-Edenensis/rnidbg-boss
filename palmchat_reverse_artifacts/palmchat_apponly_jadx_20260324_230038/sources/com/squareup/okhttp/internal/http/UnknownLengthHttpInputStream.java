package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class UnknownLengthHttpInputStream extends AbstractHttpInputStream {
    private boolean inputExhausted;

    public UnknownLengthHttpInputStream(InputStream inputStream, CacheRequest cacheRequest, HttpEngine httpEngine) throws IOException {
        super(inputStream, httpEngine, cacheRequest);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        checkNotClosed();
        InputStream inputStream = this.in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        if (this.inputExhausted) {
            return;
        }
        unexpectedEndOfInput();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Util.checkOffsetAndCount(bArr.length, i, i2);
        checkNotClosed();
        InputStream inputStream = this.in;
        if (inputStream == null || this.inputExhausted) {
            return -1;
        }
        int i3 = inputStream.read(bArr, i, i2);
        if (i3 != -1) {
            cacheWrite(bArr, i, i3);
            return i3;
        }
        this.inputExhausted = true;
        endOfInput();
        return -1;
    }
}
