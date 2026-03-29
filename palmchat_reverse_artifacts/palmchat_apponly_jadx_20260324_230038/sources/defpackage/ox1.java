package defpackage;

import defpackage.px1;
import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ox1 implements v45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final px1 f19894a;
    public final long b;

    public ox1(px1 px1Var, long j) {
        this.f19894a = px1Var;
        this.b = j;
    }

    public final x45 a(long j, long j2) {
        return new x45((j * 1000000) / ((long) this.f19894a.e), this.b + j2);
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.f19894a.f();
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        vh.i(this.f19894a.k);
        px1 px1Var = this.f19894a;
        px1.a aVar = px1Var.k;
        long[] jArr = aVar.f20126a;
        long[] jArr2 = aVar.b;
        int i = g86.i(jArr, px1Var.i(j), true, false);
        x45 x45VarA = a(i == -1 ? 0L : jArr[i], i != -1 ? jArr2[i] : 0L);
        if (x45VarA.f21874a == j || i == jArr.length - 1) {
            return new v45.a(x45VarA);
        }
        int i2 = i + 1;
        return new v45.a(x45VarA, a(jArr[i2], jArr2[i2]));
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return true;
    }
}
