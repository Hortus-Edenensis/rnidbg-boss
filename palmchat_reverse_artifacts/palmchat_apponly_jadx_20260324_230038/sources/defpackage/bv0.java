package defpackage;

import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bv0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1825a;
    public final b b;
    public long f;
    public boolean d = false;
    public boolean e = false;
    public final byte[] c = new byte[1];

    public bv0(a aVar, b bVar) {
        this.f1825a = aVar;
        this.b = bVar;
    }

    public final void c() throws IOException {
        if (this.d) {
            return;
        }
        this.f1825a.a(this.b);
        this.d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.e) {
            return;
        }
        this.f1825a.close();
        this.e = true;
    }

    public void d() throws IOException {
        c();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        vh.g(!this.e);
        c();
        int i3 = this.f1825a.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.f += (long) i3;
        return i3;
    }
}
