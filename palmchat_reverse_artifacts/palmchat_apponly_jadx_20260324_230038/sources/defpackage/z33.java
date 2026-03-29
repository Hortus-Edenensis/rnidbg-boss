package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import defpackage.qx1;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class z33<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed0 f22335a;
    public final mg2 b;
    public final b<T> c;
    public final CopyOnWriteArraySet<c<T>> d;
    public final ArrayDeque<Runnable> e;
    public final ArrayDeque<Runnable> f;
    public final Object g;

    @GuardedBy("releasedLock")
    public boolean h;
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T> {
        void invoke(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T> {
        void a(T t, qx1 qx1Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f22336a;
        public qx1.b b = new qx1.b();
        public boolean c;
        public boolean d;

        public c(T t) {
            this.f22336a = t;
        }

        public void a(int i, a<T> aVar) {
            if (this.d) {
                return;
            }
            if (i != -1) {
                this.b.a(i);
            }
            this.c = true;
            aVar.invoke(this.f22336a);
        }

        public void b(b<T> bVar) {
            if (this.d || !this.c) {
                return;
            }
            qx1 qx1VarE = this.b.e();
            this.b = new qx1.b();
            this.c = false;
            bVar.a(this.f22336a, qx1VarE);
        }

        public void c(b<T> bVar) {
            this.d = true;
            if (this.c) {
                this.c = false;
                bVar.a(this.f22336a, this.b.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f22336a.equals(((c) obj).f22336a);
        }

        public int hashCode() {
            return this.f22336a.hashCode();
        }
    }

    public z33(Looper looper, ed0 ed0Var, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, ed0Var, bVar, true);
    }

    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i, aVar);
        }
    }

    public void c(T t) {
        vh.e(t);
        synchronized (this.g) {
            if (this.h) {
                return;
            }
            this.d.add(new c<>(t));
        }
    }

    @CheckResult
    public z33<T> d(Looper looper, ed0 ed0Var, b<T> bVar) {
        return new z33<>(this.d, looper, ed0Var, bVar, this.i);
    }

    @CheckResult
    public z33<T> e(Looper looper, b<T> bVar) {
        return d(looper, this.f22335a, bVar);
    }

    public void f() {
        m();
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.b.hasMessages(0)) {
            mg2 mg2Var = this.b;
            mg2Var.a(mg2Var.obtainMessage(0));
        }
        boolean z = !this.e.isEmpty();
        this.e.addAll(this.f);
        this.f.clear();
        if (z) {
            return;
        }
        while (!this.e.isEmpty()) {
            this.e.peekFirst().run();
            this.e.removeFirst();
        }
    }

    public final boolean g(Message message) {
        Iterator<c<T>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().b(this.c);
            if (this.b.hasMessages(0)) {
                return true;
            }
        }
        return true;
    }

    public void i(final int i, final a<T> aVar) {
        m();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.d);
        this.f.add(new Runnable() { // from class: t33
            @Override // java.lang.Runnable
            public final void run() {
                z33.h(copyOnWriteArraySet, i, aVar);
            }
        });
    }

    public void j() {
        m();
        synchronized (this.g) {
            this.h = true;
        }
        Iterator<c<T>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().c(this.c);
        }
        this.d.clear();
    }

    public void k(T t) {
        m();
        for (c<T> cVar : this.d) {
            if (cVar.f22336a.equals(t)) {
                cVar.c(this.c);
                this.d.remove(cVar);
            }
        }
    }

    public void l(int i, a<T> aVar) {
        i(i, aVar);
        f();
    }

    public final void m() {
        if (this.i) {
            vh.g(Thread.currentThread() == this.b.getLooper().getThread());
        }
    }

    public z33(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, ed0 ed0Var, b<T> bVar, boolean z) {
        this.f22335a = ed0Var;
        this.d = copyOnWriteArraySet;
        this.c = bVar;
        this.g = new Object();
        this.e = new ArrayDeque<>();
        this.f = new ArrayDeque<>();
        this.b = ed0Var.createHandler(looper, new Handler.Callback() { // from class: w33
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f21600a.g(message);
            }
        });
        this.i = z;
    }
}
