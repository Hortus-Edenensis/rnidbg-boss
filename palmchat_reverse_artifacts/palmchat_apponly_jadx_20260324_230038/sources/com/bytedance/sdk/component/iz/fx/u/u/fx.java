package com.bytedance.sdk.component.iz.fx.u.u;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class fx implements Closeable {
    private int b;
    private byte[] fx;
    private final Charset nr;
    private int pn;
    private final InputStream u;

    public fx(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void fx() throws IOException {
        InputStream inputStream = this.u;
        byte[] bArr = this.fx;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.b = 0;
        this.pn = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.u) {
            if (this.fx != null) {
                this.fx = null;
                this.u.close();
            }
        }
    }

    public boolean nr() {
        return this.pn == -1;
    }

    public fx(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(b.u)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.u = inputStream;
        this.nr = charset;
        this.fx = new byte[i];
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String u() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.u) {
            if (this.fx == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.b >= this.pn) {
                fx();
            }
            for (int i3 = this.b; i3 != this.pn; i3++) {
                byte[] bArr2 = this.fx;
                if (bArr2[i3] == 10) {
                    int i4 = this.b;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.nr.name());
                    this.b = i3 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.pn - this.b) + 80) { // from class: com.bytedance.sdk.component.iz.fx.u.u.fx.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    int i5 = ((ByteArrayOutputStream) this).count;
                    if (i5 > 0 && ((ByteArrayOutputStream) this).buf[i5 - 1] == 13) {
                        i5--;
                    }
                    try {
                        return new String(((ByteArrayOutputStream) this).buf, 0, i5, fx.this.nr.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr3 = this.fx;
                int i5 = this.b;
                byteArrayOutputStream.write(bArr3, i5, this.pn - i5);
                this.pn = -1;
                fx();
                i = this.b;
                while (i != this.pn) {
                    bArr = this.fx;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.b;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.b = i + 1;
            return byteArrayOutputStream.toString();
        }
    }
}
