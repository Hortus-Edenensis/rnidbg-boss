package defpackage;

import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class in implements fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18205a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public in(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f18205a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public static in c(gc4 gc4Var) {
        int iU = gc4Var.u();
        gc4Var.V(12);
        int iU2 = gc4Var.u();
        int iU3 = gc4Var.u();
        int iU4 = gc4Var.u();
        gc4Var.V(4);
        int iU5 = gc4Var.u();
        int iU6 = gc4Var.u();
        gc4Var.V(8);
        return new in(iU, iU2, iU3, iU4, iU5, iU6);
    }

    public long a() {
        return g86.U0(this.e, ((long) this.c) * 1000000, this.d);
    }

    public int b() {
        int i = this.f18205a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        y53.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f18205a));
        return -1;
    }

    @Override // defpackage.fn
    public int getType() {
        return AviExtractor.FOURCC_strh;
    }
}
