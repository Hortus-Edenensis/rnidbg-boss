package defpackage;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class ys0 {
    public static ys0 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lt5 f22261a;
    public mw5 b;

    public ys0(Context context) {
        this.f22261a = new lt5(context);
        this.b = new mw5(context);
    }

    public static ys0 d(Context context) {
        if (c == null) {
            c = new ys0(context);
        }
        return c;
    }

    public synchronized void a(String str) {
        this.b.a(str);
    }

    public synchronized void b(String str) {
        this.f22261a.a(str);
    }

    public synchronized void c(String str) {
        this.b.b(str);
    }

    public synchronized void e(ct0 ct0Var) {
        this.f22261a.b(ct0Var);
    }

    public synchronized void f(gt0 gt0Var) {
        this.b.c(gt0Var);
    }

    public synchronized List<gt0> g(String str) {
        return this.b.d(str);
    }

    public synchronized ct0 h(String str) {
        return this.f22261a.c(str);
    }

    public synchronized void i(ct0 ct0Var) {
        this.f22261a.d(ct0Var);
    }

    public synchronized void j(gt0 gt0Var) {
        this.b.e(gt0Var);
    }
}
