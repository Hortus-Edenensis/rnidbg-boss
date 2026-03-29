package defpackage;

import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class hn implements fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17997a;
    public final int b;
    public final int c;
    public final int d;

    public hn(int i, int i2, int i3, int i4) {
        this.f17997a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static hn b(gc4 gc4Var) {
        int iU = gc4Var.u();
        gc4Var.V(8);
        int iU2 = gc4Var.u();
        int iU3 = gc4Var.u();
        gc4Var.V(4);
        int iU4 = gc4Var.u();
        gc4Var.V(12);
        return new hn(iU, iU2, iU3, iU4);
    }

    public boolean a() {
        return (this.b & 16) == 16;
    }

    @Override // defpackage.fn
    public int getType() {
        return AviExtractor.FOURCC_avih;
    }
}
