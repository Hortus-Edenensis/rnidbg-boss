package com.bytedance.sdk.component.nr.u.nr;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements fx, nr, Cloneable, ByteChannel {
    private static final byte[] fx = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long nr;
    iz u;

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u clone() {
        u uVar = new u();
        if (this.nr == 0) {
            return uVar;
        }
        iz izVarU = this.u.u();
        uVar.u = izVarU;
        izVarU.x = izVarU;
        izVarU.iz = izVarU;
        iz izVar = this.u;
        while (true) {
            izVar = izVar.iz;
            if (izVar == this.u) {
                uVar.nr = this.nr;
                return uVar;
            }
            uVar.u.x.u(izVar.u());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        long j = this.nr;
        if (j != uVar.nr) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        iz izVar = this.u;
        iz izVar2 = uVar.u;
        int i = izVar.nr;
        int i2 = izVar2.nr;
        while (j2 < this.nr) {
            long jMin = Math.min(izVar.fx - i, izVar2.fx - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (izVar.u[i] != izVar2.u[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == izVar.fx) {
                izVar = izVar.iz;
                i = izVar.nr;
            }
            if (i2 == izVar2.fx) {
                izVar2 = izVar2.iz;
                i2 = izVar2.nr;
            }
            j2 += jMin;
        }
        return true;
    }

    public String fx() {
        try {
            return u(this.nr, jk.u);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        iz izVar = this.u;
        if (izVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = izVar.fx;
            for (int i3 = izVar.nr; i3 < i2; i3++) {
                i = (i * 31) + izVar.u[i3];
            }
            izVar = izVar.iz;
        } while (izVar != this.u);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public byte nr() {
        long j = this.nr;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        iz izVar = this.u;
        int i = izVar.nr;
        int i2 = izVar.fx;
        int i3 = i + 1;
        byte b = izVar.u[i];
        this.nr = j - 1;
        if (i3 == i2) {
            this.u = izVar.nr();
            x.u(izVar);
        } else {
            izVar.nr = i3;
        }
        return b;
    }

    public final b pn() {
        long j = this.nr;
        if (j <= 2147483647L) {
            return b((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.nr);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        iz izVar = this.u;
        if (izVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), izVar.fx - izVar.nr);
        byteBuffer.put(izVar.u, izVar.nr, iMin);
        int i = izVar.nr + iMin;
        izVar.nr = i;
        this.nr -= (long) iMin;
        if (i == izVar.fx) {
            this.u = izVar.nr();
            x.u(izVar);
        }
        return iMin;
    }

    public String toString() {
        return pn().toString();
    }

    public boolean u() {
        return this.nr == 0;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            iz izVarFx = fx(1);
            int iMin = Math.min(i, 8192 - izVarFx.fx);
            byteBuffer.get(izVarFx.u, izVarFx.fx, iMin);
            i -= iMin;
            izVarFx.fx += iMin;
        }
        this.nr += (long) iRemaining;
        return iRemaining;
    }

    public String u(long j, Charset charset) throws EOFException {
        jk.u(this.nr, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        iz izVar = this.u;
        int i = izVar.nr;
        if (((long) i) + j > izVar.fx) {
            return new String(u(j), charset);
        }
        String str = new String(izVar.u, i, (int) j, charset);
        int i2 = (int) (((long) izVar.nr) + j);
        izVar.nr = i2;
        this.nr -= j;
        if (i2 == izVar.fx) {
            this.u = izVar.nr();
            x.u(izVar);
        }
        return str;
    }

    public iz fx(int i) {
        if (i > 0 && i <= 8192) {
            iz izVar = this.u;
            if (izVar == null) {
                iz izVarU = x.u();
                this.u = izVarU;
                izVarU.x = izVarU;
                izVarU.iz = izVarU;
                return izVarU;
            }
            iz izVar2 = izVar.x;
            return (izVar2.fx + i > 8192 || !izVar2.pn) ? izVar2.u(x.u()) : izVar2;
        }
        throw new IllegalArgumentException();
    }

    public final b b(int i) {
        if (i == 0) {
            return b.fx;
        }
        return new n(this, i);
    }

    public u nr(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            jk.u(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                iz izVarFx = fx(1);
                int iMin = Math.min(i3 - i, 8192 - izVarFx.fx);
                System.arraycopy(bArr, i, izVarFx.u, izVarFx.fx, iMin);
                i += iMin;
                izVarFx.fx += iMin;
            }
            this.nr += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] u(long j) throws EOFException {
        jk.u(this.nr, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            u(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

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

    public u nr(int i) {
        iz izVarFx = fx(1);
        byte[] bArr = izVarFx.u;
        int i2 = izVarFx.fx;
        izVarFx.fx = i2 + 1;
        bArr[i2] = (byte) i;
        this.nr++;
        return this;
    }

    public int u(byte[] bArr, int i, int i2) {
        jk.u(bArr.length, i, i2);
        iz izVar = this.u;
        if (izVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, izVar.fx - izVar.nr);
        System.arraycopy(izVar.u, izVar.nr, bArr, i, iMin);
        int i3 = izVar.nr + iMin;
        izVar.nr = i3;
        this.nr -= (long) iMin;
        if (i3 == izVar.fx) {
            this.u = izVar.nr();
            x.u(izVar);
        }
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public u nr(long j) {
        if (j == 0) {
            return nr(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        iz izVarFx = fx(iNumberOfTrailingZeros);
        byte[] bArr = izVarFx.u;
        int i = izVarFx.fx;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = fx[(int) (15 & j)];
            j >>>= 4;
        }
        izVarFx.fx += iNumberOfTrailingZeros;
        this.nr += (long) iNumberOfTrailingZeros;
        return this;
    }

    public u u(String str) {
        return u(str, 0, str.length());
    }

    public u u(String str, int i, int i2) {
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
                    iz izVarFx = fx(1);
                    byte[] bArr = izVarFx.u;
                    int i3 = izVarFx.fx - i;
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
                    int i5 = izVarFx.fx;
                    int i6 = (i3 + i) - i5;
                    izVarFx.fx = i5 + i6;
                    this.nr += (long) i6;
                } else {
                    if (cCharAt2 < 2048) {
                        nr((cCharAt2 >> 6) | 192);
                        nr((cCharAt2 & '?') | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            nr((i8 >> 18) | 240);
                            nr(((i8 >> 12) & 63) | 128);
                            nr(((i8 >> 6) & 63) | 128);
                            nr((i8 & 63) | 128);
                            i += 2;
                        } else {
                            nr(63);
                            i = i7;
                        }
                    } else {
                        nr((cCharAt2 >> '\f') | 224);
                        nr(((cCharAt2 >> 6) & 63) | 128);
                        nr((cCharAt2 & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public u u(int i) {
        if (i < 128) {
            nr(i);
        } else if (i < 2048) {
            nr((i >> 6) | 192);
            nr((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                nr(63);
            } else {
                nr((i >> 12) | 224);
                nr(((i >> 6) & 63) | 128);
                nr((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            nr((i >> 18) | 240);
            nr(((i >> 12) & 63) | 128);
            nr(((i >> 6) & 63) | 128);
            nr((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public u u(String str, int i, int i2, Charset charset) {
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
                if (charset.equals(jk.u)) {
                    return u(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return nr(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }
}
