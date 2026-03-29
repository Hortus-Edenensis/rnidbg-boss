package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class br6 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f1808a;
    public long b = 0;
    public byte[] c = new byte[1];
    public long d;

    public br6(InputStream inputStream, long j) {
        this.f1808a = inputStream;
        this.d = j;
    }

    public int a(byte[] bArr) throws IOException {
        int iB = this.f1808a.read(bArr);
        if (iB == bArr.length || (iB = b(bArr, iB)) == bArr.length) {
            return iB;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    public final int b(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int i2 = 0;
        for (int i3 = 0; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
            i2 += this.f1808a.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1808a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.d;
        if (j != -1) {
            long j2 = this.b;
            if (j2 >= j) {
                return -1;
            }
            if (i2 > j - j2) {
                i2 = (int) (j - j2);
            }
        }
        int i3 = this.f1808a.read(bArr, i, i2);
        if (i3 > 0) {
            this.b += (long) i3;
        }
        return i3;
    }
}
