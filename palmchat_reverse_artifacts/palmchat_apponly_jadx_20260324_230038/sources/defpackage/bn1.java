package defpackage;

import android.os.Looper;
import defpackage.jc3;
import defpackage.o63;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class bn1 {
    public static final ExecutorService m = Executors.newCachedThreadPool();
    public boolean e;
    public boolean g;
    public boolean h;
    public List<vm5> j;
    public o63 k;
    public jc3 l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1772a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean f = true;
    public ExecutorService i = m;

    public static Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public o63 b() {
        o63 o63Var = this.k;
        return o63Var != null ? o63Var : o63.a.a();
    }

    public jc3 c() {
        Object objA;
        jc3 jc3Var = this.l;
        if (jc3Var != null) {
            return jc3Var;
        }
        if (!vc.c() || (objA = a()) == null) {
            return null;
        }
        return new jc3.a((Looper) objA);
    }
}
