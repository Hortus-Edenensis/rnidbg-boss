package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.enums.CompressionMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class h8 extends f60<d> {
    public byte[] f;
    public byte[] g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public h8(br6 br6Var, u43 u43Var, char[] cArr, int i) throws IOException {
        super(br6Var, u43Var, cArr, i);
        this.f = new byte[1];
        this.g = new byte[16];
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
    }

    @Override // defpackage.f60
    public void b(InputStream inputStream) throws IOException {
        o(n(inputStream));
    }

    public final void h(byte[] bArr, int i) {
        int i2 = this.j;
        int i3 = this.i;
        if (i2 >= i3) {
            i2 = i3;
        }
        this.m = i2;
        System.arraycopy(this.g, this.h, bArr, i, i2);
        l(this.m);
        i(this.m);
        int i4 = this.l;
        int i5 = this.m;
        this.l = i4 + i5;
        this.j -= i5;
        this.k += i5;
    }

    public final void i(int i) {
        int i2 = this.i - i;
        this.i = i2;
        if (i2 <= 0) {
            this.i = 0;
        }
    }

    public final byte[] j() throws IOException {
        byte[] bArr = new byte[2];
        g(bArr);
        return bArr;
    }

    public final byte[] k(u43 u43Var) throws IOException {
        if (u43Var.b() == null) {
            throw new IOException("invalid aes extra data record");
        }
        byte[] bArr = new byte[u43Var.b().b().getSaltLength()];
        g(bArr);
        return bArr;
    }

    public final void l(int i) {
        int i2 = this.h + i;
        this.h = i2;
        if (i2 >= 15) {
            this.h = 15;
        }
    }

    @Override // defpackage.f60
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public d f(u43 u43Var, char[] cArr) throws IOException {
        return new d(u43Var.b(), cArr, k(u43Var), j());
    }

    public byte[] n(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        if (wq6.g(inputStream, bArr) == 10) {
            return bArr;
        }
        throw new ZipException("Invalid AES Mac bytes. Could not read sufficient data");
    }

    public final void o(byte[] bArr) throws IOException {
        if (e().n() && CompressionMethod.DEFLATE.equals(wq6.e(e()))) {
            return;
        }
        byte[] bArr2 = new byte[10];
        System.arraycopy(c().b(), 0, bArr2, 0, 10);
        if (!Arrays.equals(bArr, bArr2)) {
            throw new IOException("Reached end of data for this entry, but aes verification failed");
        }
    }

    @Override // defpackage.f60, java.io.InputStream
    public int read() throws IOException {
        if (read(this.f) == -1) {
            return -1;
        }
        return this.f[0];
    }

    @Override // defpackage.f60, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // defpackage.f60, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.j = i2;
        this.k = i;
        this.l = 0;
        if (this.i != 0) {
            h(bArr, i);
            int i3 = this.l;
            if (i3 == i2) {
                return i3;
            }
        }
        if (this.j < 16) {
            byte[] bArr2 = this.g;
            int i4 = super.read(bArr2, 0, bArr2.length);
            this.n = i4;
            this.h = 0;
            if (i4 == -1) {
                this.i = 0;
                int i5 = this.l;
                if (i5 > 0) {
                    return i5;
                }
                return -1;
            }
            this.i = i4;
            h(bArr, this.k);
            int i6 = this.l;
            if (i6 == i2) {
                return i6;
            }
        }
        int i7 = this.k;
        int i8 = this.j;
        int i9 = super.read(bArr, i7, i8 - (i8 % 16));
        if (i9 == -1) {
            int i10 = this.l;
            if (i10 > 0) {
                return i10;
            }
            return -1;
        }
        return i9 + this.l;
    }
}
