package defpackage;

import com.google.android.exoplayer2.m;
import defpackage.j26;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ui1 implements gl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j26.a> f21217a;
    public final c06[] b;
    public boolean c;
    public int d;
    public int e;
    public long f = -9223372036854775807L;

    public ui1(List<j26.a> list) {
        this.f21217a = list;
        this.b = new c06[list.size()];
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        if (this.c) {
            if (this.d != 2 || c(gc4Var, 32)) {
                if (this.d != 1 || c(gc4Var, 0)) {
                    int iF = gc4Var.f();
                    int iA = gc4Var.a();
                    for (c06 c06Var : this.b) {
                        gc4Var.U(iF);
                        c06Var.d(gc4Var, iA);
                    }
                    this.e += iA;
                }
            }
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            j26.a aVar = this.f21217a.get(i);
            dVar.a();
            c06 c06VarTrack = qs1Var.track(dVar.c(), 3);
            c06VarTrack.b(new m.b().U(dVar.b()).g0("application/dvbsubs").V(Collections.singletonList(aVar.c)).X(aVar.f18313a).G());
            this.b[i] = c06VarTrack;
        }
    }

    public final boolean c(gc4 gc4Var, int i) {
        if (gc4Var.a() == 0) {
            return false;
        }
        if (gc4Var.H() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (c06 c06Var : this.b) {
                    c06Var.e(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }

    @Override // defpackage.gl1
    public void seek() {
        this.c = false;
        this.f = -9223372036854775807L;
    }
}
