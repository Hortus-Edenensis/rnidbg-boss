package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class b35 {
    public static final AtomicReference<b35> d = new AtomicReference<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x25 f1639a;
    public final x25 b;
    public final x25 c;

    public b35() {
        oz4 oz4VarF = nz4.c().f();
        x25 x25VarG = oz4VarF.g();
        if (x25VarG != null) {
            this.f1639a = x25VarG;
        } else {
            this.f1639a = oz4.a();
        }
        x25 x25VarI = oz4VarF.i();
        if (x25VarI != null) {
            this.b = x25VarI;
        } else {
            this.b = oz4.c();
        }
        x25 x25VarJ = oz4VarF.j();
        if (x25VarJ != null) {
            this.c = x25VarJ;
        } else {
            this.c = oz4.e();
        }
    }

    public static x25 a() {
        return kz4.c(b().f1639a);
    }

    public static b35 b() {
        while (true) {
            AtomicReference<b35> atomicReference = d;
            b35 b35Var = atomicReference.get();
            if (b35Var != null) {
                return b35Var;
            }
            b35 b35Var2 = new b35();
            if (g23.a(atomicReference, null, b35Var2)) {
                return b35Var2;
            }
            b35Var2.d();
        }
    }

    public static x25 c() {
        return kz4.h(b().b);
    }

    public synchronized void d() {
        Object obj = this.f1639a;
        if (obj instanceof z25) {
            ((z25) obj).shutdown();
        }
        Object obj2 = this.b;
        if (obj2 instanceof z25) {
            ((z25) obj2).shutdown();
        }
        Object obj3 = this.c;
        if (obj3 instanceof z25) {
            ((z25) obj3).shutdown();
        }
    }
}
