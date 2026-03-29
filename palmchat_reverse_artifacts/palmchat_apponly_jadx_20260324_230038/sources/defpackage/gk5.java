package defpackage;

import com.google.android.exoplayer2.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gk5 implements xe3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed0 f17742a;
    public boolean b;
    public long c;
    public long d;
    public u e = u.d;

    public gk5(ed0 ed0Var) {
        this.f17742a = ed0Var;
    }

    public void a(long j) {
        this.c = j;
        if (this.b) {
            this.d = this.f17742a.elapsedRealtime();
        }
    }

    @Override // defpackage.xe3
    public void b(u uVar) {
        if (this.b) {
            a(getPositionUs());
        }
        this.e = uVar;
    }

    public void c() {
        if (this.b) {
            return;
        }
        this.d = this.f17742a.elapsedRealtime();
        this.b = true;
    }

    public void d() {
        if (this.b) {
            a(getPositionUs());
            this.b = false;
        }
    }

    @Override // defpackage.xe3
    public u getPlaybackParameters() {
        return this.e;
    }

    @Override // defpackage.xe3
    public long getPositionUs() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        long jElapsedRealtime = this.f17742a.elapsedRealtime() - this.d;
        u uVar = this.e;
        return j + (uVar.f5989a == 1.0f ? g86.H0(jElapsedRealtime) : uVar.b(jElapsedRealtime));
    }
}
