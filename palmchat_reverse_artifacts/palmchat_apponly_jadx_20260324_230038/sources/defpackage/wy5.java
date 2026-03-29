package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class wy5 {
    public static final wy5 b = new nd5(null, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wy5 f21833a;

    public wy5(wy5 wy5Var) {
        this.f21833a = wy5Var;
    }

    public final wy5 a(int i, int i2) {
        return new nd5(this, i, i2);
    }

    public final wy5 b(int i, int i2) {
        return new ct(this, i, i2);
    }

    public abstract void c(et etVar, byte[] bArr);

    public final wy5 d() {
        return this.f21833a;
    }
}
