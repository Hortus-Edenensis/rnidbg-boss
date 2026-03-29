package defpackage;

import com.google.android.exoplayer2.m;
import defpackage.j26;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d55 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m> f16979a;
    public final c06[] b;

    public d55(List<m> list) {
        this.f16979a = list;
        this.b = new c06[list.size()];
    }

    public void a(long j, gc4 gc4Var) {
        xz.a(j, gc4Var, this.b);
    }

    public void b(qs1 qs1Var, j26.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            c06 c06VarTrack = qs1Var.track(dVar.c(), 3);
            m mVar = this.f16979a.get(i);
            String str = mVar.l;
            vh.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: " + str);
            String strB = mVar.f5892a;
            if (strB == null) {
                strB = dVar.b();
            }
            c06VarTrack.b(new m.b().U(strB).g0(str).i0(mVar.d).X(mVar.c).H(mVar.E).V(mVar.n).G());
            this.b[i] = c06VarTrack;
        }
    }
}
