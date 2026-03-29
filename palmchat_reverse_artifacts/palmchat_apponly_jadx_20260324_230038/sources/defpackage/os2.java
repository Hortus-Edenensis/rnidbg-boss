package defpackage;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class os2 implements y45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19859a;
    public final l73 b;
    public final l73 c;
    public long d;

    public os2(long j, long j2, long j3) {
        this.d = j;
        this.f19859a = j3;
        l73 l73Var = new l73();
        this.b = l73Var;
        l73 l73Var2 = new l73();
        this.c = l73Var2;
        l73Var.a(0L);
        l73Var2.a(j2);
    }

    public boolean a(long j) {
        l73 l73Var = this.b;
        return j - l73Var.b(l73Var.c() - 1) < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    public void b(long j, long j2) {
        if (a(j)) {
            return;
        }
        this.b.a(j);
        this.c.a(j2);
    }

    public void c(long j) {
        this.d = j;
    }

    @Override // defpackage.y45
    public long getDataEndPosition() {
        return this.f19859a;
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.d;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        int iF = g86.f(this.b, j, true, true);
        x45 x45Var = new x45(this.b.b(iF), this.c.b(iF));
        if (x45Var.f21874a == j || iF == this.b.c() - 1) {
            return new v45.a(x45Var);
        }
        int i = iF + 1;
        return new v45.a(x45Var, new x45(this.b.b(i), this.c.b(i)));
    }

    @Override // defpackage.y45
    public long getTimeUs(long j) {
        return this.b.b(g86.f(this.c, j, true, true));
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return true;
    }
}
