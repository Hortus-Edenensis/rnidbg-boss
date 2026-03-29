package defpackage;

import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class kk5 implements qs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18712a;
    public final qs1 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements v45 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v45 f18713a;

        public a(v45 v45Var) {
            this.f18713a = v45Var;
        }

        @Override // defpackage.v45
        public long getDurationUs() {
            return this.f18713a.getDurationUs();
        }

        @Override // defpackage.v45
        public v45.a getSeekPoints(long j) {
            v45.a seekPoints = this.f18713a.getSeekPoints(j);
            x45 x45Var = seekPoints.f21356a;
            x45 x45Var2 = new x45(x45Var.f21874a, x45Var.b + kk5.this.f18712a);
            x45 x45Var3 = seekPoints.b;
            return new v45.a(x45Var2, new x45(x45Var3.f21874a, x45Var3.b + kk5.this.f18712a));
        }

        @Override // defpackage.v45
        public boolean isSeekable() {
            return this.f18713a.isSeekable();
        }
    }

    public kk5(long j, qs1 qs1Var) {
        this.f18712a = j;
        this.b = qs1Var;
    }

    @Override // defpackage.qs1
    public void d(v45 v45Var) {
        this.b.d(new a(v45Var));
    }

    @Override // defpackage.qs1
    public void endTracks() {
        this.b.endTracks();
    }

    @Override // defpackage.qs1
    public c06 track(int i, int i2) {
        return this.b.track(i, i2);
    }
}
