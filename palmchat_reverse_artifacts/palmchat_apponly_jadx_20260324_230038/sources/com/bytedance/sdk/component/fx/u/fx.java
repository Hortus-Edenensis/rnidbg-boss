package com.bytedance.sdk.component.fx.u;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.exoplayer.MediaPeriodQueue;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx implements b, pn, Cloneable, ByteChannel {
    private static final byte[] fx = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long nr;
    k u;

    @Override // com.bytedance.sdk.component.fx.u.sx
    public void a_(fx fxVar, long j) {
        k kVar;
        if (fxVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (fxVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        dw.u(fxVar.nr, 0L, j);
        while (j > 0 && (kVar = fxVar.u) != null) {
            if (j < kVar.fx - kVar.nr) {
                k kVar2 = this.u;
                k kVar3 = kVar2 != null ? kVar2.x : null;
                if (kVar3 != null && kVar3.pn) {
                    if ((((long) kVar3.fx) + j) - ((long) (kVar3.b ? 0 : kVar3.nr)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        kVar.u(kVar3, (int) j);
                        fxVar.nr -= j;
                        this.nr += j;
                        return;
                    }
                }
                fxVar.u = kVar.u((int) j);
            }
            k kVar4 = fxVar.u;
            long j2 = kVar4.fx - kVar4.nr;
            fxVar.u = kVar4.nr();
            k kVar5 = this.u;
            if (kVar5 == null) {
                this.u = kVar4;
                kVar4.x = kVar4;
                kVar4.iz = kVar4;
            } else {
                kVar5.x.u(kVar4).fx();
            }
            fxVar.nr -= j2;
            this.nr += j2;
            j -= j2;
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public fx dw() {
        return this;
    }

    /* JADX INFO: renamed from: bg, reason: merged with bridge method [inline-methods] */
    public fx clone() {
        fx fxVar = new fx();
        if (this.nr == 0) {
            return fxVar;
        }
        k kVarU = this.u.u();
        fxVar.u = kVarU;
        kVarU.x = kVarU;
        kVarU.iz = kVarU;
        k kVar = this.u;
        while (true) {
            kVar = kVar.iz;
            if (kVar == this.u) {
                fxVar.nr = this.nr;
                return fxVar;
            }
            fxVar.u.x.u(kVar.u());
        }
    }

    public final iz bq() {
        long j = this.nr;
        if (j <= 2147483647L) {
            return iz((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.nr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fx)) {
            return false;
        }
        fx fxVar = (fx) obj;
        long j = this.nr;
        if (j != fxVar.nr) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        k kVar = this.u;
        k kVar2 = fxVar.u;
        int i = kVar.nr;
        int i2 = kVar2.nr;
        while (j2 < this.nr) {
            long jMin = Math.min(kVar.fx - i, kVar2.fx - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (kVar.u[i] != kVar2.u[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == kVar.fx) {
                kVar = kVar.iz;
                i = kVar.nr;
            }
            if (i2 == kVar2.fx) {
                kVar2 = kVar2.iz;
                i2 = kVar2.nr;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.fx.u.b, com.bytedance.sdk.component.fx.u.pn
    public fx fx() {
        return this;
    }

    public int hashCode() {
        k kVar = this.u;
        if (kVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = kVar.fx;
            for (int i3 = kVar.nr; i3 < i2; i3++) {
                i = (i * 31) + kVar.u[i3];
            }
            kVar = kVar.iz;
        } while (kVar != this.u);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public InputStream iz() {
        return new InputStream() { // from class: com.bytedance.sdk.component.fx.u.fx.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(fx.this.nr, 2147483647L);
            }

            @Override // java.io.InputStream
            public int read() {
                fx fxVar = fx.this;
                if (fxVar.nr > 0) {
                    return fxVar.n() & UByte.MAX_VALUE;
                }
                return -1;
            }

            public String toString() {
                return fx.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return fx.this.u(bArr, i, i2);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public int jk() {
        long j = this.nr;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.nr);
        }
        k kVar = this.u;
        int i = kVar.nr;
        int i2 = kVar.fx;
        if (i2 - i < 4) {
            return ((n() & UByte.MAX_VALUE) << 24) | ((n() & UByte.MAX_VALUE) << 16) | ((n() & UByte.MAX_VALUE) << 8) | (n() & UByte.MAX_VALUE);
        }
        byte[] bArr = kVar.u;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        this.nr = j - 4;
        if (i8 == i2) {
            this.u = kVar.nr();
            my.u(kVar);
        } else {
            kVar.nr = i8;
        }
        return i9;
    }

    public String k() {
        try {
            return u(this.nr, dw.u);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009f A[EDGE_INSN: B:44:0x009f->B:38:0x009f BREAK  A[LOOP:0: B:5:0x000b->B:46:?], SYNTHETIC] */
    @Override // com.bytedance.sdk.component.fx.u.pn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mv() {
        int i;
        int i2;
        if (this.nr == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        long j = 0;
        boolean z = false;
        do {
            k kVar = this.u;
            byte[] bArr = kVar.u;
            int i4 = kVar.nr;
            int i5 = kVar.fx;
            while (i4 < i5) {
                byte b = bArr[i4];
                if (b < 48 || b > 57) {
                    if (b >= 97 && b <= 102) {
                        i = b - 97;
                    } else if (b >= 65 && b <= 70) {
                        i = b - 65;
                    } else {
                        if (i3 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                        }
                        z = true;
                        if (i4 != i5) {
                            this.u = kVar.nr();
                            my.u(kVar);
                        } else {
                            kVar.nr = i4;
                        }
                        if (!z) {
                            break;
                        }
                    }
                    i2 = i + 10;
                } else {
                    i2 = b - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new fx().t(j).a((int) b).k());
                }
                j = (j << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 != i5) {
            }
            if (!z) {
            }
        } while (this.u != null);
        this.nr -= (long) i3;
        return j;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public String my() throws EOFException {
        return pn(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public byte[] o() throws EOFException {
        return x(this.nr);
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public boolean pn() {
        return this.nr == 0;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        k kVar = this.u;
        if (kVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), kVar.fx - kVar.nr);
        byteBuffer.put(kVar.u, kVar.nr, iMin);
        int i = kVar.nr + iMin;
        kVar.nr = i;
        this.nr -= (long) iMin;
        if (i == kVar.fx) {
            this.u = kVar.nr();
            my.u(kVar);
        }
        return iMin;
    }

    public iz s() throws EOFException {
        return new iz(o());
    }

    public final void sx() {
        try {
            n(this.nr);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String toString() {
        return bq().toString();
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public void u(long j) throws EOFException {
        if (this.nr < j) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            k kVarPn = pn(1);
            int iMin = Math.min(i, 8192 - kVarPn.fx);
            byteBuffer.get(kVarPn.u, kVarPn.fx, iMin);
            i -= iMin;
            kVarPn.fx += iMin;
        }
        this.nr += (long) iRemaining;
        return iRemaining;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public short a() {
        long j = this.nr;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.nr);
        }
        k kVar = this.u;
        int i = kVar.nr;
        int i2 = kVar.fx;
        if (i2 - i < 2) {
            return (short) (((n() & UByte.MAX_VALUE) << 8) | (n() & UByte.MAX_VALUE));
        }
        byte[] bArr = kVar.u;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
        this.nr = j - 2;
        if (i4 == i2) {
            this.u = kVar.nr();
            my.u(kVar);
        } else {
            kVar.nr = i4;
        }
        return (short) i5;
    }

    public String b(long j) throws EOFException {
        return u(j, dw.u);
    }

    public String iz(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (nr(j2) == 13) {
                String strB = b(j2);
                n(2L);
                return strB;
            }
        }
        String strB2 = b(j);
        n(1L);
        return strB2;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public int l() {
        return dw.u(jk());
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public byte n() {
        long j = this.nr;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        k kVar = this.u;
        int i = kVar.nr;
        int i2 = kVar.fx;
        int i3 = i + 1;
        byte b = kVar.u[i];
        this.nr = j - 1;
        if (i3 == i2) {
            this.u = kVar.nr();
            my.u(kVar);
        } else {
            kVar.nr = i3;
        }
        return b;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public String pn(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jU = u((byte) 10, 0L, j2);
        if (jU != -1) {
            return iz(jU);
        }
        if (j2 < nr() && nr(j2 - 1) == 13 && nr(j2) == 10) {
            return iz(j2);
        }
        fx fxVar = new fx();
        u(fxVar, 0L, Math.min(32L, nr()));
        throw new EOFException("\\n not found: limit=" + Math.min(nr(), j) + " content=" + fxVar.s().pn() + Typography.ellipsis);
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public short t() {
        return dw.u(a());
    }

    public final fx u(fx fxVar, long j, long j2) {
        if (fxVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        dw.u(this.nr, j, j2);
        if (j2 == 0) {
            return this;
        }
        fxVar.nr += j2;
        k kVar = this.u;
        while (true) {
            int i = kVar.fx;
            int i2 = kVar.nr;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            kVar = kVar.iz;
        }
        while (j2 > 0) {
            k kVarU = kVar.u();
            int i3 = (int) (((long) kVarU.nr) + j);
            kVarU.nr = i3;
            kVarU.fx = Math.min(i3 + ((int) j2), kVarU.fx);
            k kVar2 = fxVar.u;
            if (kVar2 == null) {
                kVarU.x = kVarU;
                kVarU.iz = kVarU;
                fxVar.u = kVarU;
            } else {
                kVar2.x.u(kVarU);
            }
            j2 -= (long) (kVarU.fx - kVarU.nr);
            kVar = kVar.iz;
            j = 0;
        }
        return this;
    }

    public final long x() {
        long j = this.nr;
        if (j == 0) {
            return 0L;
        }
        k kVar = this.u.x;
        int i = kVar.fx;
        return (i >= 8192 || !kVar.pn) ? j : j - ((long) (i - kVar.nr));
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public fx x(int i) {
        k kVarPn = pn(4);
        byte[] bArr = kVarPn.u;
        int i2 = kVarPn.fx;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        kVarPn.fx = i5 + 1;
        this.nr += 4;
        return this;
    }

    public final long nr() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public iz fx(long j) throws EOFException {
        return new iz(x(j));
    }

    public final byte nr(long j) {
        int i;
        dw.u(this.nr, j, 1L);
        long j2 = this.nr;
        if (j2 - j > j) {
            k kVar = this.u;
            while (true) {
                int i2 = kVar.fx;
                int i3 = kVar.nr;
                long j3 = i2 - i3;
                if (j < j3) {
                    return kVar.u[i3 + ((int) j)];
                }
                j -= j3;
                kVar = kVar.iz;
            }
        } else {
            long j4 = j - j2;
            try {
                k kVar2 = this.u;
                do {
                    kVar2 = kVar2.x;
                    int i4 = kVar2.fx;
                    i = kVar2.nr;
                    j4 += (long) (i4 - i);
                } while (j4 < 0);
                return kVar2.u[i + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
    public fx n(int i) {
        k kVarPn = pn(2);
        byte[] bArr = kVarPn.u;
        int i2 = kVarPn.fx;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        kVarPn.fx = i3 + 1;
        this.nr += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public byte[] x(long j) throws EOFException {
        dw.u(this.nr, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            u(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final iz iz(int i) {
        if (i == 0) {
            return iz.nr;
        }
        return new o(this, i);
    }

    public k pn(int i) {
        if (i > 0 && i <= 8192) {
            k kVar = this.u;
            if (kVar == null) {
                k kVarU = my.u();
                this.u = kVarU;
                kVarU.x = kVarU;
                kVarU.iz = kVarU;
                return kVarU;
            }
            k kVar2 = kVar.x;
            return (kVar2.fx + i > 8192 || !kVar2.pn) ? kVar2.u(my.u()) : kVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public void n(long j) throws EOFException {
        k kVar;
        while (j > 0 && (kVar = this.u) != null) {
            int iMin = (int) Math.min(j, kVar.fx - kVar.nr);
            long j2 = iMin;
            this.nr -= j2;
            j -= j2;
            k kVar2 = this.u;
            int i = kVar2.nr + iMin;
            kVar2.nr = i;
            if (i == kVar2.fx) {
                this.u = kVar2.nr();
                my.u(kVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public fx fx(byte[] bArr) {
        if (bArr != null) {
            return fx(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fx l(long j) {
        boolean z;
        if (j == 0) {
            return a(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return nr("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        k kVarPn = pn(i);
        byte[] bArr = kVarPn.u;
        int i2 = kVarPn.fx + i;
        while (j != 0) {
            i2--;
            bArr[i2] = fx[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        kVarPn.fx += i;
        this.nr += (long) i;
        return this;
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public fx fx(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            dw.u(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                k kVarPn = pn(1);
                int iMin = Math.min(i3 - i, 8192 - kVarPn.fx);
                System.arraycopy(bArr, i, kVarPn.u, kVarPn.fx, iMin);
                i += iMin;
                kVarPn.fx += iMin;
            }
            this.nr += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public String u(Charset charset) {
        try {
            return u(this.nr, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: jk, reason: merged with bridge method [inline-methods] */
    public fx t(long j) {
        if (j == 0) {
            return a(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        k kVarPn = pn(iNumberOfTrailingZeros);
        byte[] bArr = kVarPn.u;
        int i = kVarPn.fx;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = fx[(int) (15 & j)];
            j >>>= 4;
        }
        kVarPn.fx += iNumberOfTrailingZeros;
        this.nr += (long) iNumberOfTrailingZeros;
        return this;
    }

    public String u(long j, Charset charset) throws EOFException {
        dw.u(this.nr, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        k kVar = this.u;
        int i = kVar.nr;
        if (((long) i) + j > kVar.fx) {
            return new String(x(j), charset);
        }
        String str = new String(kVar.u, i, (int) j, charset);
        int i2 = (int) (((long) kVar.nr) + j);
        kVar.nr = i2;
        this.nr -= j;
        if (i2 == kVar.fx) {
            this.u = kVar.nr();
            my.u(kVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.component.fx.u.b, com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
    public void flush() {
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public fx a(int i) {
        k kVarPn = pn(1);
        byte[] bArr = kVarPn.u;
        int i2 = kVarPn.fx;
        kVarPn.fx = i2 + 1;
        bArr[i2] = (byte) i;
        this.nr++;
        return this;
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public void u(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iU = u(bArr, i, bArr.length - i);
            if (iU == -1) {
                throw new EOFException();
            }
            i += iU;
        }
    }

    public int u(byte[] bArr, int i, int i2) {
        dw.u(bArr.length, i, i2);
        k kVar = this.u;
        if (kVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, kVar.fx - kVar.nr);
        System.arraycopy(kVar.u, kVar.nr, bArr, i, iMin);
        int i3 = kVar.nr + iMin;
        kVar.nr = i3;
        this.nr -= (long) iMin;
        if (i3 == kVar.fx) {
            this.u = kVar.nr();
            my.u(kVar);
        }
        return iMin;
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public fx nr(iz izVar) {
        if (izVar != null) {
            izVar.u(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public fx nr(String str) {
        return u(str, 0, str.length());
    }

    public fx u(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 128) {
                    k kVarPn = pn(1);
                    byte[] bArr = kVarPn.u;
                    int i3 = kVarPn.fx - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt2;
                    while (true) {
                        i = i4;
                        if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) cCharAt;
                    }
                    int i5 = kVarPn.fx;
                    int i6 = (i3 + i) - i5;
                    kVarPn.fx = i5 + i6;
                    this.nr += (long) i6;
                } else {
                    if (cCharAt2 < 2048) {
                        a((cCharAt2 >> 6) | 192);
                        a((cCharAt2 & '?') | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            a((i8 >> 18) | 240);
                            a(((i8 >> 12) & 63) | 128);
                            a(((i8 >> 6) & 63) | 128);
                            a((i8 & 63) | 128);
                            i += 2;
                        } else {
                            a(63);
                            i = i7;
                        }
                    } else {
                        a((cCharAt2 >> '\f') | 224);
                        a(((cCharAt2 >> 6) & 63) | 128);
                        a((cCharAt2 & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public fx u(int i) {
        if (i < 128) {
            a(i);
        } else if (i < 2048) {
            a((i >> 6) | 192);
            a((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                a(63);
            } else {
                a((i >> 12) | 224);
                a(((i >> 6) & 63) | 128);
                a((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            a((i >> 18) | 240);
            a(((i >> 12) & 63) | 128);
            a(((i >> 6) & 63) | 128);
            a((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public fx u(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(dw.u)) {
                    return u(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return fx(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public long u(bg bgVar) throws IOException {
        if (bgVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jU = bgVar.u(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (jU == -1) {
                return j;
            }
            j += jU;
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.bg
    public long u(fx fxVar, long j) {
        if (fxVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.nr;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            fxVar.a_(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public long u(byte b) {
        return u(b, 0L, Long.MAX_VALUE);
    }

    public long u(byte b, long j, long j2) {
        k kVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.nr;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (kVar = this.u) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    kVar = kVar.x;
                    j4 -= (long) (kVar.fx - kVar.nr);
                }
            } else {
                while (true) {
                    long j6 = ((long) (kVar.fx - kVar.nr)) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    kVar = kVar.iz;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = kVar.u;
                int iMin = (int) Math.min(kVar.fx, (((long) kVar.nr) + j5) - j4);
                for (int i = (int) ((((long) kVar.nr) + j7) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - kVar.nr)) + j4;
                    }
                }
                j4 += (long) (kVar.fx - kVar.nr);
                kVar = kVar.iz;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.nr), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // com.bytedance.sdk.component.fx.u.pn
    public boolean u(long j, iz izVar) {
        return u(j, izVar, 0, izVar.x());
    }

    public boolean u(long j, iz izVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.nr - j < i2 || izVar.x() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (nr(((long) i3) + j) != izVar.u(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.fx.u.sx
    public bq u() {
        return bq.fx;
    }
}
