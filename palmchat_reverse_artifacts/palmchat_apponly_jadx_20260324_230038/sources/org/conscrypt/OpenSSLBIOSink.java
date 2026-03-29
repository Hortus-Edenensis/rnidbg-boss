package org.conscrypt;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
final class OpenSSLBIOSink {
    private final ByteArrayOutputStream buffer;
    private final long ctx;
    private int position;

    private OpenSSLBIOSink(ByteArrayOutputStream byteArrayOutputStream) {
        this.ctx = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        this.buffer = byteArrayOutputStream;
    }

    public static OpenSSLBIOSink create() {
        return new OpenSSLBIOSink(new ByteArrayOutputStream());
    }

    public int available() {
        return this.buffer.size() - this.position;
    }

    public void finalize() throws Throwable {
        try {
            NativeCrypto.BIO_free_all(this.ctx);
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.ctx;
    }

    public int position() {
        return this.position;
    }

    public void reset() {
        this.buffer.reset();
        this.position = 0;
    }

    public long skip(long j) {
        int iMin = Math.min(available(), (int) j);
        int i = this.position + iMin;
        this.position = i;
        if (i == this.buffer.size()) {
            reset();
        }
        return iMin;
    }

    public byte[] toByteArray() {
        return this.buffer.toByteArray();
    }
}
