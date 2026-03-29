package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class zu extends RandomAccessFile {
    public static int e = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f22514a;
    public int b;
    public int c;
    public long d;

    public zu(File file, String str) throws IOException {
        this(file, str, e);
    }

    public final int c() throws IOException {
        int i = super.read(this.f22514a, 0, e);
        if (i >= 0) {
            this.d += (long) i;
            this.b = i;
            this.c = 0;
        }
        return i;
    }

    public final void d() throws IOException {
        this.b = 0;
        this.c = 0;
        this.d = super.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() throws IOException {
        return (this.d - ((long) this.b)) + ((long) this.c);
    }

    @Override // java.io.RandomAccessFile
    public final int read() throws IOException {
        if ((this.c >= this.b && c() < 0) || this.b == 0) {
            return -1;
        }
        byte[] bArr = this.f22514a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i];
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j) throws IOException {
        int i;
        int i2 = (int) (this.d - j);
        if (i2 >= 0 && i2 <= (i = this.b)) {
            this.c = i - i2;
        } else {
            super.seek(j);
            d();
        }
    }

    public zu(File file, String str, int i) throws IOException {
        super(file, str);
        this.b = 0;
        this.c = 0;
        this.d = 0L;
        d();
        e = i;
        this.f22514a = new byte[i];
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.b;
        int i4 = this.c;
        if (i2 <= i3 - i4) {
            System.arraycopy(this.f22514a, i4, bArr, i, i2);
            this.c += i2;
            return i2;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = read();
            if (i6 == -1) {
                return i5;
            }
            bArr[i + i5] = (byte) i6;
        }
        return i2;
    }
}
