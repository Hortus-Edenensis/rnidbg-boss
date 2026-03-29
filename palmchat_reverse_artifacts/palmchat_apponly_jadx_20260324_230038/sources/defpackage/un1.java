package defpackage;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class un1 implements d25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f21246a;
    public long[] c;
    public boolean d;
    public vn1 e;
    public boolean f;
    public int g;
    public final pn1 b = new pn1();
    public long h = -9223372036854775807L;

    public un1(vn1 vn1Var, m mVar, boolean z) {
        this.f21246a = mVar;
        this.e = vn1Var;
        this.c = vn1Var.b;
        d(vn1Var, z);
    }

    public String a() {
        return this.e.a();
    }

    public void b(long j) {
        int iE = g86.e(this.c, j, true, false);
        this.g = iE;
        if (!(this.d && iE == this.c.length)) {
            j = -9223372036854775807L;
        }
        this.h = j;
    }

    @Override // defpackage.d25
    public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int i2 = this.g;
        boolean z = i2 == this.c.length;
        if (z && !this.d) {
            decoderInputBuffer.k(4);
            return -4;
        }
        if ((i & 2) != 0 || !this.f) {
            f12Var.b = this.f21246a;
            this.f = true;
            return -5;
        }
        if (z) {
            return -3;
        }
        if ((i & 1) == 0) {
            this.g = i2 + 1;
        }
        if ((i & 4) == 0) {
            byte[] bArrA = this.b.a(this.e.f21484a[i2]);
            decoderInputBuffer.m(bArrA.length);
            decoderInputBuffer.c.put(bArrA);
        }
        decoderInputBuffer.e = this.c[i2];
        decoderInputBuffer.k(1);
        return -4;
    }

    public void d(vn1 vn1Var, boolean z) {
        int i = this.g;
        long j = i == 0 ? -9223372036854775807L : this.c[i - 1];
        this.d = z;
        this.e = vn1Var;
        long[] jArr = vn1Var.b;
        this.c = jArr;
        long j2 = this.h;
        if (j2 != -9223372036854775807L) {
            b(j2);
        } else if (j != -9223372036854775807L) {
            this.g = g86.e(jArr, j, false, false);
        }
    }

    @Override // defpackage.d25
    public boolean isReady() {
        return true;
    }

    @Override // defpackage.d25
    public int skipData(long j) {
        int iMax = Math.max(this.g, g86.e(this.c, j, true, false));
        int i = iMax - this.g;
        this.g = iMax;
        return i;
    }

    @Override // defpackage.d25
    public void maybeThrowError() throws IOException {
    }
}
