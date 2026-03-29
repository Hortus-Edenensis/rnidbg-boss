package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class xp0<A, B> implements u42<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22028a;

    public xp0() {
        this(true);
    }

    public final B a(A a2) {
        return b(a2);
    }

    @Override // defpackage.u42
    @Deprecated
    public final B apply(A a2) {
        return a(a2);
    }

    public B b(A a2) {
        if (!this.f22028a) {
            return d(a2);
        }
        if (a2 == null) {
            return null;
        }
        return (B) dm4.o(c(a2));
    }

    public abstract B c(A a2);

    /* JADX WARN: Multi-variable type inference failed */
    public final B d(A a2) {
        return (B) c(c44.a(a2));
    }

    public xp0(boolean z) {
        this.f22028a = z;
    }
}
