package com.opos.exoplayer.core.extractor;

import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8155a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.f8155a = length;
        if (length <= 0) {
            this.f = 0L;
        } else {
            int i = length - 1;
            this.f = jArr2[i] + jArr3[i];
        }
    }

    public int a(long j) {
        return y.a(this.e, j, true, true);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public long b() {
        return this.f;
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public l.a b(long j) {
        int iA = a(j);
        m mVar = new m(this.e[iA], this.c[iA]);
        if (mVar.b >= j || iA == this.f8155a - 1) {
            return new l.a(mVar);
        }
        int i = iA + 1;
        return new l.a(mVar, new m(this.e[i], this.c[i]));
    }
}
