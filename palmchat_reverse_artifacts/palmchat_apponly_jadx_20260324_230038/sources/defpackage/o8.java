package defpackage;

import com.google.common.collect.ImmutableCollection;
import j$.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class o8<InputT, OutputT> extends p8<OutputT> {
    public static final s13 o = new s13(o8.class);
    public ImmutableCollection<? extends r33<? extends InputT>> l;
    public final boolean m;
    public final boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public o8(ImmutableCollection<? extends r33<? extends InputT>> immutableCollection, boolean z, boolean z2) {
        super(immutableCollection.size());
        this.l = (ImmutableCollection) dm4.o(immutableCollection);
        this.m = z;
        this.n = z2;
    }

    public static boolean N(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public static void W(Throwable th) {
        o.a().log(Level.SEVERE, th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    @Override // defpackage.p8
    public final void H(Set<Throwable> set) {
        dm4.o(set);
        if (isCancelled()) {
            return;
        }
        Throwable thA = a();
        Objects.requireNonNull(thA);
        N(set, thA);
    }

    public abstract void O(int i, InputT inputt);

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(int i, Future<? extends InputT> future) {
        try {
            O(i, l46.a(future));
        } catch (ExecutionException e) {
            S(e.getCause());
        } catch (Throwable th) {
            S(th);
        }
    }

    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final void V(ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        int iJ = J();
        dm4.u(iJ >= 0, "Less than 0 remaining futures");
        if (iJ == 0) {
            Y(immutableCollection);
        }
    }

    public abstract void R();

    public final void S(Throwable th) {
        dm4.o(th);
        if (this.m && !B(th) && N(K(), th)) {
            W(th);
        } else if (th instanceof Error) {
            W(th);
        }
    }

    public final void T() {
        Objects.requireNonNull(this.l);
        if (this.l.isEmpty()) {
            R();
            return;
        }
        if (!this.m) {
            final ImmutableCollection<? extends r33<? extends InputT>> immutableCollection = this.n ? this.l : null;
            Runnable runnable = new Runnable() { // from class: n8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19456a.V(immutableCollection);
                }
            };
            o46<? extends r33<? extends InputT>> it = this.l.iterator();
            while (it.hasNext()) {
                r33<? extends InputT> next = it.next();
                if (next.isDone()) {
                    V(immutableCollection);
                } else {
                    next.addListener(runnable, er3.a());
                }
            }
            return;
        }
        o46<? extends r33<? extends InputT>> it2 = this.l.iterator();
        final int i = 0;
        while (it2.hasNext()) {
            final r33<? extends InputT> next2 = it2.next();
            int i2 = i + 1;
            if (next2.isDone()) {
                U(i, next2);
            } else {
                next2.addListener(new Runnable() { // from class: m8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19157a.U(i, next2);
                    }
                }, er3.a());
            }
            i = i2;
        }
    }

    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final void U(int i, r33<? extends InputT> r33Var) {
        try {
            if (r33Var.isCancelled()) {
                this.l = null;
                cancel(false);
            } else {
                P(i, r33Var);
            }
        } finally {
            V(null);
        }
    }

    public final void Y(ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        if (immutableCollection != null) {
            o46<? extends Future<? extends InputT>> it = immutableCollection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Future<? extends InputT> next = it.next();
                if (!next.isCancelled()) {
                    P(i, next);
                }
                i++;
            }
        }
        I();
        R();
        Z(a.ALL_INPUT_FUTURES_PROCESSED);
    }

    public void Z(a aVar) {
        dm4.o(aVar);
        this.l = null;
    }

    @Override // defpackage.e1
    public final void m() {
        super.m();
        ImmutableCollection<? extends r33<? extends InputT>> immutableCollection = this.l;
        Z(a.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean zD = D();
            o46<? extends r33<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                it.next().cancel(zD);
            }
        }
    }

    @Override // defpackage.e1
    public final String x() {
        ImmutableCollection<? extends r33<? extends InputT>> immutableCollection = this.l;
        if (immutableCollection == null) {
            return super.x();
        }
        return "futures=" + immutableCollection;
    }
}
