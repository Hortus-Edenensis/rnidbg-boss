package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ih5 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RandomAccessFile f18168a;
    public File b;
    public boolean c;
    public int d;
    public byte[] e = new byte[1];

    public ih5(File file, boolean z, int i) throws FileNotFoundException {
        this.d = 0;
        this.f18168a = new RandomAccessFile(file, RandomAccessFileMode.READ.getValue());
        this.b = file;
        this.c = z;
        if (z) {
            this.d = i;
        }
    }

    public abstract File b(int i) throws IOException;

    public void c(int i) throws IOException {
        File fileB = b(i);
        if (fileB.exists()) {
            this.f18168a.close();
            this.f18168a = new RandomAccessFile(fileB, RandomAccessFileMode.READ.getValue());
        } else {
            throw new FileNotFoundException("zip split file does not exist: " + fileB);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.f18168a;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public void d(eu1 eu1Var) throws IOException {
        if (this.c && this.d != eu1Var.J()) {
            c(eu1Var.J());
            this.d = eu1Var.J();
        }
        this.f18168a.seek(eu1Var.L());
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.e) == -1) {
            return -1;
        }
        return this.e[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f18168a.read(bArr, i, i2);
        if ((i3 == i2 && i3 != -1) || !this.c) {
            return i3;
        }
        c(this.d + 1);
        this.d++;
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.f18168a.read(bArr, i3, i2 - i3);
        return i4 > 0 ? i3 + i4 : i3;
    }
}
