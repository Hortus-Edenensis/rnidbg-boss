package defpackage;

import com.google.android.exoplayer2.m;
import defpackage.j26;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class mc4 implements l45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f19194a;
    public jy5 b;
    public c06 c;

    public mc4(String str) {
        this.f19194a = new m.b().g0(str).G();
    }

    @Override // defpackage.l45
    public void a(gc4 gc4Var) {
        c();
        long jD = this.b.d();
        long jE = this.b.e();
        if (jD == -9223372036854775807L || jE == -9223372036854775807L) {
            return;
        }
        m mVar = this.f19194a;
        if (jE != mVar.p) {
            m mVarG = mVar.b().k0(jE).G();
            this.f19194a = mVarG;
            this.c.b(mVarG);
        }
        int iA = gc4Var.a();
        this.c.d(gc4Var, iA);
        this.c.e(jD, 1, iA, 0, null);
    }

    @Override // defpackage.l45
    public void b(jy5 jy5Var, qs1 qs1Var, j26.d dVar) {
        this.b = jy5Var;
        dVar.a();
        c06 c06VarTrack = qs1Var.track(dVar.c(), 5);
        this.c = c06VarTrack;
        c06VarTrack.b(this.f19194a);
    }

    public final void c() {
        vh.i(this.b);
        g86.j(this.c);
    }
}
