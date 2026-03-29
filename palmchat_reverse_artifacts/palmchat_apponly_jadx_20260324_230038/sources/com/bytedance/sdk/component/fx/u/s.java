package com.bytedance.sdk.component.fx.u;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class s implements pn {
    boolean fx;
    public final bg nr;
    public final fx u = new fx();

    public s(bg bgVar) {
        if (bgVar == null) {
            throw new NullPointerException("source == null");
        }
        this.nr = bgVar;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public short a() throws IOException {
        u(2L);
        return this.u.a();
    }

    @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.fx) {
            return;
        }
        this.fx = true;
        this.nr.close();
        this.u.sx();
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public fx fx() {
        return this.u;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.fx;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public InputStream iz() {
        return new InputStream() { // from class: com.bytedance.sdk.component.fx.u.s.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                s sVar = s.this;
                if (sVar.fx) {
                    throw new IOException("closed");
                }
                return (int) Math.min(sVar.u.nr, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                s.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                s sVar = s.this;
                if (sVar.fx) {
                    throw new IOException("closed");
                }
                fx fxVar = sVar.u;
                if (fxVar.nr == 0 && sVar.nr.u(fxVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return s.this.u.n() & UByte.MAX_VALUE;
            }

            public String toString() {
                return s.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!s.this.fx) {
                    dw.u(bArr.length, i, i2);
                    s sVar = s.this;
                    fx fxVar = sVar.u;
                    if (fxVar.nr == 0 && sVar.nr.u(fxVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        return -1;
                    }
                    return s.this.u.u(bArr, i, i2);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public int jk() throws IOException {
        u(4L);
        return this.u.jk();
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public int l() throws IOException {
        u(4L);
        return this.u.l();
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public long mv() throws IOException {
        byte bNr;
        u(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!nr(i2)) {
                break;
            }
            bNr = this.u.nr(i);
            if ((bNr < 48 || bNr > 57) && ((bNr < 97 || bNr > 102) && (bNr < 65 || bNr > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bNr)));
        }
        return this.u.mv();
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public String my() throws IOException {
        return pn(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public byte n() throws IOException {
        u(1L);
        return this.u.n();
    }

    public boolean nr(long j) throws IOException {
        fx fxVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        do {
            fxVar = this.u;
            if (fxVar.nr >= j) {
                return true;
            }
        } while (this.nr.u(fxVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public byte[] o() throws IOException {
        this.u.u(this.nr);
        return this.u.o();
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public boolean pn() throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        return this.u.pn() && this.nr.u(this.u, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        fx fxVar = this.u;
        if (fxVar.nr == 0 && this.nr.u(fxVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.u.read(byteBuffer);
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public short t() throws IOException {
        u(2L);
        return this.u.t();
    }

    public String toString() {
        return "buffer(" + this.nr + ")";
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public long u(fx fxVar, long j) throws IOException {
        if (fxVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        fx fxVar2 = this.u;
        if (fxVar2.nr == 0 && this.nr.u(fxVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.u.u(fxVar, Math.min(j, this.u.nr));
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public byte[] x(long j) throws IOException {
        u(j);
        return this.u.x(j);
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public iz fx(long j) throws IOException {
        u(j);
        return this.u.fx(j);
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public void n(long j) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            fx fxVar = this.u;
            if (fxVar.nr == 0 && this.nr.u(fxVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.u.nr());
            this.u.n(jMin);
            j -= jMin;
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public String pn(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long jU = u((byte) 10, 0L, j2);
            if (jU != -1) {
                return this.u.iz(jU);
            }
            if (j2 < Long.MAX_VALUE && nr(j2) && this.u.nr(j2 - 1) == 13 && nr(1 + j2) && this.u.nr(j2) == 10) {
                return this.u.iz(j2);
            }
            fx fxVar = new fx();
            fx fxVar2 = this.u;
            fxVar2.u(fxVar, 0L, Math.min(32L, fxVar2.nr()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.u.nr(), j) + " content=" + fxVar.s().pn() + Typography.ellipsis);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public void u(long j) throws IOException {
        if (!nr(j)) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public void u(byte[] bArr) throws IOException {
        try {
            u(bArr.length);
            this.u.u(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                fx fxVar = this.u;
                long j = fxVar.nr;
                if (j > 0) {
                    int iU = fxVar.u(bArr, i, (int) j);
                    if (iU == -1) {
                        throw new AssertionError();
                    }
                    i += iU;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public String u(Charset charset) throws IOException {
        if (charset != null) {
            this.u.u(this.nr);
            return this.u.u(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public long u(byte b) throws IOException {
        return u(b, 0L, Long.MAX_VALUE);
    }

    public long u(byte b, long j, long j2) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jU = this.u.u(b, j, j2);
            if (jU != -1) {
                return jU;
            }
            fx fxVar = this.u;
            long j3 = fxVar.nr;
            if (j3 >= j2 || this.nr.u(fxVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public boolean u(long j, iz izVar) throws IOException {
        return u(j, izVar, 0, izVar.x());
    }

    public boolean u(long j, iz izVar, int i, int i2) throws IOException {
        if (!this.fx) {
            if (j < 0 || i < 0 || i2 < 0 || izVar.x() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!nr(1 + j2) || this.u.nr(j2) != izVar.u(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public bq u() {
        return this.nr.u();
    }
}
