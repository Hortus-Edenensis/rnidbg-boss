package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class bj5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public so2 f1735a;
    public ro2 b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static bj5 f1736a = new bj5();
    }

    public static bj5 b() {
        return a.f1736a;
    }

    public ro2 a() {
        return this.b;
    }

    public uo2 c() {
        so2 so2Var = this.f1735a;
        if (so2Var != null) {
            return so2Var.a();
        }
        return null;
    }

    public vo2 d() {
        so2 so2Var = this.f1735a;
        if (so2Var != null) {
            return so2Var.b();
        }
        return null;
    }

    public void e(ro2 ro2Var) {
        this.b = ro2Var;
    }

    public void f(so2 so2Var) {
        this.f1735a = so2Var;
    }
}
