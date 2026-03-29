package defpackage;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ws {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s93 f21787a;

    public ws(s93 s93Var) {
        this.f21787a = s93Var;
    }

    public abstract ws a(s93 s93Var);

    public abstract ht b() throws NotFoundException;

    public abstract et c(int i, et etVar) throws NotFoundException;

    public final int d() {
        return this.f21787a.a();
    }

    public final s93 e() {
        return this.f21787a;
    }

    public final int f() {
        return this.f21787a.d();
    }
}
