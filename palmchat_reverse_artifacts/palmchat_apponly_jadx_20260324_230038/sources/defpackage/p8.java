package defpackage;

import com.google.common.collect.k0;
import defpackage.e1;
import j$.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class p8<OutputT> extends e1.j<OutputT> {
    public static final b j;
    public static final s13 k = new s13(p8.class);
    public volatile Set<Throwable> h = null;
    public volatile int i;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b {
        public b() {
        }

        public abstract void a(p8<?> p8Var, Set<Throwable> set, Set<Throwable> set2);

        public abstract int b(p8<?> p8Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<? super p8<?>, ? super Set<Throwable>> f19958a;
        public final AtomicIntegerFieldUpdater<? super p8<?>> b;

        public c(AtomicReferenceFieldUpdater<? super p8<?>, ? super Set<Throwable>> atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater<? super p8<?>> atomicIntegerFieldUpdater) {
            super();
            this.f19958a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // p8.b
        public void a(p8<?> p8Var, Set<Throwable> set, Set<Throwable> set2) {
            p1.a(this.f19958a, p8Var, set, set2);
        }

        @Override // p8.b
        public int b(p8<?> p8Var) {
            return this.b.decrementAndGet(p8Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends b {
        public d() {
            super();
        }

        @Override // p8.b
        public void a(p8<?> p8Var, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (p8Var) {
                if (p8Var.h == set) {
                    p8Var.h = set2;
                }
            }
        }

        @Override // p8.b
        public int b(p8<?> p8Var) {
            int iG;
            synchronized (p8Var) {
                iG = p8.G(p8Var);
            }
            return iG;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b dVar;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            dVar = new c(AtomicReferenceFieldUpdater.newUpdater(p8.class, Set.class, "h"), AtomicIntegerFieldUpdater.newUpdater(p8.class, "i"));
        } catch (Throwable th2) {
            dVar = new d();
            th = th2;
        }
        j = dVar;
        if (th != null) {
            k.a().log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public p8(int i) {
        this.i = i;
    }

    public static /* synthetic */ int G(p8 p8Var) {
        int i = p8Var.i - 1;
        p8Var.i = i;
        return i;
    }

    public abstract void H(Set<Throwable> set);

    public final void I() {
        this.h = null;
    }

    public final int J() {
        return j.b(this);
    }

    public final Set<Throwable> K() {
        Set<Throwable> set = this.h;
        if (set != null) {
            return set;
        }
        Set<Throwable> setF = k0.f();
        H(setF);
        j.a(this, null, setF);
        Set<Throwable> set2 = this.h;
        Objects.requireNonNull(set2);
        return set2;
    }
}
