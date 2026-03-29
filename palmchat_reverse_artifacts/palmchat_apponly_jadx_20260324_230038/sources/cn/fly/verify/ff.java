package cn.fly.verify;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ff extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f2349a;
    private long b;
    private fm c;

    public ff(InputStream inputStream) {
        this.f2349a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f2349a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2349a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f2349a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f2349a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f2349a.read();
        if (i >= 0) {
            long j = this.b + 1;
            this.b = j;
            fm fmVar = this.c;
            if (fmVar != null) {
                fmVar.a(j);
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f2349a.reset();
        this.b = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f2349a.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f2349a.read(bArr, i, i2);
        if (i3 > 0) {
            long j = this.b + ((long) i3);
            this.b = j;
            fm fmVar = this.c;
            if (fmVar != null) {
                fmVar.a(j);
            }
        }
        return i3;
    }
}
