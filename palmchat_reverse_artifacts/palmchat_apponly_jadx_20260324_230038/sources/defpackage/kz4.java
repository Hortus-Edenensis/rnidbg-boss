package defpackage;

import defpackage.lj0;
import defpackage.n54;
import defpackage.pd5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class kz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c5<Throwable> f18859a;
    public static volatile s42<n54.a, n54.a> b;
    public static volatile s42<pd5.b, pd5.b> c;
    public static volatile s42<lj0.c, lj0.c> d;
    public static volatile t42<n54, n54.a, n54.a> e;
    public static volatile t42<pd5, pd5.b, pd5.b> f;
    public static volatile t42<lj0, lj0.c, lj0.c> g;
    public static volatile s42<x25, x25> h;
    public static volatile s42<x25, x25> i;
    public static volatile s42<b5, b5> j;
    public static volatile s42<zm5, zm5> k;
    public static volatile s42<zm5, zm5> l;
    public static volatile s42<Throwable, Throwable> m;
    public static volatile s42<Throwable, Throwable> n;
    public static volatile s42<Throwable, Throwable> o;
    public static volatile s42<n54.b, n54.b> p;
    public static volatile s42<n54.b, n54.b> q;
    public static volatile s42<lj0.d, lj0.d> r;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements s42<Throwable, Throwable> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Throwable call(Throwable th) {
            return nz4.c().g().c(th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements s42<n54.b, n54.b> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n54.b call(n54.b bVar) {
            return nz4.c().g().b(bVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements s42<Throwable, Throwable> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Throwable call(Throwable th) {
            return nz4.c().a().c(th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements s42<lj0.d, lj0.d> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public lj0.d call(lj0.d dVar) {
            return nz4.c().a().b(dVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements s42<n54.a, n54.a> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n54.a call(n54.a aVar) {
            return nz4.c().d().a(aVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements s42<pd5.b, pd5.b> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public pd5.b call(pd5.b bVar) {
            return nz4.c().g().a(bVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g implements s42<lj0.c, lj0.c> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public lj0.c call(lj0.c cVar) {
            return nz4.c().a().a(cVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements c5<Throwable> {
        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            nz4.c().b().a(th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i implements t42<n54, n54.a, n54.a> {
        @Override // defpackage.t42
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n54.a a(n54 n54Var, n54.a aVar) {
            return nz4.c().d().e(n54Var, aVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j implements s42<zm5, zm5> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zm5 call(zm5 zm5Var) {
            return nz4.c().d().d(zm5Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k implements t42<pd5, pd5.b, pd5.b> {
        @Override // defpackage.t42
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public pd5.b a(pd5 pd5Var, pd5.b bVar) {
            pz4 pz4VarG = nz4.c().g();
            return pz4VarG == qz4.f() ? bVar : new qd5(pz4VarG.e(pd5Var, new fe5(bVar)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l implements s42<zm5, zm5> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zm5 call(zm5 zm5Var) {
            return nz4.c().g().d(zm5Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m implements t42<lj0, lj0.c, lj0.c> {
        @Override // defpackage.t42
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public lj0.c a(lj0 lj0Var, lj0.c cVar) {
            return nz4.c().a().d(lj0Var, cVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n implements s42<b5, b5> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b5 call(b5 b5Var) {
            return nz4.c().f().k(b5Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o implements s42<Throwable, Throwable> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Throwable call(Throwable th) {
            return nz4.c().d().c(th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p implements s42<n54.b, n54.b> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n54.b call(n54.b bVar) {
            return nz4.c().d().b(bVar);
        }
    }

    static {
        a();
    }

    public static void a() {
        f18859a = new h();
        e = new i();
        k = new j();
        f = new k();
        l = new l();
        g = new m();
        j = new n();
        m = new o();
        p = new p();
        n = new a();
        q = new b();
        o = new c();
        r = new d();
        b();
    }

    public static void b() {
        b = new e();
        c = new f();
        d = new g();
    }

    public static x25 c(x25 x25Var) {
        s42<x25, x25> s42Var = h;
        return s42Var != null ? s42Var.call(x25Var) : x25Var;
    }

    public static lj0.c d(lj0.c cVar) {
        s42<lj0.c, lj0.c> s42Var = d;
        return s42Var != null ? s42Var.call(cVar) : cVar;
    }

    public static <T> n54.a<T> e(n54.a<T> aVar) {
        s42<n54.a, n54.a> s42Var = b;
        return s42Var != null ? s42Var.call(aVar) : aVar;
    }

    public static <T> pd5.b<T> f(pd5.b<T> bVar) {
        s42<pd5.b, pd5.b> s42Var = c;
        return s42Var != null ? s42Var.call(bVar) : bVar;
    }

    public static void g(Throwable th) {
        c5<Throwable> c5Var = f18859a;
        if (c5Var != null) {
            try {
                c5Var.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                q(th2);
            }
        }
        q(th);
    }

    public static x25 h(x25 x25Var) {
        s42<x25, x25> s42Var = i;
        return s42Var != null ? s42Var.call(x25Var) : x25Var;
    }

    public static Throwable i(Throwable th) {
        s42<Throwable, Throwable> s42Var = m;
        return s42Var != null ? s42Var.call(th) : th;
    }

    public static <T, R> n54.b<R, T> j(n54.b<R, T> bVar) {
        s42<n54.b, n54.b> s42Var = p;
        return s42Var != null ? s42Var.call(bVar) : bVar;
    }

    public static zm5 k(zm5 zm5Var) {
        s42<zm5, zm5> s42Var = k;
        return s42Var != null ? s42Var.call(zm5Var) : zm5Var;
    }

    public static <T> n54.a<T> l(n54<T> n54Var, n54.a<T> aVar) {
        t42<n54, n54.a, n54.a> t42Var = e;
        return t42Var != null ? t42Var.a(n54Var, aVar) : aVar;
    }

    public static b5 m(b5 b5Var) {
        s42<b5, b5> s42Var = j;
        return s42Var != null ? s42Var.call(b5Var) : b5Var;
    }

    public static Throwable n(Throwable th) {
        s42<Throwable, Throwable> s42Var = n;
        return s42Var != null ? s42Var.call(th) : th;
    }

    public static zm5 o(zm5 zm5Var) {
        s42<zm5, zm5> s42Var = l;
        return s42Var != null ? s42Var.call(zm5Var) : zm5Var;
    }

    public static <T> pd5.b<T> p(pd5<T> pd5Var, pd5.b<T> bVar) {
        t42<pd5, pd5.b, pd5.b> t42Var = f;
        return t42Var != null ? t42Var.a(pd5Var, bVar) : bVar;
    }

    public static void q(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
