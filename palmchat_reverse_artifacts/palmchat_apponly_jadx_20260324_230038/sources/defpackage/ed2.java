package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ed2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f17280a;
    public final int[] b;

    public ed2(float[] fArr, int[] iArr) {
        this.f17280a = fArr;
        this.b = iArr;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.f17280a;
    }

    public int c() {
        return this.b.length;
    }

    public void d(ed2 ed2Var, ed2 ed2Var2, float f) {
        if (ed2Var.b.length == ed2Var2.b.length) {
            for (int i = 0; i < ed2Var.b.length; i++) {
                this.f17280a[i] = sp3.i(ed2Var.f17280a[i], ed2Var2.f17280a[i], f);
                this.b[i] = l52.c(f, ed2Var.b[i], ed2Var2.b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + ed2Var.b.length + " vs " + ed2Var2.b.length + ")");
    }
}
