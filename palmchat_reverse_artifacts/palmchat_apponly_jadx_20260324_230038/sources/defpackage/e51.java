package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e51 implements ps1 {
    public final ru0 b;
    public final long c;
    public long d;
    public int f;
    public int g;
    public byte[] e = new byte[65536];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f17214a = new byte[4096];

    static {
        jr1.a("goog.exo.extractor");
    }

    public e51(ru0 ru0Var, long j, long j2) {
        this.b = ru0Var;
        this.d = j;
        this.c = j2;
    }

    @Override // defpackage.ps1
    public boolean advancePeekPosition(int i, boolean z) throws IOException {
        d(i);
        int iF = this.g - this.f;
        while (iF < i) {
            iF = f(this.e, this.f, i, iF, z);
            if (iF == -1) {
                return false;
            }
            this.g = this.f + iF;
        }
        this.f += i;
        return true;
    }

    public final void c(int i) {
        if (i != -1) {
            this.d += (long) i;
        }
    }

    public final void d(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, g86.q(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    public final int e(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, iMin);
        i(iMin);
        return iMin;
    }

    public final int f(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i4 = this.b.read(bArr, i + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    public final int g(int i) {
        int iMin = Math.min(this.g, i);
        i(iMin);
        return iMin;
    }

    @Override // defpackage.ps1
    public long getLength() {
        return this.c;
    }

    @Override // defpackage.ps1
    public long getPeekPosition() {
        return this.d + ((long) this.f);
    }

    @Override // defpackage.ps1
    public long getPosition() {
        return this.d;
    }

    public boolean h(int i, boolean z) throws IOException {
        int iG = g(i);
        while (iG < i && iG != -1) {
            iG = f(this.f17214a, -iG, Math.min(i, this.f17214a.length + iG), iG, z);
        }
        c(iG);
        return iG != -1;
    }

    public final void i(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }

    @Override // defpackage.ps1
    public int peek(byte[] bArr, int i, int i2) throws IOException {
        int iMin;
        d(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            iMin = f(this.e, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.g += iMin;
        } else {
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(this.e, this.f, bArr, i, iMin);
        this.f += iMin;
        return iMin;
    }

    @Override // defpackage.ps1
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    @Override // defpackage.ps1, defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iE = e(bArr, i, i2);
        if (iE == 0) {
            iE = f(bArr, i, i2, 0, true);
        }
        c(iE);
        return iE;
    }

    @Override // defpackage.ps1
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int iE = e(bArr, i, i2);
        while (iE < i2 && iE != -1) {
            iE = f(bArr, i, i2, iE, z);
        }
        c(iE);
        return iE != -1;
    }

    @Override // defpackage.ps1
    public void resetPeekPosition() {
        this.f = 0;
    }

    @Override // defpackage.ps1
    public int skip(int i) throws IOException {
        int iG = g(i);
        if (iG == 0) {
            byte[] bArr = this.f17214a;
            iG = f(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        c(iG);
        return iG;
    }

    @Override // defpackage.ps1
    public void skipFully(int i) throws IOException {
        h(i, false);
    }

    @Override // defpackage.ps1
    public void peekFully(byte[] bArr, int i, int i2) throws IOException {
        peekFully(bArr, i, i2, false);
    }

    @Override // defpackage.ps1
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        readFully(bArr, i, i2, false);
    }

    @Override // defpackage.ps1
    public void advancePeekPosition(int i) throws IOException {
        advancePeekPosition(i, false);
    }
}
