package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pw0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f60 f20118a;
    public byte[] b = new byte[1];

    public pw0(f60 f60Var) {
        this.f20118a = f60Var;
    }

    public void a(InputStream inputStream) throws IOException {
        this.f20118a.b(inputStream);
    }

    public byte[] c() {
        return this.f20118a.d();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f20118a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.b) == -1) {
            return -1;
        }
        return this.b[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f20118a.read(bArr, i, i2);
    }

    public void d(PushbackInputStream pushbackInputStream) throws IOException {
    }
}
