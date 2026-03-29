package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class uw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21306a;
    public final int[] b;
    public final sx4[] c;

    public uw1(int i, int[] iArr, int i2, int i3, int i4) {
        this.f21306a = i;
        this.b = iArr;
        float f = i4;
        this.c = new sx4[]{new sx4(i2, f), new sx4(i3, f)};
    }

    public sx4[] a() {
        return this.c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.f21306a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof uw1) && this.f21306a == ((uw1) obj).f21306a;
    }

    public int hashCode() {
        return this.f21306a;
    }
}
