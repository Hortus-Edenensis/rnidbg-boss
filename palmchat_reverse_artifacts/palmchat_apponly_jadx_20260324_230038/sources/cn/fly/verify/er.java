package cn.fly.verify;

import android.content.Context;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class er {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static er f2254a = new er();
    private volatile Context b;
    private volatile ep c;
    private volatile ep d;
    private volatile ep e;
    private final AtomicBoolean f = new AtomicBoolean(false);

    public static er a(Context context) {
        if (f2254a.b == null && context != null) {
            f2254a.b = context.getApplicationContext();
        }
        return f2254a;
    }

    public void b() {
        if (this.f.compareAndSet(false, true)) {
            d();
            c();
            et.a(this.b);
        }
    }

    public ep c() {
        if (this.c == null) {
            this.c = new ey(this.b);
        }
        return this.c;
    }

    public ep d() {
        if (this.d == null) {
            this.d = new ev(this.b);
        }
        return this.d;
    }

    public ep e() {
        return this.e == null ? c() : this.e;
    }

    public CountDownLatch a() {
        b();
        return es.a(this.b).a();
    }

    public boolean a(ep epVar) {
        this.e = epVar;
        return true;
    }
}
