package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.UByte;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class dt4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f17136a = new byte[2];
    public final byte[] b = new byte[4];
    public final byte[] c = new byte[8];

    public final void a(InputStream inputStream, byte[] bArr, int i) throws IOException {
        if (wq6.h(inputStream, bArr, 0, i) != i) {
            throw new ZipException("Could not fill buffer");
        }
    }

    public int b(InputStream inputStream) throws IOException {
        a(inputStream, this.b, 4);
        return d(this.b);
    }

    public int c(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.b);
        return d(this.b);
    }

    public int d(byte[] bArr) {
        return e(bArr, 0);
    }

    public int e(byte[] bArr, int i) {
        return ((((bArr[i + 3] & UByte.MAX_VALUE) << 8) | (bArr[i + 2] & UByte.MAX_VALUE)) << 16) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8);
    }

    public long f(InputStream inputStream) throws IOException {
        byte[] bArr = this.c;
        a(inputStream, bArr, bArr.length);
        return j(this.c, 0);
    }

    public long g(InputStream inputStream, int i) throws IOException {
        n(this.c);
        a(inputStream, this.c, i);
        return j(this.c, 0);
    }

    public long h(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.c);
        return j(this.c, 0);
    }

    public long i(RandomAccessFile randomAccessFile, int i) throws IOException {
        n(this.c);
        randomAccessFile.readFully(this.c, 0, i);
        return j(this.c, 0);
    }

    public long j(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            n(this.c);
        }
        System.arraycopy(bArr, i, this.c, 0, bArr.length < 8 ? bArr.length - i : 8);
        byte[] bArr2 = this.c;
        return ((long) (bArr2[0] & UByte.MAX_VALUE)) | ((((((((((((((((long) (bArr2[7] & UByte.MAX_VALUE)) | 0) << 8) | ((long) (bArr2[6] & UByte.MAX_VALUE))) << 8) | ((long) (bArr2[5] & UByte.MAX_VALUE))) << 8) | ((long) (bArr2[4] & UByte.MAX_VALUE))) << 8) | ((long) (bArr2[3] & UByte.MAX_VALUE))) << 8) | ((long) (bArr2[2] & UByte.MAX_VALUE))) << 8) | ((long) (bArr2[1] & UByte.MAX_VALUE))) << 8);
    }

    public int k(InputStream inputStream) throws IOException {
        byte[] bArr = this.f17136a;
        a(inputStream, bArr, bArr.length);
        return m(this.f17136a, 0);
    }

    public int l(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f17136a);
        return m(this.f17136a, 0);
    }

    public int m(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
    }

    public final void n(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }
}
