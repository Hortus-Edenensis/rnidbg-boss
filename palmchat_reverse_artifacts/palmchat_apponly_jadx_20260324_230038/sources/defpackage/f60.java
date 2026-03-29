package defpackage;

import defpackage.tw0;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import net.lingala.zip4j.model.enums.CompressionMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f60<T extends tw0> extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public br6 f17463a;
    public T b;
    public byte[] c;
    public byte[] d = new byte[1];
    public u43 e;

    public f60(br6 br6Var, u43 u43Var, char[] cArr, int i) throws IOException {
        this.f17463a = br6Var;
        this.b = (T) f(u43Var, cArr);
        this.e = u43Var;
        if (wq6.e(u43Var).equals(CompressionMethod.DEFLATE)) {
            this.c = new byte[i];
        }
    }

    public final void a(byte[] bArr, int i) {
        byte[] bArr2 = this.c;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    public T c() {
        return this.b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f17463a.close();
    }

    public byte[] d() {
        return this.c;
    }

    public u43 e() {
        return this.e;
    }

    public abstract T f(u43 u43Var, char[] cArr) throws IOException;

    public int g(byte[] bArr) throws IOException {
        return this.f17463a.a(bArr);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.d) == -1) {
            return -1;
        }
        return this.d[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iH = wq6.h(this.f17463a, bArr, i, i2);
        if (iH > 0) {
            a(bArr, iH);
            this.b.a(bArr, i, iH);
        }
        return iH;
    }

    public void b(InputStream inputStream) throws IOException {
    }
}
