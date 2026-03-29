package defpackage;

import com.google.android.exoplayer2.m;
import defpackage.j26;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class fq2 implements gl1 {
    public c06 b;
    public boolean c;
    public int e;
    public int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f17580a = new gc4(10);
    public long d = -9223372036854775807L;

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        vh.i(this.b);
        if (this.c) {
            int iA = gc4Var.a();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iA, 10 - i);
                System.arraycopy(gc4Var.e(), gc4Var.f(), this.f17580a.e(), this.f, iMin);
                if (this.f + iMin == 10) {
                    this.f17580a.U(0);
                    if (73 != this.f17580a.H() || 68 != this.f17580a.H() || 51 != this.f17580a.H()) {
                        y53.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.f17580a.V(3);
                        this.e = this.f17580a.G() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.e - this.f);
            this.b.d(gc4Var, iMin2);
            this.f += iMin2;
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        c06 c06VarTrack = qs1Var.track(dVar.c(), 5);
        this.b = c06VarTrack;
        c06VarTrack.b(new m.b().U(dVar.b()).g0("application/id3").G());
    }

    @Override // defpackage.gl1
    public void packetFinished() {
        int i;
        vh.i(this.b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                this.b.e(j, 1, i, 0, null);
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
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }

    @Override // defpackage.gl1
    public void seek() {
        this.c = false;
        this.d = -9223372036854775807L;
    }
}
