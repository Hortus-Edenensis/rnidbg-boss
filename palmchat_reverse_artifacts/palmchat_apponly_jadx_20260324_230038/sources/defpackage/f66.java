package defpackage;

import com.google.android.exoplayer2.m;
import defpackage.j26;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class f66 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m> f17467a;
    public final c06[] b;

    public f66(List<m> list) {
        this.f17467a = list;
        this.b = new c06[list.size()];
    }

    public void a(long j, gc4 gc4Var) {
        if (gc4Var.a() < 9) {
            return;
        }
        int iQ = gc4Var.q();
        int iQ2 = gc4Var.q();
        int iH = gc4Var.H();
        if (iQ == 434 && iQ2 == 1195456820 && iH == 3) {
            xz.b(j, gc4Var, this.b);
        }
    }

    public void b(qs1 qs1Var, j26.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            c06 c06VarTrack = qs1Var.track(dVar.c(), 3);
            m mVar = this.f17467a.get(i);
            String str = mVar.l;
            vh.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: " + str);
            c06VarTrack.b(new m.b().U(dVar.b()).g0(str).i0(mVar.d).X(mVar.c).H(mVar.E).V(mVar.n).G());
            this.b[i] = c06VarTrack;
        }
    }
}
