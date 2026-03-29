package defpackage;

import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class c61 implements i43 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vw0 f1899a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public int j;
    public boolean k;

    public c61() {
        this(new vw0(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public static void c(int i, int i2, String str, String str2) {
        vh.b(i >= i2, str + " cannot be less than " + str2);
    }

    public static int e(int i) {
        switch (i) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    @Override // defpackage.i43
    public void a(e0 e0Var, kk3 kk3Var, z[] zVarArr, vz5 vz5Var, or1[] or1VarArr) {
        int iD = this.f;
        if (iD == -1) {
            iD = d(zVarArr, or1VarArr);
        }
        this.j = iD;
        this.f1899a.e(iD);
    }

    @Override // defpackage.i43
    public boolean b(e0 e0Var, kk3 kk3Var, long j, float f, boolean z, long j2) {
        long jG0 = g86.g0(j, f);
        long jMin = z ? this.e : this.d;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        return jMin <= 0 || jG0 >= jMin || (!this.g && this.f1899a.c() >= this.j);
    }

    public int d(z[] zVarArr, or1[] or1VarArr) {
        int iE = 0;
        for (int i = 0; i < zVarArr.length; i++) {
            if (or1VarArr[i] != null) {
                iE += e(zVarArr[i].getTrackType());
            }
        }
        return Math.max(13107200, iE);
    }

    public final void f(boolean z) {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        if (z) {
            this.f1899a.d();
        }
    }

    @Override // defpackage.i43
    public w9 getAllocator() {
        return this.f1899a;
    }

    @Override // defpackage.i43
    public long getBackBufferDurationUs() {
        return this.h;
    }

    @Override // defpackage.i43
    public void onPrepared() {
        f(false);
    }

    @Override // defpackage.i43
    public void onReleased() {
        f(true);
    }

    @Override // defpackage.i43
    public void onStopped() {
        f(true);
    }

    @Override // defpackage.i43
    public boolean retainBackBufferFromKeyframe() {
        return this.i;
    }

    @Override // defpackage.i43
    public boolean shouldContinueLoading(long j, long j2, float f) {
        boolean z = true;
        boolean z2 = this.f1899a.c() >= this.j;
        long jMin = this.b;
        if (f > 1.0f) {
            jMin = Math.min(g86.b0(jMin, f), this.c);
        }
        if (j2 < Math.max(jMin, 500000L)) {
            if (!this.g && z2) {
                z = false;
            }
            this.k = z;
            if (!z && j2 < 500000) {
                y53.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.c || z2) {
            this.k = false;
        }
        return this.k;
    }

    public c61(vw0 vw0Var, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        c(i3, 0, "bufferForPlaybackMs", "0");
        c(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        c(i, i3, "minBufferMs", "bufferForPlaybackMs");
        c(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        c(i2, i, "maxBufferMs", "minBufferMs");
        c(i6, 0, "backBufferDurationMs", "0");
        this.f1899a = vw0Var;
        this.b = g86.H0(i);
        this.c = g86.H0(i2);
        this.d = g86.H0(i3);
        this.e = g86.H0(i4);
        this.f = i5;
        this.j = i5 == -1 ? 13107200 : i5;
        this.g = z;
        this.h = g86.H0(i6);
        this.i = z2;
    }
}
