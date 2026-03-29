package com.opos.exoplayer.core.extractor;

import com.opos.exoplayer.core.util.y;
import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements f {
    private final com.opos.exoplayer.core.upstream.g b;
    private final long c;
    private long d;
    private int f;
    private int g;
    private byte[] e = new byte[65536];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f8158a = new byte[4096];

    public b(com.opos.exoplayer.core.upstream.g gVar, long j, long j2) {
        this.b = gVar;
        this.d = j;
        this.c = j2;
    }

    private int d(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, iMin);
        f(iMin);
        return iMin;
    }

    private int e(int i) {
        int iMin = Math.min(this.g, i);
        f(iMin);
        return iMin;
    }

    private void f(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }

    private void g(int i) {
        if (i != -1) {
            this.d += (long) i;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public int a(int i) throws InterruptedException, EOFException {
        int iE = e(i);
        if (iE == 0) {
            byte[] bArr = this.f8158a;
            iE = a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        g(iE);
        return iE;
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public long b() {
        return this.d + ((long) this.f);
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public long c() {
        return this.d;
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public int a(byte[] bArr, int i, int i2) throws InterruptedException, EOFException {
        int iD = d(bArr, i, i2);
        if (iD == 0) {
            iD = a(bArr, i, i2, 0, true);
        }
        g(iD);
        return iD;
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public void b(int i) throws InterruptedException, EOFException {
        a(i, false);
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public void c(int i) throws InterruptedException, EOFException {
        b(i, false);
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public long d() {
        return this.c;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, EOFException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int iA = this.b.a(bArr, i + i3, i2 - i3);
        if (iA != -1) {
            return i3 + iA;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void d(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, y.a(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public void b(byte[] bArr, int i, int i2) throws InterruptedException, EOFException {
        a(bArr, i, i2, false);
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public void c(byte[] bArr, int i, int i2) {
        b(bArr, i, i2, false);
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public void a() {
        this.f = 0;
    }

    public boolean b(int i, boolean z) throws InterruptedException, EOFException {
        d(i);
        int iMin = Math.min(this.g - this.f, i);
        while (iMin < i) {
            iMin = a(this.e, this.f, i, iMin, z);
            if (iMin == -1) {
                return false;
            }
        }
        int i2 = this.f + i;
        this.f = i2;
        this.g = Math.max(this.g, i2);
        return true;
    }

    public boolean a(int i, boolean z) throws InterruptedException, EOFException {
        int iE = e(i);
        while (iE < i && iE != -1) {
            iE = a(this.f8158a, -iE, Math.min(i, this.f8158a.length + iE), iE, z);
        }
        g(iE);
        return iE != -1;
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public boolean b(byte[] bArr, int i, int i2, boolean z) {
        if (!b(i2, z)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    @Override // com.opos.exoplayer.core.extractor.f
    public boolean a(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, EOFException {
        int iD = d(bArr, i, i2);
        while (iD < i2 && iD != -1) {
            iD = a(bArr, i, i2, iD, z);
        }
        g(iD);
        return iD != -1;
    }
}
