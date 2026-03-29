package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractHttpInputStream extends InputStream {
    private final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    protected boolean closed;
    protected final HttpEngine httpEngine;
    protected final InputStream in;

    public AbstractHttpInputStream(InputStream inputStream, HttpEngine httpEngine, CacheRequest cacheRequest) throws IOException {
        this.in = inputStream;
        this.httpEngine = httpEngine;
        OutputStream body = cacheRequest != null ? cacheRequest.getBody() : null;
        cacheRequest = body == null ? null : cacheRequest;
        this.cacheBody = body;
        this.cacheRequest = cacheRequest;
    }

    public final void cacheWrite(byte[] bArr, int i, int i2) throws IOException {
        OutputStream outputStream = this.cacheBody;
        if (outputStream != null) {
            outputStream.write(bArr, i, i2);
        }
    }

    public final void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("stream closed");
        }
    }

    public final void endOfInput() throws IOException {
        if (this.cacheRequest != null) {
            this.cacheBody.close();
        }
        this.httpEngine.release(false);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return Util.readSingleByte(this);
    }

    public final void unexpectedEndOfInput() {
        CacheRequest cacheRequest = this.cacheRequest;
        if (cacheRequest != null) {
            cacheRequest.abort();
        }
        this.httpEngine.release(true);
    }
}
