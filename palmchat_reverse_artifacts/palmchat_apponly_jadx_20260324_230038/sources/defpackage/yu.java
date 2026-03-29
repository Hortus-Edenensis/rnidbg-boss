package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class yu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22278a;

    public final void a(int i) {
        this.f22278a = i | this.f22278a;
    }

    public void b() {
        this.f22278a = 0;
    }

    public final void c(int i) {
        this.f22278a = (~i) & this.f22278a;
    }

    public final boolean d(int i) {
        return (this.f22278a & i) == i;
    }

    public final boolean e() {
        return d(268435456);
    }

    public final boolean f() {
        return d(Integer.MIN_VALUE);
    }

    public final boolean g() {
        return d(4);
    }

    public final boolean h() {
        return d(134217728);
    }

    public final boolean i() {
        return d(1);
    }

    public final boolean j() {
        return d(536870912);
    }

    public final void k(int i) {
        this.f22278a = i;
    }
}
